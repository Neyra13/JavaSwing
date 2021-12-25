package Seance4.TP4;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class MyDataBase {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public boolean add(Object o){
        try {
            Personne p = (Personne) o;
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/tp4_swing", "root", "");
            String SQL = "INSERT INTO user (nom, adresse) VALUES(?,?);";
            preparedStatement = connect.prepareStatement(SQL);
            preparedStatement.setString(1,p.getNom());
            preparedStatement.setString(2,p.getAddress());
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int  modify(Object o){
        try {
            Personne p = (Personne) o;
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/tp4_swing", "root", "");
            String SQL = "UPDATE user set adresse=?  WHERE nom=?;";
            preparedStatement = connect.prepareStatement(SQL);
            System.out.println(p.getAddress());
            preparedStatement.setString(1,p.getAddress());
            preparedStatement.setString(2,p.getNom());
            return preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public boolean delete(Object o){
        try {
            Personne p = (Personne) o;
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/tp4_swing", "root", "");
            String SQL = "DELETE FROM user WHERE nom=?;";
            preparedStatement = connect.prepareStatement(SQL);
            preparedStatement.setString(1,p.getNom());
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Personne> remplir(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            ArrayList<Personne> p = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/tp4_swing", "root", "");
            String query = "SELECT * FROM user";
            Statement stm = connect.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                model.addRow(new Object[]{res.getInt(1),res.getString(2),res.getString(3)});
            }
            return p;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}