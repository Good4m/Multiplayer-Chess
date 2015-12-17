package com.satecha.chessgame;

/**
 * Static class with some useful math functions
 */
public class Utilities {
	private Utilities() {}

    public static double angleBetweenTwoPoints(double x1, double x2, double y1, double y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        return angle;
    }

	public static double distanceBetweenTwoPoints(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
