package Sopra.DiscuissonAPI.exception;

public class MessageException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageException() {

	}

	public MessageException(String message) {
		super(message);
	}
}
