package cft;

import cft.base.Colour;
import cft.base.Coord;
import cft.svg.SVGBuilder;
import cft.svg.SVGGenerator;

public class Main {
	
	public static void main(String[] args) {
		Colour colour = new Colour(0, 0, 0);
		SVGBuilder svgBuilder = new SVGBuilder(50, 50, colour);
		svgBuilder.drawDot(new Coord(10.0, 10.0), 2.0);
		svgBuilder.drawDot(new Coord(20.0, 20.0), 6.0);
		SVGGenerator.generateFile(svgBuilder.buildSVG());
	}
	
}
