package com.poonsakn.spacepie;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	private static float originalRocketSpeed = 7;
	private static float startingRocketSpeed = 0;
	private static float originalRotationSpeed = 5;
	private static float rocketSpeed = originalRocketSpeed;
	private static float rotationSpeed = originalRotationSpeed;
	public static int rotation = 0;
	public static double rotationRadian = Math.toRadians(rotation);
	private List<Asteroid> asteroids;
	private List<Point> points;
	private Vector2 collisionDistance;
	Texture rocket = new Texture("rocket.png");
	int a = 0;
	int b = 0;
	
	ShapeRenderer shape = new ShapeRenderer ();

	public Rocket(int x, int y, List<Asteroid> asteroids, List<Point> point) {
		position = new Vector2(x,y);
		rotation = 0;
		this.asteroids = asteroids;
		this.points = point;
		collisionDistance = new Vector2();
		startingRocketSpeed = 0;
		rotationRadian = Math.toRadians(rotation);
	}
	
	
	public Vector2 getPosition() {
		return position;
	}

	public void updateDirection() {
//		System.out.println(rotation + " ===== " + (int) position.x + "." + (int) position.y);
//		rotation = Math.abs(rotation%360);
		rotation %= 360;
		if (rotation < 0) {
			rotation = (360+rotation);
		}

//		rotation = Math.abs(360-rotation);
	}
	
	public void updatePosition() {
		if (startingRocketSpeed < originalRocketSpeed) {
			rocketSpeed = startingRocketSpeed;
			startingRocketSpeed += 0.05;
		}
		position.x += rocketSpeed * Math.sin(-rotationRadian) ;
		position.y += rocketSpeed * Math.cos(-rotationRadian) ;
	}
	
	public int checkAsteroidCollision () {
		for (Asteroid asteroid : this.asteroids) {
			collisionDistance.x = (Math.abs(asteroid.getPosition().x-position.x));
			collisionDistance.y = (Math.abs(asteroid.getPosition().y-position.y));
			if (((Math.abs(asteroid.getPosition().x-position.x) <= 0.5*asteroid.getSize()) 
					&& (Math.abs(asteroid.getPosition().y-position.y) <= 0.5*asteroid.getSize()))
					&& (startingRocketSpeed >= originalRocketSpeed)) {
//				System.out.println(position.y + "    " + position.x + "    " + asteroid.getSize());
//				System.out.println(asteroid.getPosition().y + "    " + asteroid.getPosition().x + "");
//				System.out.println(collisionDistance.y + "    " + collisionDistance.x + "\n");
				return 1;
			}
		}
		b=0;
		return 0;
	}
//	public Vector2 positionForCollision (Vector2 positionC, int rotation) {
//		Vector2 pos;
//		pos = new Vector2 ();
//		pos = positionC;
//		if ((rotation <= 90) || (rotation >= 270)) {
//			pos.y = (float) (positionC.y-(Math.sin(Math.toRadians(rotation))*WorldRenderer.rocketImg.getHeight()));
//			System.out.println(Math.sin(Math.toRadians(rotation)) + "sin" + "   rotation   "  +rotation);
//			System.out.println(Math.sin(Math.toRadians(rotation))*WorldRenderer.rocketImg.getHeight() + "sin*height");
//		} else if ((rotation > 90) && (rotation < 270)) {
//			pos.y = (float) (positionC.y-2*(Math.sin(Math.toRadians(rotation-90))*WorldRenderer.rocketImg.getHeight()));
//		}
//		System.out.println(positionC.y + " positionC");
//		System.out.println(pos.y + " pos.y");
//		return positionC;
//	}
	public int checkPointCollision () {
		a=0;
		for (Point point : this.points) {
			if ((Math.abs(point.getPosition().x-position.x) <= 0.5*point.getSize().x) 
					&& (Math.abs(point.getPosition().y-position.y) <= 0.5*point.getSize().y)) {
				return a;
			}
			a++;
		}
		a=0;
		return 0;
	}
	
	public static void boostSpeed (boolean keyPressed) {
		if (keyPressed == true) {
			rocketSpeed = (float) (rocketSpeed*1.01);
			rotationSpeed = (float) (originalRotationSpeed/originalRotationSpeed); 
		} else if (keyPressed == false) {
			rocketSpeed = originalRocketSpeed;
			rotationSpeed = originalRotationSpeed;
		}
	}
	
	public static void updateRocketRotation(int key) {
		if (key == -1) {
			rotation += rotationSpeed;
		} else if (key == 1) {
			rotation -= rotationSpeed;
		}
		
		rotationRadian = Math.toRadians(rotation);
	}
	
	public void setRocketSpeedZero() {
		rocketSpeed = 0;
	}
	
	
}