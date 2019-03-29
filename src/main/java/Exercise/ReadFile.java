package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadFile {
    public static void main(String[] args) {
        HashMap<String, Integer> mapWord = new HashMap<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/file.txt"));
            String line;
            while (null != (line = in.readLine())) {
                String[] words = line.split("\\W");
                for (String str : words) {
                    if (str.trim().length() == 0) continue;
                    str = str.toLowerCase();
                    if (!mapWord.containsKey(str)) {
                        mapWord.put(str, 1);
                    } else if (mapWord.containsKey(str)) {
                        int n = mapWord.get(str);
                        mapWord.put(str, n + 1);
                    }
                }
            }
            for (String string : mapWord.keySet()) {
                int v = mapWord.get(string);
                System.out.println("word   " + string + "  have  " + v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}