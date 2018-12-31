package alienshooter;



import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;




public class screen extends JPanel implements ActionListener {
	private Timer timer;
	
    private cannon cannon;
    private int counter1=0;
    private int counter2=0;
    private ArrayList aliens2;  
    private ArrayList aliens;
    private boolean ingame = true;
    private int S_WIDTH;
    private int S_HEIGHT;
    Random r = new Random();

   Random a = new Random();
   Random b = new Random();
   Random c = new Random();
   Random d = new Random();
    
 int y=a.nextInt(530);
 int y1=b.nextInt(530);
 int y2=a.nextInt(530);
 int y3=b.nextInt(530);
 int y4=a.nextInt(530);
 int y5=b.nextInt(530);
 int y6=a.nextInt(530);
 int y7=b.nextInt(530);
 int y8=a.nextInt(530);
 int y9=b.nextInt(530);
 
 
 int x=a.nextInt(530);
 int x1=b.nextInt(530);
 int x2=a.nextInt(530);
 int x3=b.nextInt(530);
 int x4=a.nextInt(530);
 int x5=b.nextInt(530);
 int x6=a.nextInt(530);
 int x7=b.nextInt(530);
 int x8=a.nextInt(530);
 int x9=b.nextInt(530);
 
 int z=c.nextInt(700)+1000;
 int z1=d.nextInt(700)+1000;
 int z2=c.nextInt(700)+1000;
 int z3=d.nextInt(700)+1000;
 int z4=c.nextInt(700)+1000;
 int z5=d.nextInt(700)+1000;
 int z6=c.nextInt(700)+1000;
 int z7=d.nextInt(700)+1000;
 int z8=c.nextInt(700)+1000;
 int z9=d.nextInt(700)+1000;

 int t=c.nextInt(700);
 int t1=d.nextInt(700);
 int t2=c.nextInt(700);
 int t3=d.nextInt(700);
 int t4=c.nextInt(700);
 int t5=d.nextInt(700);
 int t6=c.nextInt(700);
 int t7=d.nextInt(700);
 int t8=c.nextInt(700);
 int t9=d.nextInt(700);
 


 
    private int[][] pos  ={ {z,y},{z1,y1},{z2,y3},{z3,y4},
    		{z4,y5},{z,y9},{z3,y4},{z6,y},
    		{z9,y6},{z,y8},{z4,y8},{z4,y},{z9,y1},{z,y3},{z3,y4},
    		{z8,y5},{z8,y9},{z8,y4},{z2,y},
    		{z5,y6},{z8,y8},{z2,y8},{z5,y},{z6,y1},{z5,y3},{z9,y4},
    		{z6,y5},{z7,y9},{z6,y4},{z1,y},
    		{z,y6},{z3,y8},{z7,y8},{z8,y},{z1,y1},{z2,y3},{z9,y4},
    		{z2,y5},{z,y9},{z6,y4},{z8,y},
    		{z1,y6},{z3,y8},{z,y8},
    		{z3,y},{z,y1},{z,y3},{z5,y4},
    		{z9,y5},{z6,y9},{z2,y4},{z1,y},
    		{z9,y6},{z,y8},{z,y8},
    	
    	    };
  
    
    private int[][] pos2  ={ 
    		{t,x},{t3,x1},{t1,x3},{t5,x4},
    		{t6,x5},{t5,x9},{t4,x4},{t6,x},
    		{t1,x6},{t,x8},{t8,x8},{t4,x},{t,x1},{t2,x3},{t2,x4},
    		{t3,x5},{t7,x9},{t8,x4},{t8,x},
    		{t,x6},{t4,x8},{t9,x8},{t7,x},{t4,x1},{t,x3},{t6,x4},
    		{t5,x5},{t,x9},{t1,x4},{t5,x},
    		{t1,x6},{t3,x8},{t3,x8},{t3,x},{t,x1},{t9,x3},{t2,x4},
    		{t4,x5},{t,x9},{t9,x4},{t5,x},
    		{t,x6},{t2,x8},{t1,x8},   	    };
    
    
    public screen(){
    	  addKeyListener(new Kcontrol());
          setFocusable(true);
          setDoubleBuffered(true);
          
          setSize(1400,600);
    
          cannon = new cannon();
          
          
    
          initalien();
          
          timer = new Timer(50, this);
          timer.start();}
          
          public void addNotify() {
              super.addNotify();
              S_WIDTH = getWidth();
              S_HEIGHT = getHeight();   
          }

          public void initAliens() {
              aliens = new ArrayList();
              aliens2 = new ArrayList();
              for (int i=0; i<pos.length; i++ ) {
                  aliens.add(new alien(pos[i][0], pos[i][1]));
                 
              }
              aliens2= new ArrayList();
              for (int j=0 ;j<pos2.length; j++ ){
            	  aliens2.add(new alien2(pos2[j][0], pos2[j][1]));
            	  
              }
          }
         
          
    
    
    public String background= "background.jpg";
    public void paint(Graphics g)
    {
    	ImageIcon img2 = new ImageIcon(this.getClass().getResource(background));
    	super.paint(g);
    	
     g.drawImage(img2.getImage(), 0, 0, getWidth(), getHeight(), null);
        
      
      if (ingame) {

            Graphics2D g2d = (Graphics2D)g;

            if (cannon.isVisible())
                g2d.drawImage(cannon.getImage(), cannon.getX(), cannon.getY(),
                              this);
            ArrayList ms = cannon.getBall();

            for (int i = 0; i < ms.size(); i++) {
                ball b = (ball)ms.get(i);
                g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }

            for (int i = 0; i < aliens.size(); i++) {
                alien a = (alien)aliens.get(i);
                if (a.isVisible())
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
            
            for (int k = 0; k < aliens2.size();k++) {
                alien2 b = (alien2)aliens2.get(k);
                if (b.isVisible())
                    g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
            
            g2d.setColor(Color.WHITE);
            g2d.drawString("Score:  " + counter1*2+counter2 , 5, 15);

        }
        else{
            	String msg = "Game Over";
            	int scr = counter1*2+counter2;
            Font small = new Font("Goudy Stout", Font.BOLD, 25);
            FontMetrics metr = this.getFontMetrics(small);
            
            g.setColor(Color.black);
            g.setFont(small);
            g.drawString(msg, (S_WIDTH - metr.stringWidth(msg)) / 2,
                         S_HEIGHT / 2);
            g.drawString("Score:  " + counter1*2+counter2 ,550 ,370 );
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void initalien() {
        aliens = new ArrayList();
        aliens2 = new ArrayList();
        for (int i=0; i<pos.length; i++ ) {
            aliens.add(new alien(pos[i][0], pos[i][1]));
        }
        for (int y=0; y<pos.length; y++ ) {
            aliens2.add(new alien2(pos[y][0], pos[y][1]));
        }
    }
  
	
	public void actionPerformed(ActionEvent k) {
    	if (aliens.size()==0&&aliens2.size()==0) {
            ingame = false;
            
        }

        ArrayList ms = cannon.getBall();

        for (int i = 0; i < ms.size(); i++) {
           ball m = (ball) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }

        for (int i = 0; i < aliens.size(); i++) {
            alien a = (alien) aliens.get(i);
            if (a.isVisible()) 
                a.move();
            else aliens.remove(i);
          
        }
        for (int i = 0; i < aliens2.size(); i++) {
            alien2 a = (alien2) aliens2.get(i);
            if (a.isVisible()) 
                a.move();
            else aliens2.remove(i);
       }

        cannon.move();
        checkCollisions();
        repaint();  
    }
    public void checkCollisions(){
    	Rectangle r5 = cannon.getBounds(); 
    	Rectangle r3 = cannon.getBounds();
    	 for (int j = 0; j<aliens.size(); j++) {
             alien a = (alien) aliens.get(j);
             Rectangle r2 = a.getBounds();
             

             if (r3.intersects(r2)) {
                 cannon.setVisible(false);
                 a.setVisible(false);
                 ingame = false;
             }
         }
 
    	 for (int j = 0; j<aliens2.size(); j++) {
             alien2 b = (alien2) aliens2.get(j);
             Rectangle r6 = b.getBounds();
             

             if (r5.intersects(r6)) {
                 cannon.setVisible(false);
                 b.setVisible(false);
                 ingame = false;
             }
         }

    	 ArrayList ms = cannon.getBall();

         for (int i = 0; i < ms.size(); i++) {
             ball m = (ball) ms.get(i);

             Rectangle r1 = m.getBounds();

             for (int j = 0; j<aliens.size(); j++) {
                 alien a = (alien) aliens.get(j);
                 Rectangle r2 = a.getBounds();
                 

                 if (r1.intersects(r2)) {
                     m.setVisible(false);
                     a.setVisible(false);
                     counter1=counter1+j;
                 }
             }
         }
         for (int i = 0; i < ms.size(); i++) {
             ball m2 = (ball) ms.get(i);

             Rectangle r9 = m2.getBounds();

             for (int j = 0; j<aliens2.size(); j++) {
                 alien2 c = (alien2) aliens2.get(j);
                 Rectangle r6 = c.getBounds();
                 

                 if (r9.intersects(r6)) {
                     m2.setVisible(false);
                     c.setVisible(false);
                     counter2=counter2+j;
                 }
             }
         }
     }

	

    	
    
private class Kcontrol extends KeyAdapter {

   
	public void keyReleased(KeyEvent e) {
        cannon.keyReleased(e);
        
    }

    public void keyPressed(KeyEvent e) {
        cannon.keyPressed(e);
    }
}

}
		
	


