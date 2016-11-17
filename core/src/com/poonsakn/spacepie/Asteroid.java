package com.poonsakn.spacepie;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;

public class Asteroid {
	private CircleShape asteroid;
	private Random random;
	private int r = random.nextInt(500);
	
	public Asteroid (int x, int y) {	
		asteroid.setPosition(new Vector2 (x,y));
	}
	
	public Vector2 getPosition () {
		return asteroid.getPosition();
	}
}
