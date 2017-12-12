package DatabaseCntl;

import FoodModel.FoodModel;
import MoodModel.MoodModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zheweiwu
 */
public class Database {
    private static Connection connection = null;
    private static Statement statement;
    public static String username;
    private String password;
    private static Database db;

    private Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:FoodMood.db");
        statement = connection.createStatement();
        statement.setQueryTimeout(30);
    }

    public static Database getInstance() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            db = new Database();
        }
        return db;
    }
    
    public static boolean authProfile(String username, String password) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='" + username + "'");
        String pw = null;
        while (results.next()) {
            pw = results.getString("password");
        }
        if (password.equals(pw)) {
            Database.username = username;
        }
        return password.equals(pw);
    }
    
    public static int[] getCorrelations() throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        int negative = 0;
        int neutral = 0;
        int positive = 0;
        ResultSet results = db.getRows("SELECT * FROM moods WHERE userid='"+Database.username+"'");
        while (results.next()){
            if (results.getString("rating").equals("1") || results.getString("rating").equals("2")) {
                negative++;
            }
            if (results.getString("rating").equals("3")) {
                neutral++;
            }
            if (results.getString("rating").equals("4") || results.getString("rating").equals("5")) {
                positive++;
            }
        }
        int[] A = {negative,neutral,positive};
        return A;
    }
    
    public static String[] getAssociatedFood() throws SQLException, ClassNotFoundException {
        Database db = getInstance();
        String negative = null;
        String neutral = null;
        String positive = null;
        ResultSet results = db.getRows("SELECT * FROM moods WHERE userid='"+Database.username+"'");
        ArrayList<String> ratings = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        while (results.next()){
            ratings.add(results.getString("rating"));
            ids.add(results.getString("id"));
        }
        for (int i = 0; i<ids.size(); i++) {
            ResultSet food = db.getRows("SELECT * from foods where id = '"+ids.get(i)+"'");
            String foodName = null;
            while (food.next()) {
               foodName = food.getString("food");
            }
            if (ratings.get(i).equals("1") || ratings.get(i).equals("2")) {
                negative = foodName + ",";
            }
            if (ratings.get(i).equals("3")) {
                neutral = foodName + ",";
            }
            if (ratings.get(i).equals("4") || ratings.get(i).equals("5")) {
                positive = foodName + ",";
            }
        }
        String [] A = {negative, neutral, positive};
        return A;
    }
    
    public static ArrayList<FoodModel> getFoods() throws ClassNotFoundException, SQLException {
        ArrayList<FoodModel> foods = new ArrayList<>();
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM foods WHERE userid='" + Database.username + "'");
        while (results.next()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(results.getString("datetime"), formatter);
            foods.add(new FoodModel(results.getString("food"), dateTime, results.getString("id")));
        }
        return foods;
    }
    
    public static ArrayList<MoodModel> getMoods() throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM moods WHERE userid='" + Database.username + "'");
        ArrayList<MoodModel> moods = new ArrayList<>();
        while (results.next()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(results.getString("datetime"), formatter);
            moods.add(new MoodModel(Integer.parseInt(results.getString("rating")), dateTime, results.getString("id")));
        }
        return moods;
    }
    
    public void insertSql(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }

    public ResultSet getRows(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Database.username = "zhewei";
        System.out.println(Database.getAssociatedFood()[2]);
    }
}
