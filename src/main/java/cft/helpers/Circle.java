package cft.helpers;

import cft.base.Config;

public class Circle {

	public static Integer getAngle(Double param) {
		if (param == null) {
			return null;
		}
		
		Double angle = param % Config.circleRadius;
		Double segmentDouble = Math.ceil(angle / (double) Config.segmentAngle);
		int segment = segmentDouble.intValue();
		return segment * Config.segmentAngle;
	}
	
}
