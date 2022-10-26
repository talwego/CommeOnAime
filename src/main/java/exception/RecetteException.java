package exception;

public class RecetteException extends RuntimeException {
	public RecetteException(String string) {
		super("Exception Recette" + string);
	}
}
