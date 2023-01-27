package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        while (null != (line = br.readLine())) {
            System.out.println(line);
        }

        br.close();
        fr.close();

    }
    
}
