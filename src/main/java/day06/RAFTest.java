package day06;

import java.io.*;

public class RAFTest {

    public static void raf (){
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("raf", "rw"))
        // r : 若文本存在则读取文本，不存在就会报错   //  rw : 读加写，不存在会自动创建文本
        {
            for (int i = 0; i < 10; i++) {
                randomAccessFile.writeDouble(i * 0.5);
            }
            randomAccessFile.seek(8);// 8 seek是按照字节读取，writerDouble 是8个字节
            System.out.println(randomAccessFile.readDouble()); // EOF: End Of File：已到达文件的结尾，指针会自动移到下一位
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try (
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("io"));
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("io"))
        ) {
            for (int i = 0; i < 10; i++) {
                dataOutputStream.writeDouble(i * 0.5);
            }
            dataInputStream.skipBytes(8); // skipBytes : 跳过字节数
            System.out.println(dataInputStream.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

