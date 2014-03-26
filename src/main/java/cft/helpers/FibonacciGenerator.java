package cft.helpers;

public class FibonacciGenerator {

	private static final Long first = 0L;
	private static final Long second = 1L;
	
	private static Long previous = first;
	private static Long current = second;
	
	public static void iterate() {
		Long newCurrent = previous + current;
		previous = current;
		current = newCurrent;
	}
	
	public static Double getGoldenRatio() {
		if (previous.equals(0L)) {
			return null;
		}
		
		return ((double) current / (double) previous);
	}
	
	public static Long getPrevious() {
		return previous;
	}	
	
	public static Long getCurrent() {
		return current;
	}
	
}
