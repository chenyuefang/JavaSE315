package day08;

import sun.net.ProgressSource;

import java.sql.*;

//  JDBC - Java DataBase Connectivity


public class JDBC {

    private static final String URL="jdbc:mysql://127.0.0.1:3306";
    private static final String User="root";
    private static final String PASSWORD="123456";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         // 1.Driver
      //  new Driver();
        Class.forName("com.mysql.jdbc.Driver");
        // 2.Connection
        Connection connection = DriverManager.getConnection(URL,User,PASSWORD);

        //3.PrepareStatement
        String sql = "create database sdfas;";
        String sl = "show databases";

        Statement statement = connection.createStatement();

        statement.execute(sql);

        connection.close();
        System.out.println("done.");
    }


}
