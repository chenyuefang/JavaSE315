package day05;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 基于字符的输入流
 */

public class ReaderTest {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("src/main/java/day05/ReaderTest.java");) {
            /**
             * try()内的内容是需要关闭的资源
             * 若有多条资源，除最后一句外，其他语句都需要加“；”
             */

            int i = reader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// 中文