package alienshooter;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class ball {
	private int x, y;
    private Image image;
    boolean visible;
    private int width, height;

    private final int BOARD_WIDTH = 1400;
    private final int MISSILE_SPEED = 8;


public ball(int x, int y) {

    ImageIcon img3 = new ImageIcon(this.getClass().getResource("CannonBall2.png"));
    image = img3.getImage();
    visible = true;
    width = image.getWidth(null);
    height = image.getHeight(null);
    this.x = x;
    this.y = y;
}
public Image getImage() {
    return image;
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

public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
}

public void move() {
    x += MISSILE_SPEED;
    if (x > BOARD_WIDTH)
        visible = false;
}
}