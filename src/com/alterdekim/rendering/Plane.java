package com.alterdekim.rendering;

public class Plane extends Object3D {
	public Plane(Vector3 position) {
		super(position);
	}
	
	@Override
	public double calculateSDF( Vector3 position ) {
		return (position.y *(-1)) + 1.0 + this.getY();
	}
}
