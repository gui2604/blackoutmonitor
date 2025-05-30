package br.com.fiap.blackoutmonitor.exception;

@SuppressWarnings("serial")
public class InvalidCEPException extends RuntimeException {
    public InvalidCEPException(String message) {
        super(message);
    }
}

