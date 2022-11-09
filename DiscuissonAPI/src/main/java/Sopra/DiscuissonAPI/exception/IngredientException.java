package Sopra.DiscuissonAPI.exception;

public class IngredientException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IngredientException() {
		
	}
	
	public IngredientException(String string) {
		super("Exception Ingredient" + string);
	}
}
