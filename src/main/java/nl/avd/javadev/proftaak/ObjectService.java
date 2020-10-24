package nl.avd.javadev.proftaak;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectService {

    private final String filename;

    public ObjectService() {
        this.filename = "shapes.dump.obj";
    }

    public void writeShapes(ArrayList<Shape> shapes) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.filename))) {
            objectOutputStream.writeObject(shapes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Shape> readShapes() {
        List<Shape> shapes = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.filename))) {
            shapes = (List<Shape>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return shapes;
    }

}
