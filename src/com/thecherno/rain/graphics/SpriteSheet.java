/**
 * 
 */
package com.thecherno.rain.graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * @author Edward
 *
 */
public class SpriteSheet 
{
	private String path;
	private final int SIZE; //size of sprite sheet, not sprite
	public int[] pixels;
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, 0);
		} catch (Exception e) {
			System.out.println("ERROR: failed to load sprite sheet");
		}
	}
}
