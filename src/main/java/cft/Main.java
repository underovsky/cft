package cft;

import cft.base.Colour;
import cft.base.Coord;
import cft.helpers.Circle;
import cft.helpers.CoordGenerator;
import cft.helpers.FibonacciGenerator;
import cft.svg.SVGBuilder;
import cft.svg.SVGGenerator;

public class Main {
	
	public static void main(String[] args) {
		// svg test
		Colour colour = new Colour(0, 0, 0);
		SVGBuilder svgBuilder = new SVGBuilder(50, 50, colour);
		svgBuilder.drawDot(new Coord(10.0, 10.0), 2.0);
		svgBuilder.drawLine(new Coord(1.0, 1.0), new Coord(20.0, 20.0), 4.0);
		svgBuilder.drawRect(new Coord(14.0, 14.0), 10.0, 12.0);
		// SVGGenerator.generateFile(svgBuilder.buildSVG());
		
		// coord generator test
		Coord[] coords = CoordGenerator.generateToCoords(new Coord(1.0D, 2.0D), 45, Math.sqrt(2.0));
		System.out.println(Math.round(coords[0].getX()) + " " + Math.round(coords[0].getY()));
		System.out.println(Math.round(coords[1].getX()) + " " + Math.round(coords[1].getY()));
	}
	
}
