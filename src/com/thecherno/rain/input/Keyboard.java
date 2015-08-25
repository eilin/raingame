/**
 * 
 */
package com.thecherno.rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Edward
 *
 */
public class Keyboard implements KeyListener 
{
	private boolean[] keys = new boolean[128];
	public boolean up, down, left, right;
	
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		keys[keyEvent.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		keys[keyEvent.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		
	}
	
}
