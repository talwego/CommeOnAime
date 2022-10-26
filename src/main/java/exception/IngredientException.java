package exception;

public class IngredientException extends RuntimeException {
	public IngredientException(String string) {
		super("Exception Ingredient" + string);
	}
}
