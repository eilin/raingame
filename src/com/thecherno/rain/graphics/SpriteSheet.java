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
	public final int SIZE; //size of one side of sprite sheet (using 256*256)
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256); //TODO fix magic number
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	/*
	 * Load SpriteSheet from file to memory
	 */
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (Exception e) {
			System.out.println("ERROR: failed to load sprite sheet");
			e.printStackTrace();
		}
	}
}
