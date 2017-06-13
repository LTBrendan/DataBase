package exception;

public class ExceptionHandler {
	
	public static String analyse (String message) {
		String ret = message;
		String[] tab = ret.split(":\\s");
		tab = tab[1].split("\\s\\(");
		ret = tab[0];
		return ret;		
	}
	
}
