package cft.base;

public class Config {
	
	public static int subIndex = 2;
	public static int maxIterations = 20;
	public static int branchNum = 2;
	public static int startPathsNum = 2;
	public static Double startingLivingRatio = 100D;
	
	public static int branchingRatioIndex = 20;
	public static int livingRatioIndex = 5;
	
	public static int circleRadius = 360;
	public static int circleSegments = 12;
	public static int segmentAngle = circleRadius / circleSegments;
	
	public static int canvasSize = 1000;
	public static Double middlePoint = new Double(canvasSize / 2);
	public static Double fixedWidth = 1.0D;
	
}
