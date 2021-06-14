package hu.flowacademy.springvizsga.exception;

public class ValidateException extends RuntimeException {
    public ValidateException(String msg) {
        super(msg);
    }
}
