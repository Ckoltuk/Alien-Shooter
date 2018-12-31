package alienshooter;

import javax.swing.JFrame;

public class Source extends JFrame {

	public Source(){
	        add(new screen());

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1400, 600);
	        setLocationRelativeTo(null);
	        setTitle("Alien Shooter");
	        setResizable(false);
	        setVisible(true);
		}
}
	