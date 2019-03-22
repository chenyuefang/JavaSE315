package day06;

import java.io.*;

public class InputOutput {

    public static void main(String[] args) {
        try (
                InputStream inputOutput = new FileInputStream("chapter 7 IO.pdf");
                OutputStream outputStream = new FileOutputStream("new.pdf") // 在try 中自动启用Closeable关闭
        ) {
            int i = inputOutput.read(); // 复制一个文本到本地，与内容无关 reader与writer是关于内容的
            while (i != -1) {
                outputStream.write(i);
                i = inputOutput.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
