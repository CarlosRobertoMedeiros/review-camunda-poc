package br.com.roberto.workflowcamunda.transportlayer.task;

import br.com.roberto.workflowcamunda.transportlayer.TresValores;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.BpmnModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Task2 implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(Task2.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        try {

            log.info("Task2 Inicializada");
            ObjectMapper mapper = new ObjectMapper();

            String bussinessKey = delegateExecution.getVariable("BUSSINESS_KEY").toString();
            String tresValores = delegateExecution.getVariable("JSON_TRES_VALORES").toString();

            Gson gson = new Gson();
            TresValores tresValores1 = gson.fromJson(tresValores, TresValores.class);
            throw new BpmnError("ERRO_TASK2_C","ERRO_TASK2_M");

        }catch (BpmnError ex){
            log.info("Entrou na exceção task2");
//            delegateExecution.setVariable("VARIABLE_C","ERRO_TASK2_C");
//            delegateExecution.setVariable("VARIABLE_M","ERRO_TASK2_M");
            throw new BpmnError("ERRO_TASK2_C","ERRO_TASK2_M");
        }catch (BpmnModelException e){
            log.info("Entrou na exceção task2");
            delegateExecution.setVariable("ERRO_TECNICO",Task1.class.getSimpleName());
            throw new BpmnError("ERRO_TASK2_C","ERRO_TASK2_M");
        }finally {
            log.info("Task2 Finalizada");
        }

    }
}
