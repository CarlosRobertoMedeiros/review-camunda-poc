package br.com.roberto.workflowcamunda.transportlayer.task;

import br.com.roberto.workflowcamunda.transportlayer.TresValores;
import com.google.gson.Gson;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.BpmnModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Task1 implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(Task1.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        try {
            log.info("Task1 Inicializada");

            String tresValores = delegateExecution.getVariable("JSON_TRES_VALORES").toString();

            Gson gson = new Gson();
            TresValores tresValores1 = gson.fromJson(tresValores, TresValores.class);
            log.info("Funcionou o primeiro =>"+String.valueOf(tresValores1.getValorUm()/tresValores1.getValordois()));

        }catch (BpmnModelException e){
            log.info("Entrou na exceção task1");
            delegateExecution.setVariable("ERRO_TECNICO",Task1.class.getSimpleName());
            throw new BpmnError("ERRO_TASK2_C","ERRO_TASK2_M");
        }
        log.info("Task1 Finalizada");

    }
}
