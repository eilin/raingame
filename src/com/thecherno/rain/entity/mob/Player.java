/**
 * 
 */
package com.thecherno.rain.entity.mob;

import com.thecherno.rain.input.*;

/**
 * @author Edward
 *
 */
public class Player extends Mob
{
	private Keyboard keyboard;
	
	//default constructor
	public Player(Keyboard keyboard) {
		this.keyboard = keyboard;
	}
	
	//constructor for spawning at a specific location
	public Player(Keyboard keyboard, int x, int y) {
		this.keyboard = keyboard;
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		if (keyboard.up) { --y; }
		if (keyboard.down) { ++y; }
		if (keyboard.left) { --x; }
		if (keyboard.right) { ++x; }
	}
	
	public void render() {
		
	}
}
