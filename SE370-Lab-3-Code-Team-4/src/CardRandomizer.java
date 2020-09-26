/*  SE 370 - Principles of Software Engineering
    Lab #3 Code - Team 4 
    Names: Bryan Miller, Jonar Reyes, Jacob Valenzuela
    Date last edited: 9/26/2020
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.Random;

public class CardRandomizer extends JFrame implements ActionListener{
    
    boolean flag = false;
    Panel p = new Panel();
    JButton btn = new JButton("Shuffle");
    
    public CardRandomizer() {
        this.setTitle("Card Randomizer");
        this.setSize(1500, 1000);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setContentPane(p);
        this.getContentPane().setBackground(new Color(0, 87, 4));
        
        add(btn);
        btn.addActionListener(this);
        btn.setBounds(0, 910, 1484, 50);
    }
    
    public void actionPerformed(ActionEvent e) {
        flag = true;
        p.remove(btn);
        JButton btn2 = new JButton("Reshuffle");
        add(btn2);
       	btn2.addActionListener(this);
       	btn2.setBounds(0, 910, 1484, 50);
    }
    
    public class Panel extends JPanel {
        
        private ImageIcon icon;
        
    }
    
    public static void main(String[] args) {
        CardRandomizer application = new CardRandomizer();
    }
}
