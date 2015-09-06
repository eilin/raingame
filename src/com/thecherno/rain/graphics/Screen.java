
package com.thecherno.rain.graphics;

import java.util.Random;

/**
 * @author Edward
 *
 */
public class Screen 
{
	private int width;
	private int height;
	private final int PIXELS_IN_TILE = 16;
	private final int MAP_SIZE = 8;  
	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; 
	
	private Random random = new Random();
		
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		// map is random colors for now
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; ++i) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; ++i) {
			pixels[i] = 0; //renders everything to black
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; ++y) {
			int yActual = y + yOffset;
			//if (y < 0 || y >= height) break;
			for (int x = 0; x < width; ++x) {
				int xActual = x + xOffset;
				//if (x < 0 || x >= width) break;
				int tileIndex = ((xActual / PIXELS_IN_TILE) & MAP_SIZE_MASK) + 
								((yActual / PIXELS_IN_TILE) & MAP_SIZE_MASK) * MAP_SIZE;
				pixels[x + y * width] = Sprite.grass.pixels[(xActual&15) + (yActual&15) * 16]; //TODO fix magic number
			}
		}
	}
}
