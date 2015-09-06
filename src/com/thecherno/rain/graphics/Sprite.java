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
	private final int SIZE; //size of individual sprite
	private int x, y; //xy coordinates of top-left-corner of sprite in sheet
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 1, 0, SpriteSheet.tiles); //TODO fix magic number
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
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
