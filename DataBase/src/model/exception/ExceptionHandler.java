package model.exception;

/**
 * This class get error messages to simplify it
 */
public class ExceptionHandler {
	
	/**
	 * This method analyse error message and cut the useless parts
	 * @param message the error message
	 * @return the simplified error message
	 */
	public static String analyse (String message) {
		String ret = message;
		String[] tab = ret.split(":\\s");
		tab = tab[1].split("\\s\\(");
		ret = tab[0];
		return ret;		
	}
	
}
