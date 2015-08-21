package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thecherno.rain.graphics.Screen;
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
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	@Override
	public void run() {
		while (running) {
				update();
				render();
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		screen.render();
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
		game.frame.setTitle("Rain");
		game.frame.add(game); 
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null); //null for centered
		game.frame.setVisible(true); 
		game.start();
	}
}
