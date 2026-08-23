package ex0821.exception;

public class SearchNotFoundException extends RuntimeException {

    public SearchNotFoundException(String message) {
        super(message);
    }
}
