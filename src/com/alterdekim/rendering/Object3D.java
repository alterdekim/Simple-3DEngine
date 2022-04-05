package com.alterdekim.rendering;

public class Object3D {
	
	private double x;
	private double y;
	private double z;
	private double rotationX = 0;
	private double rotationY = 0;
	private double rotationZ = 0;
	private Material mat = new Material(new MaterialColor(0,0,0));
	
	public Object3D( Vector3 position ) {
		this.x = position.x;
		this.y = position.y; 
		this.z = position.z;
	}
	
	public void setMaterial( Material mat ) {
		this.mat = mat;
	}
	
	public Material getMaterial() {
		return this.mat;
	}
	
	public void setPosition( Vector3 position ) {
		this.x = position.x;
		this.y = position.y;
		this.z = position.z;
	}
	
	public void setRotationX( double x ) {
		this.rotationX = x;
	}

	public void setRotationY( double y ) {
		this.rotationY = y;
	}

	public void setRotationZ( double z ) {
		this.rotationZ = z;
	}
	
	public double getEulerX() {
		return this.rotationX;
	}
	
	public double getEulerY() {
		return this.rotationY;
	}
	
	public double getEulerZ() {
		return this.rotationZ;
	}
	
	public Vector3 getPosition() {
		return new Vector3( this.x, this.y, this.z );
	}
	
	public void setX( double x ) {
		this.x = x;
	}
	
	public void setY( double y ) {
		this.y = y;
	}
	
	public void setZ( double z ) {
		this.z = z;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}

	public double calculateSDF(Vector3 position) {
		return 0;
	}
}
