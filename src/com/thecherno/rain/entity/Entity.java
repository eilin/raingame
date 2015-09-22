/**
 * 
 */
package com.thecherno.rain.entity;

import java.util.Random;
import com.thecherno.rain.level.*;
import com.thecherno.rain.graphics.*;
/**
 * @author Edward
 *
 */
public abstract class Entity {
	public int x, y;
	public boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		//remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
