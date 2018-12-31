package alienshooter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class menu extends JFrame{
	


	JFrame jf;
	public menu(){
    	jf = new JFrame("  Home vs Alien");
		jf.setLayout(null);
		jf.setSize(600, 500);

		jf.getContentPane().setBackground(Color.CYAN);
		  
;

		JButton jb = new JButton("Play");
		jb.setBounds(225, 150, 150, 50);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Source();
				jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
				
			}
		});
		
		JButton jb1=new JButton("Exýt");
		jb1.setBounds(225, 300, 150, 50);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
			}
			
		});
		
		
	    
        
	   
		

		jf.add(jb1);
		jf.add(jb);
		jf.setVisible(true);
		jf.setResizable(false);
		
	}
}
