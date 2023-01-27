package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TermFrequency {

    public static void main(String[] args) throws IOException {

        if (args.length > 1) {
            System.out.println("Please provide only one file");
            System.exit(1);
        } else if (args.length < 1) {
            System.out.println("Please provide a file");
            System.exit(1);
        }
        
        Path cithPath = Paths.get(args[0]);
        File cith = cithPath.toFile();

        if (!cith.exists()) {
            System.out.println("File not found");
            System.exit(1);
        }

        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] words = null;

        List<String> list = new ArrayList<>();
        HashMap<String, Float> map = new HashMap<>();

        while (null != (line = br.readLine())) {

            words = line.trim().replaceAll("\\p{P}", "").toLowerCase().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals("")) {
                    list.add(words[i]);
                }
            }
        }
        float totalNumberOfWords = list.size();

        for (int i = 0; i < list.size(); i++) {
            Float counter = 0.0f;
            String word = list.get(i);
            for (int j = 1; j < list.size(); j++) {
                if (word.equals(list.get(j))) {
                    counter++;
                }
            }
            map.put(word, counter); 
        }

        Map<String, Float> topTen = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(10)
        .map(entry -> Map.entry(entry.getKey(), entry.getValue()/totalNumberOfWords))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("Word - Term Frequency Value");
        System.out.println("---------------------------");

        for (String word: topTen.keySet()) {
            String key = word.toString();
            String value = topTen.get(word).toString();
            System.out.println(key + " - " + value);
        }

        br.close();
        fr.close();
    }
}