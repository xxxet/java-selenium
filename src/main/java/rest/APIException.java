package rest;

public class APIException extends RuntimeException {
    public APIException(String error) {
        super(error);
    }
}
