package Sopra.DiscuissonAPI.exception;

public class IdException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdException() {
		super("id inconnu");
	}
}
