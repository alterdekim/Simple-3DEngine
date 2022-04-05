package com.alterdekim.rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Raymarcher extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private final int MAX_STEPS = 80;
	
	private final double MAX_DIST = 100.0;
	
	private final double SURF_DIST = 0.001;
	
	private final Camera camera = new Camera(new Vector3(0,0,0));
	
	private ArrayList<Object3D> objects = new ArrayList<Object3D>();
	
	private ArrayList<Light> lights = new ArrayList<Light>();
	
	public void init() {
		Runnable task = new Runnable() {
            public void run() {
            	while(true) {
            		repaint();
            	}
            }
        };
        onStart();
        Thread thread = new Thread(task);
        thread.start();
	}
	
	public void onStart() {}
	
	public void onRender() {}
	
	private sceneResult raymarch(Vector3 ro, Vector3 rd) {
		double depth = 0;
		Material mat = new Material(new MaterialColor(0,0,0));
		for( int i = 0; i < MAX_STEPS; i++ ) {
			Vector3 p = rd.multiply(depth).sum(ro);
			sceneResult res = sceneSDF( p );
			double dS = res.dist;
			mat = res.mat;
			depth += dS;
			if( dS < SURF_DIST || depth > MAX_DIST ) {
				break;
			}
		}
		
		return new sceneResult( depth, mat );
	}
	
	private sceneResult sceneSDF( Vector3 pos ) {
		double min = MAX_DIST;
		Material mat = new Material(new MaterialColor(0,0,0));
		for( int i = 0; i < this.objects.size(); i++ ) {
			double d = this.objects.get(i).calculateSDF(pos);
			if( d < min ) {
				min = d;
				mat = this.objects.get(i).getMaterial();
			}
		}
		return new sceneResult(min, mat);
	}
	
	public void setCameraPosition( Vector3 position ) {
		this.camera.setPosition(position);
	}
	
	public void setCameraRotation( Vector3 rotation ) {
		this.camera.setRotationX(rotation.x);
		this.camera.setRotationY(rotation.y);
		this.camera.setRotationZ(rotation.z);
	}
	
	public Camera getCamera() {
		return this.camera;
	}
	
	public void add( Object3D object ) {
		this.objects.add(object);
	}
	
	public void remove( Object3D object ) {
		this.objects.remove(object);
	}
	
	public ArrayList<Object3D> children() {
		return this.objects;
	}
	
	public void addLight( Light light ) {
		this.lights.add(light);
	}
	
	public void removeLight( Light light ) {
		this.lights.remove(light);
	}
	
	public ArrayList<Light> childrenLight() {
		return this.lights;
	}
	
	private Vector3 calcNormal( Vector3 pos ) {
		Vector3 xyy = new Vector3(SURF_DIST,0,0);
		Vector3 yxy = new Vector3(0,SURF_DIST,0);
		Vector3 yyx = new Vector3(0,0,SURF_DIST);
		
	    Vector3 nor = new Vector3(
	    	sceneSDF(pos.sum(xyy)).dist - sceneSDF(pos.subtract(xyy)).dist,
	    	sceneSDF(pos.sum(yxy)).dist - sceneSDF(pos.subtract(yxy)).dist,
	    	sceneSDF(pos.sum(yyx)).dist - sceneSDF(pos.subtract(yyx)).dist);
	    return nor.normalize();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		onRender();
		Vector3 ro = new Vector3( camera.getX(), camera.getY(), camera.getZ() );
		double minres = Math.min(getWidth(), getHeight());
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				Vector3 rd = new Vector3((((double)x) - 0.5* ((double) getWidth())) / minres, (((double)y) - 0.5* ((double) getHeight())) / minres, 1);
				if( camera.getEulerX() != 0 ) {
					rd = rd.cross(Utils.rotateX(Math.toRadians(camera.getEulerX())));
				}
				if( camera.getEulerY() != 0 ) {
					rd = rd.cross(Utils.rotateY(Math.toRadians(camera.getEulerY())));
				}
				if( camera.getEulerZ() != 0 ) {
					rd = rd.cross(Utils.rotateZ(Math.toRadians(camera.getEulerZ())));
				}
				rd = rd.normalize();
				sceneResult res = raymarch( ro, rd );
				double d = res.dist;
				if( d < MAX_DIST ) {
					double dif = 0;
					Vector3 p = rd.multiply(d).sum(ro);
					Vector3 normal = calcNormal(p);
					for( int i = 0; i < this.lights.size(); i++ ) {
						dif += this.lights.get(i).calculateBrightness(rd, ro, normal, d);
						dif = Utils.clamp( dif, 0.0, 1.0 );
					}
					g.setColor(Color.getHSBColor( (float)res.mat.getColor().getHue(), (float)res.mat.getColor().getSaturation(), (float)dif ));
				} else {
					g.setColor(Color.BLACK);
				}
				
				g.fillRect(x, y, 1, 1);
			}
		}
	}
	
	private class sceneResult {
		public double dist;
		public Material mat;
		
		public sceneResult( double dist, Material mat ) {
			this.dist = dist;
			this.mat = mat;
		}
	}
}
