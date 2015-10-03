/**
 * 
 */
package com.thecherno.rain.entity.mob;

import com.thecherno.rain.entity.*;
import com.thecherno.rain.graphics.*;
/**
 * @author Edward
 *
 */
public abstract class Mob extends Entity
{
	protected Sprite sprite;
	protected int direction = 0; //north = 0, east = 1, south = 2, west = 3
	protected boolean moving = false;
	
	public boolean isMoving() {
		return moving;
	}
	
	/**
	 * args describe the change in position and direction of the mob
	 */
	public void move(int delta_x, int delta_y) {

		if (delta_x > 0) { direction = 1; } //may want to include diagonal directions
		if (delta_x < 0) { direction = 3; }
		if (delta_y > 0) { direction = 0; } 
		if (delta_y < 0) { direction = 4; }
		
		if (!isCollision()) {
			x += delta_x;
			y += delta_y;
		}
	}
	
	public void update() {
		//todo
	}
	
	public void render(Screen screen) {
		
	}
	
	private boolean isCollision() {
		return false; //temp default for now
	}
}
