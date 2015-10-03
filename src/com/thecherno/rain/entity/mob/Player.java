/**
 * 
 */
package com.thecherno.rain.entity.mob;

import com.thecherno.rain.input.*;
import com.thecherno.rain.graphics.*;

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
		int delta_x = 0;
		int delta_y = 0;
		if (keyboard.up) { --delta_y; }
		if (keyboard.down) { ++delta_y; }
		if (keyboard.left) { --delta_x; }
		if (keyboard.right) { ++delta_x; }
		
		if (delta_x != 0 || delta_y != 0) {
			move(delta_x, delta_y); //inherited from Mob
		}
	}
	
	public void render(Screen screen) {
		// -16 to center player sprites
		screen.renderPlayer(x-16, y-16, Sprite.player0);
		screen.renderPlayer(x, y-16, Sprite.player1);
		screen.renderPlayer(x-16, y, Sprite.player2);
		screen.renderPlayer(x, y, Sprite.player3);
	}
}
