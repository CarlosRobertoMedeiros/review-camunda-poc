package br.com.roberto.workflowcamunda.config.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrquestradorProcessVariables {
    public static final String ABERTURA_DE_CONTA_PROCESS_NAME = "negocio-abertura-conta";
    public static final String BUSSINESS_KEY = "BUSSINESS_KEY";
    public static final String JSON_REQ_ABERTURA_CONTA = "JSON_REQ_ABERTURA_CONTA";
    public static final String DEBITO_CARTAO = "debito_cartao";
    public static final String EMPRESTIMO = "emprestimo";
    public static final String RENDA = "renda";


    public static final String TELEFONE = "telefone";
    public static final String TELEFONE_FRAUDADO = "telefoneFraudado";
    public static final String CEP_FRAUDADO = "cepFraudado";
    public static final String EMAIL_FRAUDADO = "emailFraudado";
    public static final String  INSERIR_POSITIVO = "inserirPositivo";
    public static final String  INSERIR_NEGATIVADO = "inserirNegativado";
    public static final String INSERIR_CLIENTE = "inserirCliente";
    public static final String ENVIAR_EMAIL = "enviarEmail";

    public static final String EMAIL = "email";
    public static final String CEP = "cep";



    public static final String JSON_REQUSICAO_ABERTURA_CONTA = "jsonReqAberturaConta";
    public static final String JSON_RESP_ABERTURA_CONTA = "jsonRespAberturaConta";

}
