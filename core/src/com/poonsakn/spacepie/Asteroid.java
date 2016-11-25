package com.poonsakn.spacepie;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	public Vector2 position;
	
	Random random = new Random();
	int randomSize;
	
	
	public Asteroid () {
		position = new Vector2 (0,0);
		int randomRange = 200 + random.nextInt(5000);
		int randomDirection = random.nextInt(4);
		randomSize = 50 + random.nextInt(50);
//		randomSize = 50;
		double interval = 5;
		switch (randomDirection) {
		case 0: position.x = (float) ((interval)*randomRange*random.nextDouble());
				position.y = (float) ((interval)*randomRange*random.nextDouble());
				break;
		case 1: position.x = (float) ((interval)*randomRange*-random.nextDouble());
				position.y = (float) ((interval)*randomRange*random.nextDouble());
				break;
				
		case 2: position.x= (float) ((interval)*randomRange*random.nextDouble());
				position.y = (float) ((interval)*randomRange*-random.nextDouble());
				break;
		case 3: position.x = (float) ((interval)*randomRange*-random.nextDouble());
				position.y = (float) ((interval)*randomRange*-random.nextDouble());
				break;
		}
	}
	public Vector2 getPosition () {
		return position;
	}
	
	public float getSize () {
		return (float) randomSize;
	}
}
