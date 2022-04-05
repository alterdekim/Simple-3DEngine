package com.alterdekim.rendering;

public class Octahedron extends Object3D {
	
	private double size;

	public Octahedron(Vector3 position, double size) {
		super(position);
		this.size = size;
	}
	
	public double getSize() {
		return this.size;
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
		position = new Vector3(Math.abs(position.x), Math.abs(position.y), Math.abs(position.z));
		return (position.x+position.y+position.z-size)*0.57735027;
	}

}
