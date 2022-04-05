package com.alterdekim.rendering;

public class LambertLight extends Light {

	public LambertLight(Vector3 position) {
		super(position);
	}
	
	@Override
	public double calculateBrightness( Vector3 rd, Vector3 ro, Vector3 normal, double d ) {
		Vector3 lightDirection = this.calculateLightDirection(rd, ro, normal, d);
		return Utils.clamp(lightDirection.dot(normal), 0.0, 1.0);
	}
	
	@Override
	public Vector3 calculateLightDirection( Vector3 rd, Vector3 ro, Vector3 normal, double d ) {
		return new Vector3( this.getX(), this.getY(), this.getZ() ).subtract(rd.multiply(d).sum(ro)).normalize();
	}
}