package alienshooter;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class alien2 {
	 private String alien2 = "alien2.png";

	    private int x;
	    private int y;
	    private int width;
	    private int height;
	    private boolean visible;
	    private Image image;
	    
	    public alien2(int x, int y) {
	        ImageIcon ii = new ImageIcon(this.getClass().getResource(alien2));
	        image = ii.getImage();
	        width = image.getWidth(null);
	        height = image.getHeight(null);
	        visible = true;
	        this.x = x;
	        this.y = y;
	    }
	    
	    public void move() {
	        if (x < 0) 
	            x = 400;
	        x -= 1;
	    }

	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }

	    public boolean isVisible() {
	        return visible;
	    }

	    public void setVisible(Boolean visible) {
	        this.visible = visible;
	    }

	    public Image getImage() {
	        return image;
	    }

	    public Rectangle getBounds() {
	        return new Rectangle(x, y, width, height);
	    }
	}
	    
	    
	    

