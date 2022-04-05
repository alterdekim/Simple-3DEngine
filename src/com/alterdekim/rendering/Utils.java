package com.alterdekim.rendering;

import java.util.ArrayList;

public class Utils {
	
	public static double rangeConvert( double value, double leftMin, double leftMax, double rightMin, double rightMax ) {
	    double leftSpan = leftMax - leftMin;
	    double rightSpan = rightMax - rightMin;
	    double valueScaled = (value - leftMin) / (leftSpan);
	    return rightMin + (valueScaled * rightSpan);
	}
	
	public static double clamp( double value, double MIN_VALUE, double MAX_VALUE ) {
		return (value > MAX_VALUE ? MAX_VALUE : value < MIN_VALUE ? MIN_VALUE : value);
	}
	
	public static ArrayList<Vector3> rotateX(double theta) {
	    double c = Math.cos(theta);
	    double s = Math.sin(theta);
	    ArrayList<Vector3> v = new ArrayList<Vector3>();
	    v.add(new Vector3(1, 0, 0));
	    v.add(new Vector3(0, c, -s));
	    v.add(new Vector3(0, s, c));
	    return v;
	}
	
	public static ArrayList<Vector3> rotateY(double theta) {
	    double c = Math.cos(theta);
	    double s = Math.sin(theta);
	    ArrayList<Vector3> v = new ArrayList<Vector3>();
	    v.add(new Vector3(c, 0, s));
	    v.add(new Vector3(0, 1, 0));
	    v.add(new Vector3(-s, 0, c));
	    return v;
	}
	
	public static ArrayList<Vector3> rotateZ(double theta) {
		double c = Math.cos(theta);
		double s = Math.sin(theta);
		ArrayList<Vector3> v = new ArrayList<Vector3>();
		v.add(new Vector3(c, -s, 0));
		v.add(new Vector3(s, c, 0));
		v.add(new Vector3(0, 0, 1));
	    return v;
	}
}
