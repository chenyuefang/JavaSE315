package day08;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    create database ...;
    create table ...;
    insert into ...;
    update ...;
    delete ...;
    select ...;
    drop table ...;
    drop database ...;
 */
public class MySqlCommandLine {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String name = "root";
    private static final String password = "123456";
    private Connection connection;
    private static  Scanner scanner;
    private  static  SimpleDateFormat simpleDateFormat;

    public MySqlCommandLine() {
        scanner = new Scanner(System.in);
        getConnection(); // 获取数据库的连接
        simpleDateFormat = new SimpleDateFormat("[YYYY-MM-DD HH:mm:ss]");
        // 创建时间的一个实例
    }

    public Connection getConnection() { // singleton 单例模式
        if (connection == null) {
            try {
//                new Driver();
                connection = DriverManager.getConnection(URL,name,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void update(String sql) {
        // TODO: 2019/3/27  具体操作

        PreparedStatement preparedStatement;

        try {
            long start = System.currentTimeMillis(); // 系统当前毫秒数
            preparedStatement = connection.prepareStatement(sql);
            int rowAffected = preparedStatement.executeUpdate();// 更新时受影响的行数
            long end = System.currentTimeMillis();

            System.out.println(simpleDateFormat.format(new Date(end )));// 结束时系统的时间
            System.out.println(rowAffected  +  "row affected in " + (end - start) + "ms"); // end - start : 运行的时间
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void query(String sql) {
        // TODO: 2019/3/27  具体操作

    }

    public void dispatch(String sql) {
        if (sql.toLowerCase().trim().startsWith("select")) { // toLowerCase(): 小写  trim() : 空格处理
            query(sql);
        } else {
            update(sql);
        }
    }

    public  String getSQL() {
        System.out.println("input SQL statement: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
      //  Scanner scanner = new Scanner(System.in);
      //  System.out.println("input SQL statement: ");
       // String sql = scanner.nextLine();
        MySqlCommandLine mySqlCommandLine = new MySqlCommandLine();
        String sql = mySqlCommandLine.getSQL();
        mySqlCommandLine.dispatch(sql);
    }
}