package com.poonsakn.spacepie;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Point {
	public Vector2 position;
	
	Random random = new Random();
	Vector2 size;
	
	public Point () {
		position = new Vector2 (0,0);
		int randomRange = 200 + random.nextInt(2000);
		int randomDirection = random.nextInt(4);
		double interval = 5;
		size = new Vector2 ();
		size.x = PointRenderer.pointImg.getWidth();
		size.y = PointRenderer.pointImg.getHeight();
			
//		position.x = 500 + randomRange + World.getRocket().getPosition().x;
//		position.y = 500 + randomRange + World.getRocket().getPosition().y;
		
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
	
	public Vector2 getSize () {
		return size;
	}
}
