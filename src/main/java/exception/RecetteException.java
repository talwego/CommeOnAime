package exception;

public class RecetteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecetteException() {

	}
	
	public RecetteException(String string) {
		super("Exception Recette" + string);
	}
}
