package cft.calc;

import cft.base.Config;

public class Circle {
	
	private static int getSegment(Double param) {
		Double angle = param % Config.circleRadius;
		Double segmentDouble = Math.ceil(angle / (double) Config.segmentAngle);
		return segmentDouble.intValue();
	}

	public static Integer getAngle(Double param) {
		if (param == null) {
			return null;
		}

		int segment = getSegment(param);
		
		if (segment == Config.circleSegments) {
			return 0;
		} else {
			return segment * Config.segmentAngle;
		}
	}
	
	public static Boolean getBoolean(Double param) {
		if (param == null) {
			return null;
		}
		
		int segment = getSegment(param);
		
		if (segment % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
