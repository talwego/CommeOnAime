package exception;

public class RecetteIngredientException extends RuntimeException {
	public RecetteIngredientException(String string) {
		super("Exception RecetteIngredient" + string);
	}
}
