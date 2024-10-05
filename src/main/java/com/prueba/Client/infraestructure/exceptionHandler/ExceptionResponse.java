package com.prueba.Client.infraestructure.exceptionHandler;

public enum ExceptionResponse {

    DOCUMENT_TYPE_NOT_FOUND("No ingreso un tipo de documento valido"),
    USER_NOT_FOUND("No se encontro usuario con tipo y/o numero de documento seleccionados");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
