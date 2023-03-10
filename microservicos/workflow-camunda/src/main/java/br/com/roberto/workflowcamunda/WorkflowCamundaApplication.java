package br.com.roberto.workflowcamunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class WorkflowCamundaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowCamundaApplication.class, args);
	}

}
