package ucm.is2.torreznoshop.experimental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class GraphApplication extends JFrame {
    
	//Some text
    private JLabel statusbar;
	
    public GraphApplication() {

        initUI();
    }

    private void initUI() {
    	/* this = the frame */
    
        this.add(new Board());
        
        // create the status bar panel and shove it down the bottom of the frame
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        statusPanel.setBackground(Color.black);
        
        JLabel torreznosLabel = new JLabel("Nº Torreznos: 50");
        torreznosLabel.setHorizontalAlignment(SwingConstants.LEFT);
        torreznosLabel.setForeground(Color.white);
        statusPanel.add(torreznosLabel);
        
        statusPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        
        JLabel hpLabel = new JLabel("HP: 100");
        hpLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        hpLabel.setForeground(Color.white);
        statusPanel.add(hpLabel);
        
        setTitle("The Lord of The Torreznos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void runGUI() {
        
        EventQueue.invokeLater(() -> {
            GraphApplication ex = new GraphApplication();
            ex.setVisible(true);
        });
    }
}