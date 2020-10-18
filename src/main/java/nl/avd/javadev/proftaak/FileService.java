package nl.avd.javadev.proftaak;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileService {
    public void writeToFile(ArrayList<Shape> shapes) {
        if (shapes.size() > 0 ) {
            try {
                PrintStream fileStream = new PrintStream(new File("shapes.dump.txt"));
                for (Shape shape : shapes) {
                    fileStream.println(shape.toString());
                }
                fileStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDataFromFile() {

    }
}
