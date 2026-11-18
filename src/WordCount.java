import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) throws Exception {

        
        BufferedReader br = new BufferedReader(new FileReader("input/input.txt"));

        List<String> mappedData = new ArrayList<>();
        String line;

        
        while ((line = br.readLine()) != null) {
            String words[] = line.toLowerCase().split(" ");

            for (String word : words) {
                mappedData.add(word + ":1");
            }
        }

        br.close();

        
        HashMap<String, Integer> result = new HashMap<>();

        for (String pair : mappedData) {
            String parts[] = pair.split(":");
            String word = parts[0];

            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        
        TreeMap<String, Integer> sorted = new TreeMap<>(result);

      
        FileWriter fw = new FileWriter("output/part-r-00000");

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            String output = entry.getKey() + " " + entry.getValue();
            System.out.println(output);
            fw.write(output + "\n");
        }

        fw.close();

        System.out.println("\n✅ Output saved to output/part-r-00000");
    }
}
//compile the project:
//javac src/WordCount.java
//java -cp src WordCount