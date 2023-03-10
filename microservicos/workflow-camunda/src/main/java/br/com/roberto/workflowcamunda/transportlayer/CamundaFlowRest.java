package br.com.roberto.workflowcamunda.transportlayer;

import br.com.roberto.workflowcamunda.config.util.EngineUtil;
import br.com.roberto.workflowcamunda.exception.ExceptionUtil;
import br.com.roberto.workflowcamunda.exception.ResourceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/camunda")
public class CamundaFlowRest {

    private static final Logger log = LoggerFactory.getLogger(CamundaFlowRest.class);
    private String bussinessKey;
    @GetMapping
    public void teste(){
        final VariableMap variables = Variables.createVariables();
        final ObjectMapper mapper = new ObjectMapper();
        ProcessInstanceWithVariables instance;

        try{
            bussinessKey = UUID.randomUUID().toString();
            TresValores tresValores = new TresValores(4,2,0);

            String tresValoresString = mapper.writeValueAsString(tresValores).replace("\"","\'");
            variables.putValue("BUSSINESS_KEY", bussinessKey);
            variables.putValue("JSON_TRES_VALORES",  Variables.objectValue(tresValoresString));


            instance = EngineUtil.getInstance().getRuntimeEngine().createProcessInstanceByKey("Process_00up7bv")
                    .businessKey(bussinessKey.toString())
                    .setVariables(variables)
                    .executeWithVariablesInReturn();

            System.out.println(variables);





        }catch (Exception e) {
            log.error(MensagemDataSource.Erro.LOG, e.getMessage(), e.getCause(), e.getStackTrace());
            ResourceException resourceException =  ExceptionUtil.generateException(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    MensagemDataSource.MessageDataSource.INTERNAL_ERROR_EXCEPTION, e.getMessage(),
                    MensagemDataSource.Origem.SERVICE_ABERTURA_DE_CONTA);
            throw resourceException;
        }

        lancaExceptionEmCasoDeErroNoProcesso(instance.getVariables().entrySet().stream().filter(erro -> erro.getKey().contains("VARIABLE_C")).collect(Collectors.toUnmodifiableList()));

//        return preencheResponse(instance.getProcessInstanceId(),
//                instance.getVariables().get(bussinessKey).toString());
    }

    private void lancaExceptionEmCasoDeErroNoProcesso(List<Map.Entry<String, Object>> errorList) throws ResourceException {
        for (Map.Entry<String, Object> entry: errorList) {
            ResourceException resourceException;
            try {
                resourceException = ExceptionUtil.generateExceptionFormJson(entry.getValue().toString());
                throw resourceException;
            } catch (JsonProcessingException e) {
                ResourceException jsonException =  ExceptionUtil.generateException(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                        MensagemDataSource.MessageDataSource.ERRO_JSON_EXCEPTION, e.getMessage(),
                        MensagemDataSource.Origem.ERRO_TASK2_C);
                throw jsonException;
            }
        }
    }

//    private void preencheResponse(String processInstanceId, String bussinessKey) throws ResourceException {
//
//    }



}
