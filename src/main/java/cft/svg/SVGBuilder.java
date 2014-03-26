package cft.svg;

import cft.base.Colour;
import cft.base.Coord;
import cft.helpers.TextFormatter;

public class SVGBuilder {
	
	private String content;
	private String header;
	private String footer;
	private Colour colour;
	
	public SVGBuilder(Integer width, Integer height, Colour colour) {
		this.header = "<?xml version=\"1.0\" standalone=\"no\"?>"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">"
				+ "<svg width=\"" + width + "\" height=\"" + height + "\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">";
		this.footer = "</svg>";
		this.content = "";
		this.colour = colour;
	}
	
	public void drawLine(Coord from, Coord to, Double width) {
		this.content += "<line x1=\"" + TextFormatter.formatDouble(from.getX()) + "\" y1=\"" + TextFormatter.formatDouble(from.getY())
				+ "\" x2=\"" + TextFormatter.formatDouble(to.getX()) + "\" y2=\"" + TextFormatter.formatDouble(from.getY())
				+ "\" style=\"stroke:" + this.colour.buildColour() + "; stroke-width:" + TextFormatter.formatDouble(width) + "\" />";
	}
	
	public void drawDot(Coord middle, Double radius) {
		this.content += "<circle cx=\"" + TextFormatter.formatDouble(middle.getX()) + "\" cy=\"" + TextFormatter.formatDouble(middle.getY()) 
				+ "\" r=\"" + TextFormatter.formatDouble(radius) + "\" fill=\"" + this.colour.buildColour() + "\" />";
	}
	
	public String buildSVG() {
		return header + content + footer;
	}
	
}
