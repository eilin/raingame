/**
 * 
 */
package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.*;

/**
 * @author Edward
 * 
 */
public class Tile 
{
	public int x, y;
	public Sprite sprite; 
		
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile grassFlowers1 = new GrassTile(Sprite.grassFlowers1);
	public static Tile grassFlowers2 = new GrassTile(Sprite.grassFlowers2);
	public static Tile grassSmallRocks1 = new GrassTile(Sprite.grassSmallRocks1);
	public static Tile grassSmallRocks2 = new GrassTile(Sprite.grassSmallRocks2);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/*
	 * @param x : tile percision value of position of tile
	 * @param y : tile percision value of position of tile
	 */
	public void render(int x, int y, Screen screen) {
		//multiply args by 16 to get pixel percision value
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return false;
	}
}
