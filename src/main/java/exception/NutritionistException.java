package exception;

public class NutritionistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NutritionistException() {
		
	}
	
	public NutritionistException(String nutritionist) {
		super(nutritionist);
	}
}
