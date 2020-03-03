package ucm.is2.torreznoshop.experimental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ucm.is2.torreznoshop.elements.Player;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private DrawablePlayer player;
    private final int DELAY = 10;

    
    
    public Board() {

        initBoard();
    }

    private void initBoard() {
    	
        
    	
    	addKeyListener(new TAdapter());
        
    	
    	//setLayout(new BorderLayout());
        //JLabel background=new JLabel(new ImageIcon("C:\\Users\\usuario_local\\Downloads\\TorreznoShop-master\\src\\resources\\background.jpg"));
        //add(background);
        //background.setLayout(new FlowLayout());
    	
    	//setBackground(Color.black);
        setFocusable(true);

        player = new DrawablePlayer();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        //g.drawImage(animation.getSprite(), x, y, null);
        
        g2d.drawImage(player.animation.getSprite(), player.getX(), 
            player.getY(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }
    
    private void step() {
        
        player.move();
        
        repaint(player.getX()-1, player.getY()-1, 
                player.getWidth()+2, player.getHeight()+2);     
    }    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}