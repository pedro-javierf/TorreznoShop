package ucm.is2.torreznoshop.experimental;

import ucm.is2.torreznoshop.elements.Player;
import ucm.is2.torreznoshop.spaces.Room;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class DrawablePlayer extends Player {
	
	    private int dx;
	    private int dy;
	    private int x = 40;
	    private int y = 60;
	    private int w;
	    private int h;
	    private Image image;

	    // Images for each animation
	    private BufferedImage[] walkingLeft = {Sprite.getSprite(12, 10)}; // Gets the upper left images of my sprite sheet
	    private BufferedImage[] walkingRight = {Sprite.getSprite(13,
	    		8)};
	    private BufferedImage[] walkingUp = {Sprite.getSprite(12, 8)};
	    private BufferedImage[] standing = {Sprite.getSprite(14, 9)};

	    // These are animation states
	    private Animation walkLeft = new Animation(walkingLeft, 10);
	    private Animation walkRight = new Animation(walkingRight, 10);
	    private Animation walkUp = new Animation(walkingUp, 10);
	    private Animation standingAnim = new Animation(standing, 10);

	    // This is the actual animation
	    protected Animation animation = standingAnim;
	    
	    
	    public DrawablePlayer(int hp, int money, Room startingRoom) {
			super(hp, money, startingRoom, 2);
			// TODO Auto-generated constructor stub
		}
	    
	    public DrawablePlayer() {
	    	super(100, 2000, null, 2);
	        //loadImage();
	    }

	    /*
	    private void loadImage() {
	        
	        ImageIcon ii = new ImageIcon("src/resources/OldMan.png");
	        image = ii.getImage(); 
	        
	        w = image.getWidth(null);
	        h = image.getHeight(null);
	    }*/

	    public void move() {
	        
	        x += dx;
	        y += dy;
	    }

	    public int getX() {
	        
	        return x;
	    }

	    public int getY() {
	        
	        return y;
	    }
	    
	    public int getWidth() {
	        
	        return w;
	    }
	    
	    public int getHeight() {
	        
	        return h;
	    }    

	    public Image getImage() {
	        
	        return image;
	    }

	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dx = -2;
	            animation = walkLeft;
	            animation.start();
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 2;
	            animation = walkRight;
	            animation.start();
	        }

	        if (key == KeyEvent.VK_UP) {
	            dy = -2;
	            animation = walkUp;
	            animation.update();
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dy = 2;
	            animation = standingAnim;
	            animation.update();
	        }
	    }

	    public void keyReleased(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dx = 0;
	            animation.stop();
	            animation.reset();
	            animation = standingAnim;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 0;
	            animation.stop();
	            animation.reset();
	            animation = standingAnim;
	        }

	        if (key == KeyEvent.VK_UP) {
	            dy = 0;
	            animation.stop();
	            animation.reset();
	            animation = standingAnim;
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dy = 0;
	            animation.stop();
	            animation.reset();
	            animation = standingAnim;
	        }
	    }

}
