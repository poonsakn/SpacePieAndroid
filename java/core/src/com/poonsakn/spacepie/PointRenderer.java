package com.poonsakn.spacepie;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PointRenderer {
	public static Texture pointImg = new Texture("point3.png");
	private TextureRegion pointRegion = new TextureRegion(pointImg);
	private SpriteBatch batch;
	private List<Point> points;
	private float Width;
	private float Height;
	BitmapFont font;

	public PointRenderer(SpriteBatch batch, List<Point> point) {
		this.batch = batch;
		this.points = point;
		font = new BitmapFont();
	}
	
	public void renderPoint () {
		batch.begin();
		for (Point point : this.points) {

			Width = point.getSize().x;
			Height = point.getSize().y;
//			batch.draw(pointImg, point.getPosition().x, point.getPosition().y, point.getSize(), point.getSize());
			batch.draw(pointRegion, point.getPosition().x-25, point.getPosition().y-25
					, 0 , 0 //origin x,y
					, Width, Height //width, height
					, (float) 1 , (float) 1 //scale x,y
					, 0 //rotation
					);
//			font.draw(batch, "   " + point.getPosition().x + "   " + point.getPosition().y , point.getPosition().x, point.getPosition().y);

			}
			batch.end();
		}
}
