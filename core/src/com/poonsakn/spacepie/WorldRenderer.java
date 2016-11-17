package com.poonsakn.spacepie;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	static Texture rocketImg;
	static Texture rocketBoostedImg;
	static Texture gameoverImg;
	static Texture spacepieImg;
	private TextureRegion rocketRegion;
	private TextureRegion rocketBoostedRegion;
	private SpriteBatch batch;
	private SpacePie spacePie;
	private World world;
	private AsteroidRenderer asteroidRenderer;
	private PointRenderer pointRenderer;
	private float Width;
	private float Height;
	private float OriginX;
	private float OriginY;
	
	int gridXNumber;
	int gridYNumber;
	int gridX;
	int gridY;
	static Texture bgImg;
	private int mapSize = 2;
	
	BitmapFont font;
	
	public WorldRenderer (SpacePie spacePie, World world) {
		this.spacePie = spacePie;
		this.world = world;
		batch = spacePie.batch;
		font = new BitmapFont();
		rocketImg = new Texture("rocket.png");
		rocketBoostedImg = new Texture("rocket2.png");
		gameoverImg = new Texture("gameover.png");
		spacepieImg = new Texture("spacepie.png");
		bgImg = new Texture("bg2.png");
		rocketRegion = new TextureRegion(rocketImg);
		rocketBoostedRegion = new TextureRegion(rocketBoostedImg);

		Width = rocketImg.getWidth();
		Height = rocketImg.getHeight();
		OriginX = Width/2;
		OriginY = Height/2;
		asteroidRenderer = new AsteroidRenderer (this.spacePie.batch, this.world.asteroids);
		pointRenderer = new PointRenderer (this.spacePie.batch, this.world.points);
		

	}
	
	public void render (float delta, boolean rocketBoosted) {
		renderBackground();
		asteroidRenderer.renderAsteroid();
		pointRenderer.renderPoint();
		renderRocket(rocketBoosted);
		
	}
	public void renderRocket (boolean rocketBoosted) {
		batch.begin();
		Vector2 pos = World.getRocket().getPosition();
		if (rocketBoosted) {
			batch.draw(rocketBoostedRegion, pos.x-(Width/2) , pos.y-(Height/2)
					, OriginX , OriginY //origin x,y
					, Width, Height //width, height
					, (float) 0.5 , (float) 0.5 //scale x,y
					, Rocket.rotation //rotation
					);			
		}  else {
			batch.draw(rocketRegion, pos.x-(Width/2) , pos.y-(Height/2)
					, OriginX , OriginY //origin x,y
					, Width, Height //width, height
					, (float) 0.5 , (float) 0.5 //scale x,y
					, Rocket.rotation //rotation
					);
		}
//		font.draw(batch, "x" + pos.x + "   y" + pos.y + "   r" + Rocket.rotation , pos.x, pos.y);
		batch.end();
	}
	@SuppressWarnings("static-access")
	public void startRenderer () {
		batch.begin();
		batch.draw(spacepieImg
				, (float) (world.getRocket().getPosition().x-(0.5*gameoverImg.getWidth()))
				, (float) (world.getRocket().getPosition().y-(0.2*gameoverImg.getHeight()))
				, spacepieImg.getWidth(), spacepieImg.getHeight());
		font.draw(batch, "press \'enter\' to start." , world.getRocket().getPosition().x-80, world.getRocket().getPosition().y-200);
		batch.end();
		System.out.println(2);
	}
	public void gameoverRenderer () {
		batch.draw(gameoverImg
				, (float) (world.getRocket().getPosition().x-(0.5*gameoverImg.getWidth()))
				, (float) (world.getRocket().getPosition().y-(0.2*gameoverImg.getHeight()))
				, gameoverImg.getWidth(), gameoverImg.getHeight());
		font.draw(batch, "press \'enter\' to try again." , world.getRocket().getPosition().x-80, world.getRocket().getPosition().y-200);

	}
	
	@SuppressWarnings("static-access")
	public void renderBackground () {
		batch.begin();
		gridXNumber =(int) (Math.floor(world.getRocket().getPosition().x / bgImg.getWidth()));
		gridYNumber = (int) (Math.floor(world.getRocket().getPosition().y / bgImg.getHeight()));
		gridX = (int) (bgImg.getWidth() * gridXNumber);
		gridY = (int) (bgImg.getHeight() * gridYNumber);
		for (int i = -mapSize; i <= mapSize; i++) {
			for (int j = -mapSize; j <= mapSize; j++) {
				batch.draw(bgImg, (i*bgImg.getWidth()) + gridX, (j*bgImg.getHeight()) + gridY);
			}
		}
		batch.end();
//		System.out.println("grid" + gridX + "." + gridY + "_____________" + gridXNumber + " " + gridYNumber);
	}
	
}
