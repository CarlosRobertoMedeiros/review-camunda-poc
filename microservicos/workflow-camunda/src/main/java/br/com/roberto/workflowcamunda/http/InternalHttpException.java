package br.com.roberto.workflowcamunda.http;


import br.com.roberto.workflowcamunda.exception.ResourceException;
import org.springframework.http.HttpStatus;

public class InternalHttpException extends ResourceException {

    private final HttpStatus httpStatusCode;

    public InternalHttpException(
            String userMessage,
            String developerMessage,
            HttpStatus httpStatusCode,
            String origin
    ) {

        super(userMessage, developerMessage, String.valueOf(httpStatusCode.value()), origin);
        this.httpStatusCode = httpStatusCode;
    }

    public InternalHttpException(HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatus getStatus() {
        return httpStatusCode;
    }

}
