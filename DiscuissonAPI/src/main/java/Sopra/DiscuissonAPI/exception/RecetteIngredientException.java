package Sopra.DiscuissonAPI.exception;

public class RecetteIngredientException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecetteIngredientException() {

	}
	
	public RecetteIngredientException(String string) {
		super("Exception RecetteIngredient" + string);
	}
}
