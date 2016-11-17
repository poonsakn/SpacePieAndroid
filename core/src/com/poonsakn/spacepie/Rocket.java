package com.poonsakn.spacepie;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
	private Vector2 position;
	public static float rocketSpeed = 7;
	private static float rotationSpeed = 6;
	public static int rotation = 0;
	public static double rotationRadian = Math.toRadians(rotation);
	
	public Rocket(int x, int y) {
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void update() {
		System.out.println(rotation + " ===== " + (int) position.x + "." + (int) position.y);
		rotation %= 360;
	}
	
	public void updatePosition() {
		position.x += rocketSpeed * Math.sin(-rotationRadian) ;
		position.y += rocketSpeed * Math.cos(-rotationRadian) ;
	}
	
	public static void updateRocketRotation(int key) {
		if (key == -1) {
			rotation += rotationSpeed;
		} else if (key == 1) {
			rotation -= rotationSpeed;
		}
		
		rotationRadian = Math.toRadians(rotation);
	}
}