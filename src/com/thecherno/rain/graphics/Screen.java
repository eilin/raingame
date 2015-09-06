
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
			int yActual = y - yOffset;
			if (yActual < 0 || yActual >= height) continue;
			for (int x = 0; x < width; ++x) {
				int xActual = x - xOffset;
				if (xActual < 0 || xActual >= width) continue;
				pixels[xActual + yActual * width] = Sprite.grass.pixels[(x&15) + (y&15) * 16]; //TODO fix magic number
			}
		}
	}
}
