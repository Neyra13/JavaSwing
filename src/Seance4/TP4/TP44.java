package Seance4.TP4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class TP44 extends JFrame {

    static JButton b1 = new JButton("Ajouter");
    JTextField t1= new JTextField("");
    JTextField t= new JTextField("");
    MyDataBase myDataBase = new MyDataBase();

    public TP44()  {
        this.setTitle("TP Base");
        this.setSize(500, 400);
        this.setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String data[][]= new String[50][8];
        String column[]={"ID","NAME","Adresse"};
        DefaultTableModel model = new DefaultTableModel( column,0);
        JTable jt=new JTable(model);
        JScrollPane sp=new JScrollPane(jt);

        JLabel l = new JLabel("Nom");

        JLabel l1 = new JLabel("Adresse");

        JButton b2 = new JButton("Supprimer");
        JButton b3 = new JButton("Modifier");
        JButton b4 = new JButton("Remplir");

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        JPanel p2 = new JPanel(new GridLayout(1, 4));

        p1.add(l);
        p1.add(t);
        p1.add(l1);
        p1.add(t1);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        this.setLayout(new BorderLayout());

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(sp, BorderLayout.CENTER);
        this.setVisible(true);
        myDataBase.remplir(model);

        b2.addActionListener(e->{
            Personne p = new Personne(t.getText(),t1.getText());
            myDataBase.delete(p);
            myDataBase.remplir(model);
        });
        b1.addActionListener(e -> {
            Personne p = new Personne(t.getText(),t1.getText());
            myDataBase.add(p);
            myDataBase.remplir(model);
        });
        b3.addActionListener(e ->{
            Personne p = new Personne(t.getText(),t1.getText());
            System.out.println(myDataBase.modify(p));
        });
        b4.addActionListener(e -> {
            myDataBase.remplir(model);

            //jt = new JTable(model);
        });
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        TP44 t = new TP44();
    }
}