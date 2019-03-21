package day05;

import java.io.*;

/**
 *  基于字节的输入流
 *  Reader -> FileReader -> method
 */

public class InputStreamTest {

    private static final  String NAME ="src/main/java/day05/InputStreamTest.java";

    public static void main(String[] args) {
        try {

        //    InputStream inputStream = new FileInputStream("build.gradle");
          //  System.out.println((char) inputStream.read());// 读取文件的第一个字母

            InputStream inputStream =new FileInputStream(NAME);
            int i=inputStream.read();

            FileReader inputStream1 =new FileReader(NAME);
            int j=inputStream1.read();

            while (i!=-1) {
                //System.out.print((char) i);
                //i=inputStream.read();  // 读取全部文件，但无法读取汉字，汉字占据两个字节

                System.out.println((char) j);
                j=inputStream1.read();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
