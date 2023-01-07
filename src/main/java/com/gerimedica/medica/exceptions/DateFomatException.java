package com.gerimedica.medica.exceptions;

public class DateFomatException extends Exception{
    private String errorMessage;
    public DateFomatException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
