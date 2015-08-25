package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.input.Keyboard;
/**
 * @author Edward
 *
 */
public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private JFrame frame;
	private static String title = "Rain";
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	private int xOffset, yOffset;
	
	private Keyboard keyboard;
	
	private Thread thread;
	private boolean running = false;
	private static final int UPDATES_PER_SEC = 60;
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		keyboard = new Keyboard();
		addKeyListener(keyboard); //method from java.awt
		xOffset = yOffset = 0;
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double nsBetweenUpdates = 1_000_000_000.0 / UPDATES_PER_SEC;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long nowTime = System.nanoTime();
			delta += (nowTime - lastTime) / nsBetweenUpdates;
			lastTime = nowTime;
			while (delta >= 1) { //if it's time to update, update()
				update();
				++updates;
				--delta;
			}
			render(); // else, render()
			++frames;
			
			if (System.currentTimeMillis() - timer > 1000) {
				frame.setTitle(title + " | UPS: " + updates + " FPS: " + frames);
				timer += 1000;
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	public void update() {
		keyboard.update();
		if (keyboard.up) --yOffset;
		if (keyboard.down) ++yOffset;
		if (keyboard.left) --xOffset;
		if (keyboard.right) ++xOffset;
	}
	
	public void render() {
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render(xOffset, yOffset);
		
		//copy Screen pixels to Game pixels
		for (int i = 0; i < pixels.length; ++i) { //TODO can't we just pass a reference?
			pixels[i] = screen.pixels[i];
		}
		
		Graphics graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose(); //releases system resources
		bufferStrategy.show();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game); 
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null); //null for centered
		game.frame.setVisible(true); 
		game.requestFocus();
		game.start();
	}
}
