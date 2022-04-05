package com.alterdekim.rendering;

import java.util.ArrayList;

public class Vector3 {
	
	public double x;
	public double y;
	public double z;
	
	public Vector3( double x, double y, double z ) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3 subtract( Vector3 s ) {
		return new Vector3( this.x - s.x, this.y - s.y, this.z - s.z );
	}
	
	public Vector3 multiply( double num ) {
		return new Vector3( this.x * num, this.y * num, this.z * num );
	}
	
	public Vector3 divide( double num ) {
		return new Vector3( this.x / num, this.y / num, this.z / num );
	}
	
	public Vector3 sum( Vector3 s ) {
		return new Vector3( this.x + s.x, this.y + s.y, this.z + s.z );
	}
	
	public double dot( Vector3 s ) {
		return (this.x * s.x) + (this.y * s.y) + (this.z * s.z);
	}
	
	public Vector3 normalize() {
		Vector3 v3 = new Vector3(0,0,0);
		
		double length = Math.sqrt( this.x*this.x + this.y*this.y + this.z*this.z );
		if (length != 0) {
			v3.x = this.x/length;
			v3.y = this.y/length;
			v3.z = this.z/length;
		}
		
		return v3;
	}
	
	public double length() {
		return Math.sqrt( this.x*this.x + this.y*this.y + this.z*this.z );
	}
	
	public Vector3 cross( Vector3 c ) {
		return new Vector3( (this.y * c.z) - (this.z * c.y),
		(this.z * c.x) - (this.x * c.z),
		(this.x * c.y) - (this.y * c.x));
	}
	
	public Vector3 cross( ArrayList<Vector3> matrix ) {
		Vector3 result = new Vector3( this.x, this.y, this.z );
		result.x = (matrix.get(0).x * this.x) + (matrix.get(0).y * this.y) + (matrix.get(0).z * this.z);
		result.y = (matrix.get(1).x * this.x) + (matrix.get(1).y * this.y) + (matrix.get(1).z * this.z);
		result.z = (matrix.get(2).x * this.x) + (matrix.get(2).y * this.y) + (matrix.get(2).z * this.z);
		return result;
	}
	
	public Vector3 reflect( Vector3 normal, Vector3 v ) {
		return v.subtract(normal.multiply(2).cross(v).cross(normal));
	}
}