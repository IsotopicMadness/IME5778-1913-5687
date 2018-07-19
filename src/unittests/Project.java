package unittests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class Project {

	@Test
	public void main() {
		int X = 1920;
		int Y = 1080;
		ImageWriter _imageWriter = new ImageWriter("Project", X, Y, X, Y);
		Scene _scene = new Scene("Hills");
		_scene.setScreenDistance(400);
		_scene.setBackground(new Color(0, 0, 0));
		_scene.setCamera(new Camera(new Point3D(7.48113, -0.335088, 0.991898), new Vector(0, 0, 1),
				new Vector(-1, 0, 0).normalize()));
		_scene.setAmbientLight(new AmbientLight(new Color(0, 0, 0), 0));

		
		//light
		_scene.addLightSource(
				new PointLight(new Point3D(0.55*16.39727, -15*3.38068, (50*0.951183)+10), 0.55, 0.03, 0, new Color(255, 255, 255).scale(0.5), 5));
		//_scene.addLightSource(
		//		new PointLight(new Point3D(2 *16.39727, -20*3.38068, (50*0.951183)+10), 1, 0.03, 0, new Color(255, 255, 255).scale(0.5), 10));
		
		//walls
		_scene.addGeometry(new Plane(new Point3D(0, 2+8.02304, 0), new Vector(0, -1, 0), new Color(255, 0, 0).scale(0.3),
				new Material(5, 1, 1, 0.9, 0)));
		_scene.addGeometry(new Plane(new Point3D(-11, 0, 0), new Vector(1, 0, 0), new Color(255, 255, 0).scale(0.3),
				new Material(10, 1, 10, 0.9, 0)));
		_scene.addGeometry(new Plane(new Point3D(0, 0, -2.7243), new Vector(0, 0, 1), new Color(255, 0, 255).scale(0.3),
				new Material(1, 1, 10, 0, 0)));
		
		//blue sphere
		_scene.addGeometry(new Sphere(new Point3D(-6.39727, 3.38068, -0.951183), 3.871,
				new Color(0, 0, 255).scale(0.4), new Material(5, 10, 35, 0, 0)));
		//cyan
		_scene.addGeometry(new Sphere(new Point3D(-6.88142, -1.52322, 1.5-1.26099), 3.178,
				new Color(0, 255, 255).scale(0.4), new Material(5, 10, 15, 0, 0)));
		//_scene.addGeometry(new Sphere(new Point3D(5-6.88142, -20-1.52322, 10-1.26099), 3.178,
			//	new Color(0, 255, 255).scale(0.4), new Material(5, 10, 15, 0, 0)));
		
		//purple
		_scene.addGeometry(new Sphere(new Point3D(-0.98223, 3.60253, 7-2.38037), 2.669,
				new Color(255, 0, 255).scale(0.4), new Material(5, 0.85, 73, 0, 0)));
		//brown
		_scene.addGeometry(new Sphere(new Point3D(-3.32966, 0.091357, -2.4552), 2.555,
				new Color(255, 122, 155).scale(0.4), new Material(2.5, 0.85, 73, 0, 0)));
		//_scene.addGeometry(new Sphere(new Point3D(-10.0714, 8.02301, -2.52438), 2.555,
		//		new Color(255, 0, 255).scale(1), new Material(5, 0.85, 73, 0, 0)));
		
		Render r = new Render(_imageWriter, _scene);

		r.renderImage();
		r.getImageWriter().writeToImage();
		
	}

}