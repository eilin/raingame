/**
 * 
 */
package com.thecherno.rain.level;

import com.thecherno.rain.graphics.*;
import com.thecherno.rain.level.tile.*;

/**
 * @author Edward
 * Super-class for levels
 */
public class Level 
{
	protected int width, height;
	protected int[] tiles; //tile index IDs
	
	public Level(int width, int height) { //constructor for random level generation
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		
	}

	public Level(String path) {
		loadLevel(path);
	}
	
	private void loadLevel(String path) {
		
	}

	
	public void update() { //entity positions will be updated in here
		
	}
	
	public void time() { //will manage in-game-time
		
	}
	
	/**
	 * 
	 * @param xScroll : x position of player
	 * @param yScroll : y position of player
	 * @param screen
	 */
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffSet(xScroll, yScroll);
		//divide by 16 to get tile percision
		int x0 = xScroll >> 4; //left cornerpin pixel
		int x1 = (xScroll + screen.width + 16) >> 4; //right cornerpin pixel + extra tile to cover rendering TODO fix magic number
		int y0 = yScroll >> 4; //top cornerpin pixel
		int y1 = (yScroll + screen.height + 16) >> 4; //bottom cornerpin pixel + extra tile to cover rendinger TODO fix magic number
		
		for (int y = y0; y < y1; ++y) {
			for (int x = x0; x < x1; ++x) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		int tileId = tiles[x+y*width];
		switch(tileId) {
		case 0: return Tile.grass;
		default: return Tile.voidTile;
		}
	}
}
