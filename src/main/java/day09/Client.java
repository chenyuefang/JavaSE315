

package day09;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Client extends JFrame {

    private JTextArea sqlJTextArea, outputJTextArea;
    private JTable resultJTable;
    private JScrollPane sqlJScrollPane, outputJScrollPane, resultJScrollPane;
    private JPanel southJPanel, main;
    static DefaultTableModel defaultTableModel;
    private Server server;

    private Client() {
        initComponent();
        initListener();
    }

    /**
     * 初始化组件
     */
    private void initComponent() {
//        1. 全局设置
        setTitle("MySQL Client");
        setExtendedState(MAXIMIZED_BOTH);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // 获取最大屏幕
        int width = dimension.width;
        int height = dimension.height;
        Font font = new Font("consolas", Font.PLAIN, 24);

//        2. SQL
        sqlJTextArea = new JTextArea();  // SQL 的文本输入域
        sqlJTextArea.setBackground(Color.darkGray);
        sqlJTextArea.setForeground(Color.WHITE);
        sqlJTextArea.setFont(font);
        sqlJTextArea.setCaretColor(Color.WHITE); // 设置光标的颜色
        sqlJTextArea.setCaretPosition(sqlJTextArea.getDocument().getLength()); // 设置光标的位置 ： sqlJTextArea.getDocument().getLength() SQL文本输入域中获取的文档的最后

        sqlJScrollPane = new JScrollPane(sqlJTextArea);  // 滚动条 添加在 SQL文本输入域上
        sqlJScrollPane.setPreferredSize(new Dimension(width, height / 2));

//        3. output
        outputJTextArea = new JTextArea();
        outputJTextArea.setBackground(Color.WHITE);
        outputJTextArea.setFont(font);
        outputJTextArea.setEditable(false);  // 结果输出域不可编辑

        outputJScrollPane = new JScrollPane(outputJTextArea);  // 滚动条添加在结果输出域上
        outputJScrollPane.setPreferredSize(new Dimension(width / 2, (int) (height / 2.5)));

//        4. result
        String[] columnsNames = {
                "ID",
                "USERNAME",
                "PASSWORD"
        };
        String[][] data = {
                {"1", "Tom", "123"},
                {"2", "Jerry", "abc"}
        };
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnsNames); //  输出表格的实例  ，data, columnsNames ： 二维数组 、一维数组

        resultJTable = new JTable(defaultTableModel); // 结果集，以表格的形式展示
        resultJTable.setBackground(Color.WHITE);
        resultJTable.setFont(font);
        resultJTable.getTableHeader().setFont(font);  //  设置表格的字体
        resultJTable.setRowHeight(30);              // 设置表格的行高

        resultJScrollPane = new JScrollPane(resultJTable);  // 滚动条添加在结果集上
        resultJScrollPane.setPreferredSize(new Dimension(width / 2, (int) (height / 2.5)));

        southJPanel = new JPanel();
        southJPanel.setLayout(new BorderLayout());
        southJPanel.setPreferredSize(new Dimension(width, (int) (height / 2.5)));

        southJPanel.add(outputJScrollPane, BorderLayout.WEST);   // 结果输出域的滚动条放在屏幕下半部分的左边
        southJPanel.add(resultJScrollPane, BorderLayout.EAST);   // 结果表格集的滚动条放在屏幕下半部分的右边
//        5. main
        main = new JPanel();  // 整体的屏幕布局
        main.setLayout(new BorderLayout());

        // 屏幕整体分为上下两个部分，
        main.add(sqlJScrollPane, BorderLayout.NORTH); //  sqlJScrollPane : 属于屏幕的上半部分
        main.add(southJPanel, BorderLayout.SOUTH);    // southJPanel ：属于屏幕的下半部分

//        6. show
        add(main);
        setVisible(true);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {  // 事件的实现
        // shortcut
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);  // 点击快捷键 Ctrl+Enter，触发事件
        sqlJTextArea.getInputMap().put(keyStroke, "Execute");
        sqlJTextArea.getActionMap().put("Execute", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = sqlJTextArea.getSelectedText();
                String output = server.dispatch(sql);
                if (output != null) {
                    outputJTextArea.append(output + "\n");
                }
                if (defaultTableModel != null) {
                    resultJTable.setModel(defaultTableModel);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Client();
    }
}

