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
        Polygon p = new Polygon();
        Courbe cc = new Courbe();
        b5.addActionListener(e -> {

            if(b5.getText().equals("f(x1)")) {cc.start(); b5.setText("f(x1): Pause");}
            else if(b5.getText().equals("f(x1): Pause")){cc.suspend(); b5.setText("f(x1): Resume");}
            else if(b5.getText().equals("f(x1): Resume")){cc.resume(); b5.setText("f(x1): Pause");}



        });
        b6.addActionListener(e -> {
            g.setColor(Color.WHITE);
            int x1=-10000;
            int y1=4+ (int) Math.pow(x1,2)-3*x1+5;
            for (int x2=-10000;x2<=10000;x2++){
                int y2 = 4*(int) Math.pow(x2,2)-3*x2+5;
                g.drawLine(x1+500,cv.getHeight()-y1,x2+500,cv.getHeight()-y2);

                x1=x2;
                y1=y2;
            }
        });
        b7.addActionListener(e -> {
            g.setColor(Color.WHITE);
            //g.drawArc(50,50,150,150,225,270);

            g.fillArc(50,50,150,150,225,270);
        });
        b8.addActionListener(e -> {
            g.clearRect(0, 0, cv.getWidth(), cv.getHeight());
            //cv.update(g);
        });

        this.setLayout(new BorderLayout());
        this.add(cv,BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);
        this.setVisible(true);
        g = cv.getGraphics();

    }

    double f(double x) {
        return (Math.cos(x/7)+Math.sin(x/5)+3)*100;
    }

    public static void main(String[] args) {
        Graphe g = new Graphe();
    }

    class Courbe extends Thread{
        Courbe(){

        }

        public void run(){
            g.setColor(Color.WHITE);
            for (int x=0;x<=1000;x++){
                g.drawLine(x,(int)f(x), x+1, (int)f(x+1));
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}

