package cft.path;


public class CoordGenerator {

	public static Coord[] generateToCoords(Coord from, int angle, Double length) {
		// general form of line function
		Double a,b,c;
		a = b = c = 0.0D;
		
		// result coordinates
		Double x1,y1, x2, y2;
		x1 = y1 = x2 = y2 = 0.0D;
		
		// parallel to y axis
		if (angle == 90 || angle == 270) {
			a = 1.0D;
			b = 0.0D;
			c = -from.getX();
		
			x1 = x2 = from.getX();
			y1 = from.getY() - length;
			y2 = from.getY() + length;
			
		// regular case
		} else {
			a = Math.tan(Math.toRadians((double) angle));
			b = -1.0D;
			c = from.getY() - a * from.getX();
			
			x1 = from.getX() - (length / Math.sqrt(1 + a * a));
			x2 = from.getX() + (length / Math.sqrt(1 + a * a));
			y1 = a * x1 + c;
			y2 = a * x2 + c;
		}
		
		Coord[] coords = new Coord[]{new Coord(x1, y1), new Coord(x2, y2)};
		return coords;
	}
	
}
