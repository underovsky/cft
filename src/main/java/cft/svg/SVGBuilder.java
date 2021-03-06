package cft.svg;

import cft.base.Colour;
import cft.helpers.TextFormatter;
import cft.path.Coord;

public class SVGBuilder {
	
	private StringBuffer content;
	private String header;
	private String footer;
	private Colour colour;
	
	public SVGBuilder(Integer width, Integer height, Colour colour) {
		this.header = "<?xml version=\"1.0\" standalone=\"no\"?>"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">"
				+ "<svg width=\"" + width + "\" height=\"" + height + "\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">";
		this.footer = "</svg>";
		this.content = new StringBuffer();
		this.colour = colour;
	}
	
	public void drawLine(Coord from, Coord to, Double width) {
		content.append("<line x1=\"" + TextFormatter.formatDouble(from.getX()) + "\" y1=\"" + TextFormatter.formatDouble(from.getY())
				+ "\" x2=\"" + TextFormatter.formatDouble(to.getX()) + "\" y2=\"" + TextFormatter.formatDouble(to.getY())
				+ "\" style=\"stroke:" + colour.buildColour() + "; stroke-width:" + TextFormatter.formatDouble(width) + "\" />");
	}
	
	public void drawDot(Coord middle, Double radius) {
		content.append("<circle cx=\"" + TextFormatter.formatDouble(middle.getX()) + "\" cy=\"" + TextFormatter.formatDouble(middle.getY()) 
				+ "\" r=\"" + TextFormatter.formatDouble(radius) + "\" fill=\"" + colour.buildColour() + "\" />");
	}
	
	public void drawRect(Coord from, Double width, Double height) {
		content.append("<rect x=\"" + TextFormatter.formatDouble(from.getX()) + "\" y=\"" + TextFormatter.formatDouble(from.getY()) 
				+ "\" width=\"" + TextFormatter.formatDouble(width) + "\" height=\"" + TextFormatter.formatDouble(height) 
				+ "\" style=\"fill:" + colour.buildColour() + "\" />");
	}
	
	public String buildSVG() {
		return header + content.toString() + footer;
	}
	
}
