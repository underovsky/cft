package cft.base;

public class Colour {
	
	private Integer r;
	private Integer g;
	private Integer b;
	
	public Colour(Integer r, Integer g, Integer b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public String buildColour() {
		return "rgb(" + this.r + "," +this.g + "," + this.b + ")";
	}
	
}
