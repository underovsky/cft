package cft.path;

public class Node {

	private Coord from;
	private Coord to;
	
	private Double priority;
	
	private int angle;
	private Double width;
	private Double length;
	
	public Node(Coord from, Coord to, Double priority, int angle, Double width, Double length) {
		this.from = from;
		this.to = to;
		
		this.priority = priority;
		
		this.angle = angle;	
		this.width = width;
		this.length = length;
	}

	public Coord getFrom() {
		return from;
	}

	public void setFrom(Coord from) {
		this.from = from;
	}

	public Coord getTo() {
		return to;
	}

	public void setTo(Coord to) {
		this.to = to;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public Double getPriority() {
		return priority;
	}

	public void setPriority(Double priority) {
		this.priority = priority;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}
	
}
