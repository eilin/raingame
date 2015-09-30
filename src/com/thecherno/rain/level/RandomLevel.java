/**
 * 
 */
package com.thecherno.rain.level;

import java.util.Random;

/**
 * @author Edward
 *
 */
public class RandomLevel extends Level {
	
	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
		generateLevel();
	}
	
	protected void generateLevel() {
		 for (int y = 0; y < height; ++y) {
			 for (int x = 0; x < width; ++x) {
				 tiles[x+y*width] = random.nextInt(5);
			 }
		 }		 
	}

}
