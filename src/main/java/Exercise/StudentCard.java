package Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentCard {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String name = "root";
    private static final String password = "123456";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private static Scanner scanner;

    public StudentCard() {
        scanner = new Scanner(System.in);
        try {
            preparedStatement.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, name, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void Query(String Card) {
        try {
            preparedStatement = connection.prepareStatement(Card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Update(String Card) {
        try {
            preparedStatement = connection.prepareStatement(Card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Insert(String Card) {
        try {
            preparedStatement = connection.prepareStatement(Card);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dispatch(String Card) {
        if (Card.toLowerCase().trim().startsWith("select")) { // toLowerCase(): 小写  trim() : 空格处理
            Query(Card);
        } else if (Card.toLowerCase().trim().startsWith("insert")) {

            Insert(Card);
        } else {
            Update(Card);
        }
    }

    public String getCard() {
        String line = scanner.nextLine();
        StringBuilder c = new StringBuilder(line);
        while (!line.endsWith(";")) {
            line = scanner.nextLine(); // 接收后面行的语句
            c.append(line); // 字符串的拼接
        }
        return c.toString();
    }

    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("input SQL statement: ");
         String sql = scanner.nextLine();
    }

}
