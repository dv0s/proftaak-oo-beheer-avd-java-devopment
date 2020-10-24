package nl.avd.javadev.proftaak;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {

    private final String filename;

    public FileService() {
        this.filename = "shapes.dump.txt";
    }

    public void writeToFile(List<Shape> shapes) {
        if (shapes.size() > 0 ) {
            try {
                PrintStream fileStream = new PrintStream(new File(this.filename));
                for (Shape shape : shapes) {
                    fileStream.println(shape.toString());
                }
                fileStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Map<String, Object> > getDataFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(this.filename))) {
            List<Map<String, Object> > shapes = new ArrayList<>();
            for(String line; (line = reader.readLine()) != null; ) {
                shapes.add(this.stringToShape(line));
            }
            return shapes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, Object> stringToShape(String shapeString) {
        String propertiesString = shapeString.split(" - ")[1];
        String[] propertyPairs = propertiesString.split(", ");
        Map<String, String> properties = new HashMap<>();
        for (String property : propertyPairs) {
            String[] keyValue = property.split(": ");
            properties.put(keyValue[0], keyValue[1]);
        }
        return new HashMap<>() {{
            put("type", shapeString.split(" - ")[0]);
            put("properties", properties);
        }};
    }
}
