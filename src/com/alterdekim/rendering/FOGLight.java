package com.alterdekim.rendering;

public class FOGLight extends Light {

	public FOGLight(Vector3 position) {
		super(position);
	}
	
	@Override
	public double calculateBrightness( Vector3 rd, Vector3 ro, Vector3 normal, double d ) {
		return 1.0 - Utils.clamp( Utils.rangeConvert( d, 0, 3.6, 0, 1 ), 0.0, 1.0 );
	}
}
