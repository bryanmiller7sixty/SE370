/*  SE 370 - Principles of Software Engineering
    Lab #3 Code - Team 4
    Names: Bryan Miller, Jonar Reyes, Jacob Valenzuela
*/
import java.awt.*;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CardRandomizer extends JFrame implements ActionListener{
    JButton shuffle = new JButton("SHUFFLE");
    JPanel southPanel = new JPanel();
    JPanel centerP = new JPanel();
    JPanel westP = new JPanel();
    JPanel eastP = new JPanel();
    JPanel northP = new JPanel();
    ArrayList<ImageIcon> arr = new ArrayList<>();
    ArrayList<ImageIcon> arr2 = new ArrayList<>();
    JPanel mainPanel = new JPanel();
    Random rand = new Random();

    public CardRandomizer() throws IOException {
        String imageSrc = "src/PNG-cards-1.3/.png";
        ImageIcon image;

        for(int i = 1; i < 53; i++){
            String replaceString = imageSrc.replace(".png", i + ".png");
            image = new ImageIcon(replaceString);
            arr.add(image);
        }

        for(int i = 52; i > 0; i--){
            int max = 52;
            int min = 0;
            boolean flag = true;
            while(true){
                int randomNum = rand.nextInt((max - min));
                if(!arr2.contains(arr.get(randomNum))){
                    arr2.add(arr.get(randomNum));
                    break;
                }
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        setTitle("Icons") ;

        shuffle.setSize(50,50);
        setSize(1000, 1000) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        setLocationRelativeTo(null);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(northP, BorderLayout.NORTH);
        northP.setPreferredSize(new Dimension(600, 700));
        shuffle.addActionListener(this);
        shuffle.setActionCommand("Shuffle");
        northP.setLayout(new BorderLayout());
        northP.setBackground(new Color(0, 87, 4));
        GridLayout experimentLayout = new GridLayout(4,13);
        experimentLayout.setHgap(Integer.parseInt("29"));
        experimentLayout.setVgap(Integer.parseInt("30"));
        northP.setLayout(experimentLayout);

        for(int i = 0; i < 52; i++){
            JPanel panel1 = new JPanel();
            JLabel label1 = new JLabel(arr2.get(i));
            panel1.add(label1);
            northP.add(panel1);
        }

        mainPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setPreferredSize(new Dimension(1000, 45));
        southPanel.setLayout(new BorderLayout());
        westP.setPreferredSize(new Dimension(300, 50));
        eastP.setPreferredSize(new Dimension(300, 50));
        westP.setBackground(new Color(0, 87, 4));
        eastP.setBackground(new Color(0, 87, 4));
        southPanel.add(westP, BorderLayout.WEST);
        southPanel.add(eastP, BorderLayout.EAST);
        centerP.setBackground(new Color(0, 87, 4));
        southPanel.add(centerP, BorderLayout.CENTER);
        shuffle.setPreferredSize(new Dimension(400, 30));
        centerP.add(shuffle);
    }public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("Shuffle")){

            northP.removeAll();
            arr2.clear();

            for(int i = 52; i > 0; i--){
                int max = 52;
                int min = 0;
                boolean flag = true;
                while(true){
                    int randomNum = rand.nextInt((max - min));
                    if(!arr2.contains(arr.get(randomNum))){
                        arr2.add(arr.get(randomNum));
                        break;
                    }
                }
            }

            mainPanel.add(northP, BorderLayout.NORTH);
            northP.setPreferredSize(new Dimension(600, 700));
            shuffle.addActionListener(this);
            shuffle.setActionCommand("Shuffle");
            northP.setLayout(new BorderLayout());
            northP.setBackground(new Color(0, 87, 4));
            GridLayout experimentLayout = new GridLayout(4,13);
            experimentLayout.setHgap(Integer.parseInt("29"));
            experimentLayout.setVgap(Integer.parseInt("30"));
            northP.setLayout(experimentLayout);
            for(int i = 0; i < 52; i++){
                JPanel panel1 = new JPanel();
                JLabel label1 = new JLabel(arr2.get(i));
                panel1.add(label1);
                northP.add(panel1);
            }
        }
        revalidate();
        repaint();
    }public static void main(String[] args) throws IOException {

        CardRandomizer frame = new CardRandomizer() ;
        frame.setVisible(true) ;
    }
}
