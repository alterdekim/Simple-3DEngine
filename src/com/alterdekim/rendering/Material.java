package com.alterdekim.rendering;

public class Material {
	private MaterialColor color;
	
	public Material( MaterialColor color ) {
		this.color = color;
	}
	
	public MaterialColor getColor() {
		return this.color;
	}
	
	public void setColor( MaterialColor color ) {
		this.color = color;
	}
}
