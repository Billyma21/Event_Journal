package be.iccbxl.poo;

public class MissingTopicException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public MissingTopicException(String message) {
        super(message);
    }
}