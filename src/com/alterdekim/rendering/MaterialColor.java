package com.alterdekim.rendering;

public class MaterialColor {
	
	private double hue;
	private double saturation;
	private double brightness;
	
	public MaterialColor( double hue, double saturation, double brightness ) {
		this.hue = hue;
		this.saturation = saturation;
		this.brightness = brightness;
	}
	
	public double getHue() {
		return this.hue;
	}
	
	public double getSaturation() {
		return this.saturation;
	}
	
	public double getBrightness() {
		return this.brightness;
	}
}
