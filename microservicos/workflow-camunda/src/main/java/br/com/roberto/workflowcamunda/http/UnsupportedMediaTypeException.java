package br.com.roberto.workflowcamunda.http;


import br.com.roberto.workflowcamunda.exception.ResourceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UnsupportedMediaTypeException extends ResourceException {
        private static final long serialVersionUID = 1L;
        private String code;
        private String message;
        private String developerMessage;
        private String origin;

        @Override
        public String toString() {
            return "UnsupportedMediaTypeException{" +
                    "code='" + code + '\'' +
                    ", message='" + message + '\'' +
                    ", developerMessage='" + developerMessage + '\'' +
                    ", origin='" + origin + '\'' +
                    '}';
        }
}
