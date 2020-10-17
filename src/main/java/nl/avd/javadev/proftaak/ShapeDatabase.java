package nl.avd.javadev.proftaak;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShapeDatabase extends Database<Shape> {

    public void save(Shape shape) {
        useStatement("INSERT INTO shapes (type, properties, volume) VALUES (?, ?, ?)", statement -> {
            statement.setString(1, shape.getType());
            statement.setString(2, shape.getPropertySting());
            statement.setDouble(3, ((Calculable) shape).getVolume());

            return statement.execute();
        });
    }

//    public void delete(Shape shape) {}

//    public List<Shape> getAll() {}
}
