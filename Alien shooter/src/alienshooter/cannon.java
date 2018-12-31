package alienshooter;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class cannon {

	public String cannon= "cannon.png";
	private int count=0;
	public int dy;
	public int dx;
	public int x;	
	public int y;
	public int width;
	public int height;
	protected boolean visible;
	private ArrayList ball;
	private Image image;
	public cannon(){
	ImageIcon img1 = new ImageIcon(this.getClass().getResource(cannon));	
	image = img1.getImage();	
	width = image.getWidth(null);
    height = image.getHeight(null);
    ball = new ArrayList();
    visible = true;
    x = 250;
    y= 270;
    		
	}
	
	public void move(){
		y+=dy;
		if (y<1){
			y=1;
		}
		
	}
	public int getX() {
        return x;
    }
	public void setX(int x) {
		this.x=x;
	}
	public int getY() {
        return y;
    }
	public void setY(int y) {
		this.y=y;
	}
	
	public Image getImage() {
        return image;
    }
	
	public ArrayList getBall() {
        return ball;
    }
	
	public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public void keyPressed(KeyEvent k) {
    	int key = k.getKeyCode();
    	
        
        
        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 5;
        }
    }
    public void fire() {
    	  	 
    	 
         
    	
        ball.add(new ball(x + width, y + height/2));
    }
    public void keyReleased(KeyEvent k) {
        int key = k.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE){
        	
            fire();
            
   			};
           	
    if (key == KeyEvent.VK_UP) {
        dy = 0;
    }

    if (key == KeyEvent.VK_DOWN) {
        dy = 0;
    }
}
        
}
