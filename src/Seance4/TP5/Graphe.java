package Seance4.TP5;

import javax.swing.*;
import java.awt.*;

public class Graphe extends JFrame {
    Methodes m = new Methodes();
    Graphics g;

    public Graphe(){
        this.setTitle("graphe");
        this.setSize(1000, 900);
        this.setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Canvas cv = new Canvas();
        cv.setBackground(Color.BLACK);
        JButton b1 = new JButton("ligne");
        JButton b2 = new JButton("cercle");
        JButton b3 = new JButton("carré");
        JButton b4 = new JButton("poly");
        JButton b5 = new JButton("f(x1)");
        JButton b6 = new JButton("f(x2)");
        JButton b7 = new JButton("arc");
        JButton b8 = new JButton("annulé");

        JPanel panel = new JPanel(new GridLayout(1,8));

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);

        b1.addActionListener(e -> {
            g.setColor(Color.WHITE);
            g.drawLine(10,20,50,150);
        });
        b2.addActionListener(e -> {
            g.setColor(Color.WHITE);
            g.drawOval(120,20,150,150);
        });
        b3.addActionListener(e -> {
            g.setColor(Color.WHITE);
            g.drawRect(300,20,150,150);
        });
        b4.addActionListener(e -> {
            g.setColor(Color.WHITE);
            int tabX[]={300,400,500,350,300,250};
            int tabY[]={250,250,400,300,450,300};
            int nbrPoint = tabX.length;
            g.drawPolygon(tabX,tabY,nbrPoint);
        });
        b5.addActionListener(e -> {

        });
        b6.addActionListener(e -> {

        });
        b7.addActionListener(e -> {

        });
        b8.addActionListener(e -> {

        });

        this.setLayout(new BorderLayout());
        this.add(cv,BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);
        this.setVisible(true);
        g = cv.getGraphics();

    }

    public static void main(String[] args) {
        Graphe g = new Graphe();
    }
}
