
# Simple 3D Engine

Simple 3D Engine created using Raymarching algorithms in pure Java.


## Features

- FOG Light
- Ambient Light
- Lambert Light
- Materials
- Sphere
- Plane
- Triangle
- Octahedron
- Runtime rendering



## Default Scene

```Java
public class Canvas extends Raymarcher {
	
	private static final long serialVersionUID = 1L;
	
	private Sphere smallSphere = new Sphere( new Vector3(-2,0,1), 0.25 );
	private LambertLight light = new LambertLight(new Vector3(4,2,4));
	
	public Canvas() {
		init();
	}
	
	@Override
	public void onStart() {
		this.setCameraPosition(new Vector3(0, 0, -3));
		this.setCameraRotation(new Vector3(-10, 0, 0));
		smallSphere.getMaterial().setColor(new MaterialColor(0.3, 0.9, 1.0));
		this.add(smallSphere);
		this.add(new Plane(new Vector3(0,0,0)));
		this.addLight(light);
	}
	
	@Override
	public void onRender() {}
}

```


## Screenshots

![Render Screenshot](https://i.ibb.co/b6mpJp9/1.png)

![Render Screenshot](https://i.ibb.co/wNp0Fny/2.png)


## License

[GNU GPLv3](https://choosealicense.com/licenses/gpl-3.0/)


## Authors

- [@Wain](https://www.github.com/alterdekim)

