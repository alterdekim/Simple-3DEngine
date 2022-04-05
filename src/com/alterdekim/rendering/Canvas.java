package com.alterdekim.rendering;

public class Canvas extends Raymarcher {
	
	private static final long serialVersionUID = 1L;
	
	private Sphere sphere = new Sphere( new Vector3(0,0,0), 1 );
	private LambertLight light = new LambertLight(new Vector3(4,2,4));
	private double d = 0;
	
	public Canvas() {
		init();
	}
	
	@Override
	public void onStart() {
		this.setCameraPosition(new Vector3(0, 0, -3));
		sphere.getMaterial().setColor(new MaterialColor(0.3, 0.7, 1.0));
		this.add(sphere);
		this.add(new Plane(new Vector3(0,0,0)));
		this.addLight(light);
	}
	
	@Override
	public void onRender() {
		light.setPosition(new Vector3(4.0*Math.sin(d), 2.0, 4.0 * Math.cos(d)));
		d+=0.2;
	}
}
