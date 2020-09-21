/*  SE 370 - Principles of Software Engineering
    Lab #2 Code - Team 4 
    Names: Bryan Miller, Jonar Reyes, Jacob Valenzuela
    Date last edited: 9/21/2020
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Random;

public class RandomBarChart extends JFrame implements ActionListener{
    
    boolean flag = false;
    
    public RandomBarChart() {
        this.setTitle("Random Bar Chart");
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel p = new Panel();
        setContentPane(p);
        this.getContentPane().setBackground(Color.gray);
        
        JButton btn = new JButton("Draw/Redraw");
        add(btn);
        btn.addActionListener(this);
        btn.setActionCommand("Pressed");
        btn.setBounds(270, 520, 503, 50);
    }
    
    public void actionPerformed(ActionEvent e) {
        flag = true;
        repaint();
    }
    
    public class Panel extends JPanel {
        
        public void paintComponent(Graphics g) {
            int RECT_X = 220;
            int RECT_Y = 20;
            int RECT_WIDTH = 50;
            int RECT_HEIGHT = RECT_WIDTH;
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            for (int i = 1; i <= 100; i++) {
                RECT_X += 50;
                g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
                if (i % 10 == 0) {
                    RECT_X = 220;
                    RECT_Y += 50;
                }
            }
        
            int min = 20;
            int max = 530;
            g2d.setStroke(new BasicStroke(10f));
            
            if(flag == true) {
                g2d.setColor(Color.RED);
                g2d.draw(new Line2D.Double(RECT_X+100, (Math.random() * max) + min, RECT_X+100, 550));
                g2d.setColor(Color.yellow);
                g2d.draw(new Line2D.Double(RECT_X+200, (Math.random() * max) + min, RECT_X+200, 550));
                g2d.setColor(Color.orange);
                g2d.draw(new Line2D.Double(RECT_X+300, (Math.random() * max) + min, RECT_X+300, 550));
                g2d.setColor(Color.green);
                g2d.draw(new Line2D.Double(RECT_X+400, (Math.random() * max) + min, RECT_X+400, 550));
                g2d.setColor(Color.blue);
                g2d.draw(new Line2D.Double(RECT_X+500, (Math.random() * max) + min, RECT_X+500, 550));
            }
        }
    }
    
    public static void main(String[] args) {
        RandomBarChart application = new RandomBarChart();
    }
}
