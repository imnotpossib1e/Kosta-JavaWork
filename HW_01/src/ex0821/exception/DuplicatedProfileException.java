package ex0821.exception;

public class DuplicatedProfileException extends RuntimeException {

    public DuplicatedProfileException(String message) {
        super(message);
    }
}
