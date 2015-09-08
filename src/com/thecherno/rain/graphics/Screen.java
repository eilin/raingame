
package com.thecherno.rain.graphics;

import com.thecherno.rain.level.tile.*;

/**
 * @author Edward
 *
 */
public class Screen 
{
	public int width;
	public int height;
//	private final int PIXELS_IN_TILE = 16;
	private final int MAP_SIZE = 8;  
//	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; 
			
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; ++i) {
			pixels[i] = 0; //renders everything to black
		}
	}
	
	/**
	 * @param xPosition is the x axis position of the tile
	 * @param yPosition is the y axis position of the tile
	 */
	public void renderTile(int xPosition, int yPosition, Tile tile) {
		xPosition -= xOffset;
		yPosition -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; ++y) {
			int yAbs = y + yPosition;
			for (int x = 0; x < tile.sprite.SIZE; ++x) {
				int xAbs = x + xPosition;
				if (xAbs < 0 || xAbs >= width || yAbs < 0 || yAbs >= width) break; // width?
				pixels[xAbs+yAbs*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	public void setOffSet(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
