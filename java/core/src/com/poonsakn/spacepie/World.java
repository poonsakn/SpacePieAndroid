package com.poonsakn.spacepie;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.ChoiceCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class World {
	private static Rocket rocket;
	int a = 0;
	int score = 0;
	int highScore = 0;
	boolean justLaunchGame = true;
	int exploded = 0;
	static List <Asteroid> asteroids = new ArrayList <Asteroid> ();
	static List <Point> points = new ArrayList <Point> ();
	private Sound sound = Gdx.audio.newSound(Gdx.files.internal("Window - The Album Leaf.mp3"));
	private Sound explosionSound  = Gdx.audio.newSound(Gdx.files.internal("explosion2.mp3"));
	World (SpacePie spacePie) {
		init(spacePie);
		sound.loop();
	}
	
	public void init(SpacePie spacePie) {
//		if (a != 0) {
//			justLaunchGame = false;
//		}
		score = 0;
		asteroids = new ArrayList <Asteroid> ();
		points = new ArrayList <Point> ();
		
		for (int i = 0 ; i < 1000 ; i++) {
			asteroids.add(new Asteroid());
		}
		
		for (int i = 0 ; i < 300 ; i++) {
			points.add(new Point());
		}
		rocket = new Rocket(0,0,asteroids, points);
		exploded = 0;
	}
	
	public static Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		int b = 0;
		rocket.updateDirection();
		b = rocket.checkPointCollision();
		a = rocket.checkAsteroidCollision();
		
		if (b != 0) {
//			System.out.println(b);
			points.remove(b);
			b=0;
			score++;
			if (score > highScore) {
				highScore = score;
			}
		}
		if (a == 0) {
			rocket.updatePosition();
		} else if ((a != 0) && (exploded == 0)) {
			exploded = 1;
		} if (exploded == 1) {
			explosionSound.play();
			exploded++;
		}
	}
	
	public void gameLaunched () {
		this.justLaunchGame = false;
	}
}