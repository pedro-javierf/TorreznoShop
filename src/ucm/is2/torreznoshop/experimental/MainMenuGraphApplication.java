package ucm.is2.torreznoshop.experimental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class MainMenuGraphApplication extends JFrame {
    
	//Some text
    private JLabel statusbar;
	
    public MainMenuGraphApplication() {

        initUI();
    }

    private void initUI() {
    	/* this = the frame */
    
    	this.setLayout(new BorderLayout());
    	
    	JButton button2 = new JButton("Campaign");
    	add(button2);
    	JButton button1 = new JButton("Multiplayer");
    	add(button1);
    	
    	
    	//button2.addActionListener (new Action2());//note the button2 here instead of button
    	setTitle("The Lord of The Torreznos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }    
    
    public static void runGUI() {
        
        EventQueue.invokeLater(() -> {
            MainMenuGraphApplication ex = new MainMenuGraphApplication();
            ex.setVisible(true);
        });
    }
}