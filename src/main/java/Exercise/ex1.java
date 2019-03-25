package Exercise;

import java.io.File;
import java.io.IOException;

/**
 * 编写一个程序，在D盘根目录下创建一个以自己名称命名的文件夹，
 * 并在该文件夹下创建一个以自己名称命名的文本文件
 */

public class ex1 {

    public static void main(String[] args) {
        File file=new File("CYF");// 只有一个文件名
        try {
           file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getPath());
        System.out.println(file.getName());
    }
}
