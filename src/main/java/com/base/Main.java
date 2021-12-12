package com.base;

import controller.Controller;
import views.ConsoleView;

import java.sql.*;
import java.util.Properties;

public class Main {
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //C:\Users\Tavi\Videos\IS\ProiectPOS\Database
        String dbUrl = "jdbc:derby:C:/Users/Tavi/Videos/IS/ProiectPOS/Database;create=true";

        Properties properties = new Properties();
        properties.put("user", "admin");
        properties.put("password", "");

        Connection connection = DriverManager.getConnection(dbUrl, properties);
        return connection;
    }

    private static void showAllUsers(Connection connection) throws SQLException {
        Statement connectionStatement = connection.createStatement();
        ResultSet results = connectionStatement.executeQuery("SELECT * FROM USER");
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        int numberOfCols = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= numberOfCols; i++) {
            //Column Names
            System.out.print(String.format(" %10s", resultSetMetaData.getColumnLabel(i)));
        }

        System.out.println("\n---------------------------------------------");

        while (results.next()) {
            int id = results.getInt(1);
            String description = results.getString(2);

            System.out.println(String.format(" %10s %10s", id, description));
        }

        results.close();
        connectionStatement.close();
        connection.close();
    }

    private static void addUser(Connection connection, String username, String password, int role, int state_id, String email, String name) throws SQLException{
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("INSERT INTO USER (\"username\", \"pass\", \"role\", \"state_id\", \"email\", \"name\") VALUES ('" + username + "','" + password + "','" + role + "','" + state_id + "','" + email + "','" + name + "')");

        stmt.close();
        connection.close();
    }

    private static void editUserById(Connection connection, int id) throws SQLException{
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("UPDATE USER SET \"username\" = 'edited username' WHERE \"id\" =" + id);

        stmt.close();
        connection.close();
    }

    private static void deleteUserById(Connection connection, int id) throws SQLException{
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("DELETE FROM USER WHERE \"id\" =" + id);

        stmt.close();
        connection.close();
    }

    private static void showUserById(Connection connection, int id) throws SQLException{
        Statement connectionStatement = connection.createStatement();
        ResultSet results = connectionStatement.executeQuery("SELECT * FROM USER WHERE \"id\" =" + id);
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        int numberOfCols = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= numberOfCols; i++) {
            System.out.print(String.format(" %10s", resultSetMetaData.getColumnLabel(i)));
        }

        System.out.println("\n---------------------------------------------");

        while (results.next()) {
            int resultId = results.getInt(1);
            String username = results.getString(2);
            String password = results.getString(3);

            System.out.println(String.format(" %10s %10s %10s %10s", resultId, username, password));
        }

        results.close();
        connectionStatement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ConsoleView view = new ConsoleView(new Store("Lidl", "Str. Rusciorului", new ProductCatalog()), new Controller());
        //view.start();

        addUser(getConnection(), "testuser", "testpass", 1, 1,"a@a.a", "Test" );
        showAllUsers(getConnection());
    }
}
