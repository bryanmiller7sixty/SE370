import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomBarChart extends JFrame implements ActionListener {
    //    int RECT_X = 220;
//    int RECT_Y = 20;
//    int RECT_WIDTH = 50;
//    int RECT_HEIGHT = RECT_WIDTH;
    public Panel p = new Panel();
    int count = 0;

    public RandomBarChart() {
        this.setTitle("Random Bar Chart");
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(p);
        this.getContentPane().setBackground(Color.gray);
        JButton btn = new JButton("1");
        btn.addActionListener(this);
        this.getContentPane().add(btn);
        btn.setBounds(270, 520, 503, 50);

    }

    public class Panel extends JPanel {
        public void paintComponent(Graphics g) {
            int RECT_X = 220;
            int RECT_Y = 20;
            int RECT_WIDTH = 50;
            int RECT_HEIGHT = RECT_WIDTH;
            super.paintComponent(g);
            for (int i = 1; i <= 100; i++) {
                RECT_X += 50;
                g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
                if (i % 10 == 0) {
                    RECT_X = 220;
                    RECT_Y += 50;
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("In loop");
        String actionCommand = e.getActionCommand();
        int max = 4;
        int min = 1;
        int range = max - min + 1;
        //p.removeAll();
        JButton btn = new JButton("1");
        btn.addActionListener(this);
        btn.setBounds(270, 520, 503, 50);
        getContentPane().add(btn);
        if (actionCommand.equals("1")) {
            for (int i = 2; i < 7; i++) {
                int rand = (int) (Math.random() * range) + min;
                if (rand == 1) {
                    p.getGraphics().fillRect((i * 100) + 70, 100, 30, 450);
                }
                if (rand == 2) {
                    p.getGraphics().fillRect((i * 100) + 70, 300, 30, 250);
                }
                if (rand == 3) {
                    p.getGraphics().fillRect((i * 100) + 70, 400, 30, 150);
                }
                if (rand == 4) {
                    p.getGraphics().fillRect((i * 100) + 70, 500, 30, 50);
                }
            }

        }
    }

    public static void main(String args[]) {
        RandomBarChart chart = new RandomBarChart();
    }
}
