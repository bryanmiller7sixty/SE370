
import javax.swing.*;
import java.awt.*;

public class RandomBarChart extends JFrame{
    
    public RandomBarChart() {
        this.setTitle("Random Bar Chart");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel p = new Panel();
        this.setContentPane(p);
        this.getContentPane().setBackground(Color.gray);
    }
    
    public class Panel extends JPanel {
        public void paintComponent(Graphics g) {
            for(int i = 0; i < 400; i += 40) {
                for(int j = 0; j < 400; j += 40) {
                    g.setColor(Color.black);
                    g.drawRect(i, j, 40, 40);
                }
            }
        }
    }
}
