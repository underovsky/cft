package cft.helpers;

import cft.base.Coord;

public class CoordGenerator {

	// TODO: generate coords for line endpoint
	public static Coord generateTo(Coord from, int angle, Double length) {
		Double x, y;
		x = y = 0.0D;
		
		Double a = Math.tan(Math.toRadians((double) angle));
		Double b = from.getY() - a * from.getX();
		
		return new Coord(x, y);
	}
	
}
