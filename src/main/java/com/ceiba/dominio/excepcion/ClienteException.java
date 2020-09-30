package com.ceiba.dominio.excepcion;

public class ClienteException extends RuntimeException {
    public enum Type {
        CLIENTE_NOT_FOUND("El Cliente no se encuentra registrado", 404),
        CLIENT_NOT_UPDATE("El cliente no se puede actualizar", 412),
        BILLING_NOT_UPDATE("No se puso realizar el abono", 404),
        PAY_NOT_OK("Lo abononado no es la cantidad ha pagar", 404);

        private String message;
        private Integer status;

        public ClienteException build() {
            return new ClienteException(this);
        }

        Type(String message, Integer status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public Integer getStatus() {
            return status;
        }
    }

    private final Type type;

    private ClienteException(Type type) {
        super(type.message);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
