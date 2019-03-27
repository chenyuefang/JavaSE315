package day09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client  extends JFrame implements ActionListener {

    public  Client() {
        initComponent();
    }

    private void initComponent() {

        setTitle("MySQL Client"); // 设置标题
        setExtendedState(MAXIMIZED_BOTH); // 整个屏幕
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // 大小
        Font font =new Font("consolas", Font.PLAIN, 24); // 字形

        JPanel main = new JPanel(); // 主页面
        main.setLayout(new BorderLayout());

        TextArea sqlTextArea = new TextArea(); // SQL文本区域
        sqlTextArea.setPreferredSize(new Dimension(dimension.width,dimension.height /2));
        sqlTextArea.setFont(font);
        sqlTextArea.setForeground(Color.WHITE);
        sqlTextArea.setBackground(Color.darkGray);

        JPanel north = new JPanel();   // 屏幕上半部分
        north.setPreferredSize(new Dimension(dimension.width,dimension.height / 2)); // 占整个屏幕的一半

        north.add(sqlTextArea);  // 屏幕上半部分 显示SQL文本域


        JPanel south = new JPanel(); // 屏幕下半部分
        south.setLayout(new BorderLayout());
        south.setBackground(Color.WHITE);
        south.setPreferredSize(new Dimension(dimension.width,dimension.height / 2));

        TextArea outputTextArea = new TextArea();  // 文本区域 输出结果
        outputTextArea.setBackground(Color.WHITE);
        outputTextArea.setPreferredSize(new Dimension(dimension.width / 2, dimension.height / 2));
        outputTextArea.setEditable(false);  // 不可编辑

        String[] columnNames = {"ID", "USERNAME", "PASSWORD"};
        Object[][] rowData = {
                {1, "Tom", "123"},
                {2, "Jerry", "abc"}
        };

        JTable resultTable = new JTable(rowData, columnNames); // 结果显示
        resultTable.setBackground(Color.WHITE);
        resultTable.setPreferredSize(new Dimension(dimension.width / 2, dimension.height / 2));

        south.add(outputTextArea, BorderLayout.WEST); // 左下部分显示输出文本域
        south.add(resultTable, BorderLayout.EAST);  //  右下部分显示结果表格

        main.add(north, BorderLayout.NORTH);
        main.add(south, BorderLayout.SOUTH);
        add(main);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Client();
    }
}
