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
    private  PreparedStatement preparedStatement; // 可做查询的语句
    private  ResultSet resultSet; // 结果集 用来接收查询的结果
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

    /**
     * DDL: create alter drop truncate
     * DML: insert update delete
     *
     * @param sql statement
     */

    public void update(String sql) {  // .executeUpdate(); -- DDL：（create、alter、drop、表间连接）  DML: （insert、update、delete）
        // TODO: 2019/3/27  具体操作

        PreparedStatement preparedStatement;

        try {
            long start = System.currentTimeMillis(); // 系统当前毫秒数
            preparedStatement = connection.prepareStatement(sql);
            int rowAffected = preparedStatement.executeUpdate();// 更新时受影响的行数
            long end = System.currentTimeMillis();

            System.out.print(simpleDateFormat.format(new Date(end )));// 结束时系统的时间
            System.out.println(rowAffected  +  "row affected in " + (end - start) + "ms"); // end - start : 运行的时间
        } catch (SQLException e) {
           // e.printStackTrace(); 显示详细错误，信息过多
            System.out.println("ERROR: " + e.getMessage()); // e.getMessage()： 简化错误信息
        }
    }

    /**
     * DQL: select
     *
     * @param sql statement
     */

    public void query(String sql) {  // .executeQuery(); -- DQL：insert
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(); // 接收结果
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); // 数据库的元数据
            System.out.println(resultSetMetaData.getColumnCount());            // 3 ：显示数据库一共有几列元素
            System.out.println(resultSetMetaData.getColumnClassName(1));       // java.lang.Integer
            System.out.println(resultSetMetaData.getColumnDisplaySize(1));     // 11 ：第一列元素的长度
            System.out.println(resultSetMetaData.getColumnLabel(1));           // id
            System.out.println(resultSetMetaData.getColumnName(1));            // id ：第一列元素名称
            System.out.println(resultSetMetaData.getColumnType(1));            // 4 ：第一列元素
            System.out.println(resultSetMetaData.getColumnTypeName(1));        // INT ：第一列元素类型名

            while (resultSet.next()) {
                // TODO: 2019/3/27 数据库的列数是未知的 ， 用ResultSetMetaData处理
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dispatch(String sql) {
        if (sql.toLowerCase().trim().startsWith("select")) { // toLowerCase(): 小写  trim() : 空格处理
            query(sql);
        } else {
            update(sql);
        }
    }

    public  String getSQL() {
        System.out.print("mysql> ");// 语句执行以"mysql> "开始，用户在"mysql> "后输入执行语句
        String sql = scanner.nextLine();
        // TODO: 2019/3/27 sql.endsWith(";"); 如何做到以“；”作为结束标志
        return sql;
    }

    public static void main(String[] args) {
      //  Scanner scanner = new Scanner(System.in);
      //  System.out.println("input SQL statement: ");
       // String sql = scanner.nextLine(); // 在主方法是创建一次，便可直接调用
        MySqlCommandLine mySqlCommandLine = new MySqlCommandLine();
        String sql = mySqlCommandLine.getSQL();
        while (!sql.equalsIgnoreCase("quit")) { // 语句若是“quit"，就执行结束，若不是”quit“ ，便继续执行，并显示"mysql> "
            mySqlCommandLine.dispatch(sql);
            sql = mySqlCommandLine.getSQL();
    }
}
/**
        mySqlCommandLine.getConnection();

       //PreparedStatement

        // 用户在登录表单填写的值
     1.PreparedStatement
        String username = "Tom";
        String password = ""123;

     2.Statement
        String username = "' or 'a'='a";   // SQL Injection 注入 ， 是Statement 中的漏洞
        String password = "' or 'a'='a";

       1.PreparedStatement :

        String sql1 = "select * from db_test.user where username = ? and password = md5("?"); // md5() : 密码加密
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        System.out.println(resultSet1.next()); // true  ： 用户名以及密码必须全部正确，用户可以登录

       2.Statement  ： 语句中不能带有任何的未知数，需用字符串的拼接，（会存在安全隐患，不建议使用）

        String sql2 = "select * from db_test.user where username = '" + username + "' and password = '" + password + "'";
        System.out.println(sql2);
        Statement statement = connection.createStatement();
        ResultSet resultSet2 = statement.executeQuery(sql2);
        System.out.println(resultSet2.next()); // 随便输入程序也会显示 true ，是 Statement 中无法避免的漏洞
        */
}
