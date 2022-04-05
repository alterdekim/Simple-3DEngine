package com.alterdekim.rendering;

public class Sphere extends Object3D {
	
	private double radius;
	
	public Sphere( Vector3 position, double radius ) {
		super( position );
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	@Override
	public double calculateSDF( Vector3 position ) {
		if( this.getEulerX() != 0 ) {
			position = position.cross(Utils.rotateX(Math.toRadians(this.getEulerX())));
		}
		if( this.getEulerY() != 0 ) {
			position = position.cross(Utils.rotateY(Math.toRadians(this.getEulerY())));
		}
		if( this.getEulerZ() != 0 ) {
			position = position.cross(Utils.rotateZ(Math.toRadians(this.getEulerZ())));
		}
		return position.subtract(this.getPosition()).length() - this.getRadius();
	}
}
