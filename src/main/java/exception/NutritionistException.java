package exception;

public class NutritionistException extends RuntimeException{
	 
		public NutritionistException(String nutritionist) {
			super(nutritionist);
		}
		
		public NutritionistException() {
			super();
		}
	}
