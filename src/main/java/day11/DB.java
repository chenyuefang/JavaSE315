package day11;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.*;

public class DB {

    public static void main(String[] args) throws SQLException {
        new Driver();
        JDBC4Connection connection = (JDBC4Connection) DriverManager.getConnection("jdbc:mysql:///?user=root&password=system&useSSL=false");
        System.out.println(connection);
//        PreparedStatement preparedStatement = connection.prepareStatement("");
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            Statement
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println(databaseMetaData.getDatabaseMajorVersion());
        System.out.println(databaseMetaData.getDatabaseMinorVersion());
        System.out.println(databaseMetaData.getDatabaseProductVersion());
    }
}