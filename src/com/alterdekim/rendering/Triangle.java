package com.alterdekim.rendering;

public class Triangle extends Object3D {
	
	private Vector3 a;
	private Vector3 b;
	private Vector3 c;

	public Triangle(Vector3 position, Vector3 a, Vector3 b, Vector3 c) {
		super(position);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public double calculateSDF(Vector3 p) {
		  if( this.getEulerX() != 0 ) {
			  p = p.cross(Utils.rotateX(Math.toRadians(this.getEulerX())));
		  }
		  if( this.getEulerY() != 0 ) {
			  p = p.cross(Utils.rotateY(Math.toRadians(this.getEulerY())));
		  }
		  if( this.getEulerZ() != 0 ) {
			  p = p.cross(Utils.rotateZ(Math.toRadians(this.getEulerZ())));
		  }
		  Vector3 ba = b.subtract(a); Vector3 pa = p.subtract(a);
		  Vector3 cb = c.subtract(b); Vector3 pb = p.subtract(b);
		  Vector3 ac = a.subtract(c); Vector3 pc = p.subtract(c);
		  Vector3 nor = ba.cross(ac);

		  return Math.sqrt(
		    (Math.signum(ba.cross(nor).dot(pa)) +
		     Math.signum(cb.cross(nor).dot(pb)) +
		     Math.signum(ac.cross(nor).dot(pc))<2.0)
		     ?
		     Math.min( Math.min(
		     dot2(ba.multiply(Utils.clamp(ba.dot(pa)/dot2(ba),0.0,1.0)).subtract(pa)),
		     dot2(cb.multiply(Utils.clamp(cb.dot(pb)/dot2(cb),0.0,1.0)).subtract(pb)) ),
		     dot2(ac.multiply(Utils.clamp(ac.dot(pc)/dot2(ac),0.0,1.0)).subtract(pc)) )
		     :
		    	 nor.dot(pa)*nor.dot(pa)/dot2(nor) );
	}
	
	private double dot2( Vector3 v ) {
		return v.dot(v);
	}
}
