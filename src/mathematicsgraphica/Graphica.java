package mathematicsgraphica;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Graphica extends JPanel implements Runnable {
	public static boolean running = false;
	public static void main(String[] args) {
		Window.createWindow(1600, 900);
		Window.frame.add(new Graphica());
		start();
		
	}

	public static synchronized void start() {
		running = true;
		new Thread(new Graphica()).start();
		PlotGraph.start();
		
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			tick();
			
			
		}
		
	}
	
	public static void tick() {
		Window.frame.repaint();
		Window.WIDTH = Window.frame.getWidth();
		Window.HEIGHT = Window.frame.getHeight();
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		PlotGraph.render(g2d);
		
	}
	
}
