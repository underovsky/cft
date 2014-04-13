package cft;

import cft.base.Colour;
import cft.base.Coord;
import cft.helpers.Circle;
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
		
		// fibonacci test
		for (int i = 0; i < 20; ++i) {
			System.out.println(FibonacciGenerator.getPrevious());
			System.out.println(FibonacciGenerator.getCurrent());
			System.out.println(FibonacciGenerator.getGoldenRatio());
			FibonacciGenerator.iterate();
		}
		
		// wheel test
		System.out.println(Circle.getAngle(1200.0D));
		System.out.println(Circle.getAngle(4.5D));
		System.out.println(Circle.getAngle(15.0D));
		System.out.println(Circle.getAngle(271.0D));
		System.out.println(Circle.getAngle(0.0D));
	}
	
}
