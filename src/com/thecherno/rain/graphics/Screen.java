
package com.thecherno.rain.graphics;

/**
 * @author Edward
 *
 */
public class Screen 
{
	private int width;
	private int height;
	public int[] pixels;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
}
