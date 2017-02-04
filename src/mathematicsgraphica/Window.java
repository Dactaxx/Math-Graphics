package mathematicsgraphica;

import javax.swing.JFrame;

public class Window {
	public static double WIDTH, HEIGHT;
	public static JFrame frame = new JFrame();
	public static void createWindow(double width, double height) {
		WIDTH = width;
		HEIGHT = height;
		frame.setSize((int)WIDTH, (Integer)(int)HEIGHT);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
