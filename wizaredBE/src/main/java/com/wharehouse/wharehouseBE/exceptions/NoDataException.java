package com.wharehouse.wharehouseBE.exceptions;

public class NoDataException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoDataException(String message) {
        super(message);
    }

    public NoDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
