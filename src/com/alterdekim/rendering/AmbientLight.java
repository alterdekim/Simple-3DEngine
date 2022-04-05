package com.alterdekim.rendering;

public class AmbientLight extends Light {
 
	public AmbientLight(Vector3 position) {
		super(position);
	}

	@Override
	public double calculateBrightness( Vector3 rd, Vector3 ro, Vector3 normal, double d ) {
		return 1.0;
	}
}
