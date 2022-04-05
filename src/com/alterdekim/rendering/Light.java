package com.alterdekim.rendering;

public class Light {
	
	private double x;
	private double y;
	private double z;
	
	public Light( Vector3 position ) {
		this.x = position.x;
		this.y = position.y; 
		this.z = position.z;
	}
	
	public void setPosition( double x, double y, double z ) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setPosition( Vector3 position ) {
		this.x = position.x;
		this.y = position.y;
		this.z = position.z;
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
	
	public double calculateBrightness( Vector3 rd, Vector3 ro, Vector3 normal, double d ) {
		return 0;
	}
	
	public Vector3 calculateLightDirection( Vector3 rd, Vector3 ro, Vector3 normal, double d ) {
		return new Vector3(0,0,0);
	}
}
