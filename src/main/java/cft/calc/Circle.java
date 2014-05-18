package cft.calc;

import cft.base.Config;
import cft.logger.Logger;

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
			Logger.log("Circle.getAngle, angle: " + 0 + " for param: " + param);
			return 0;
		} else {
			Logger.log("Circle.getAngle, angle: " + segment * Config.segmentAngle+ " for param: " + param);
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
