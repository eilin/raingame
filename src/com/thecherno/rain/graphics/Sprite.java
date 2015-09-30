/**
 * 
 */
package com.thecherno.rain.graphics;

/**
 * @author Edward
 *
 */
public class Sprite 
{
	public final int SIZE; //size of individual sprite
	private int x, y; //xy coordinates of top-left-corner of sprite in sheet
	public int[] pixels;
	private SpriteSheet sheet;
		
	public static Sprite voidSprite = new Sprite(16, 0x000000);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles); //TODO fix magic number
	public static Sprite grassFlowers1 = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite grassFlowers2 = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite grassSmallRocks1 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite grassSmallRocks2 = new Sprite(16, 2, 1, SpriteSheet.tiles);
	
	/**
	 * @param size: is measured in pixels
	 * @param x: x coordinate of image in terms of sequential number
	 * @param y: y coordinate of image in terms of sequential number  
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		this.pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < SIZE*SIZE; ++i) {
			pixels[i] = color;
		}
	}
	
	/**
	 * copies a SIZE-1 by SIZE-1 chunk from sheet to Sprite, the starting 
	 * coordinates of the copying is this.x and this.y
	 */
	private void load() {
		for (int y = 0; y < SIZE; ++y) {
			for (int x = 0; x < SIZE; ++x) {
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
