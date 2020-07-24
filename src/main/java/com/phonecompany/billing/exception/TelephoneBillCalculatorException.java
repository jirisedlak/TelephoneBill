package com.phonecompany.billing.exception;

public class TelephoneBillCalculatorException extends RuntimeException {

    public TelephoneBillCalculatorException(String message) {
        super(message);
    }

    public TelephoneBillCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

}
