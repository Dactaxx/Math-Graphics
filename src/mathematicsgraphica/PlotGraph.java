package mathematicsgraphica;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class PlotGraph implements Runnable {
	public static double xScl, yScl, xMax, yMax, scale;
	public static ArrayList<Point> points = new ArrayList<Point>();
	public static double ptSize = 10;
	PlotGraph pg = new PlotGraph();
	public static synchronized void start() {
		new Thread(new PlotGraph()).start();
		for(int i = 0; i < 10; i++) {
			Point point = new pg.Point();
			points.add(point);
			
			
		}
	}
	
	public class Point {
		private double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Point() {
			
		}
		
		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
		
	}
	
	@Override
	public void run() {
		while(Graphica.running) {
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			tick();
			
			
		}
		
	}
	
	public static void tick() {
		xScl = 1;
		yScl = 1;
		xMax = 10;
		yMax = 10;
		scale = 100;
		
	}
	
	public static void render(Graphics2D g2d) {
		g2d.setColor(new Color(100, 100, 100));
		for(int i = 0; i <= xMax / xScl; i++) {
			g2d.drawLine(200 + (int)(i * scale), (int)Window.HEIGHT - (0 + 200), 200 + (int)(i * scale), (int)Window.HEIGHT - (int)(yMax / yScl * scale + 200));
			for(int j = 0; j <= xMax / xScl; j++) {
				g2d.drawLine(200 + 0, (int)Window.HEIGHT - (int)(j * scale + 200), 200 + (int)(xMax / xScl * scale), (int)Window.HEIGHT - (int)(j * scale + 200));
			}
		}
		
		g2d.setColor(new Color( 0, 0, 255));
		for(Point p : points) {
			g2d.fillOval((int)((p.x * scale + 200) - ptSize / 2), (int)(Window.HEIGHT - (p.y * scale + 200) - ptSize / 2), (int)ptSize, (int)ptSize);
		}
	}

}
