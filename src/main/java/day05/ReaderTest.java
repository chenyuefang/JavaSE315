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