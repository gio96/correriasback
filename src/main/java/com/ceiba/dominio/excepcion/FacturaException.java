package com.ceiba.dominio.excepcion;

public class FacturaException extends RuntimeException {
    public enum Type {
        NO_VENDER("No se pueden vender productos en esta fecha", 404),
        NO_VALUES_FULL("Valores obligatorios faltantes", 412);

        private String message;
        private Integer status;

        public FacturaException build() {
            return new FacturaException(this);
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

    private FacturaException(Type type) {
        super(type.message);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
