package com.poonsakn.spacepie;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static com.badlogic.gdx.math.MathUtils.random;
import static com.badlogic.gdx.math.MathUtils.randomBoolean;

public class World {
	private Rocket rocket;
	private Asteroid asteroid;
    private boolean randomDirection;
    private int rot;
	
	World (SpacePie spacePie) {
		rocket = new Rocket(0,0);
        randomDirection = randomBoolean();
        rot = random(5);
	}
	Rocket getRocket() {
		return rocket;
	}
	public void update(float delta) {
		rocket.update();
		rocket.updatePosition();
		if(Gdx.input.isTouched() == true) {
			Rocket.rocketSpeed -= 3;

//            if (randomDirection == false) {
//                Rocket.rotation += rot;
//                rot = random(5);
//                randomDirection = randomBoolean();
//            } else if (randomDirection == true) {
//                Rocket.rotation -= rot;
//                rot = random(5);
//                randomDirection = randomBoolean();
//            }
		}
        else if (Gdx.input.isTouched() == false) {
            Rocket.rocketSpeed +=1;
        }
	}
}
