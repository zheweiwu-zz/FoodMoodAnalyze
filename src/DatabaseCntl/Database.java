package DatabaseCntl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        ResultSet results = db.getRows("SELECT * FROM moods WHERE username='"+Database.username+"'");
        while (results.next()){
            if (results.getString("mood").equals("1") || results.getString("mood").equals("2")) {
                negative++;
            }
            if (results.getString("mood").equals("3")) {
                neutral++;
            }
            if (results.getString("mood").equals("4") || results.getString("mood").equals("5")) {
                positive++;
            }
        }
        int[] A = {negative,neutral,positive};
        return A;
    }
    
    public void insertSql(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }

    public ResultSet getRows(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
}
