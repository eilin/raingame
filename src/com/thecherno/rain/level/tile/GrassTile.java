/**
 * 
 */
package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

/**
 * @author Edward
 * why does this class exist? can't we just use Tile instead and pass the sprite we want
 * to the constructor?
 */
public class GrassTile extends Tile 
{

	public GrassTile(Sprite sprite) {
		super(sprite);
	}

}
