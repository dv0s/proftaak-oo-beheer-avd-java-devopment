package nl.avd.javadev.proftaak;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<HashMap> getAll() {
        return useStatement("SELECT id, type FROM shapes", statement -> {
            ResultSet resultSet = statement.executeQuery();
            List<HashMap> shapesResultData = new ArrayList<>();

            while (resultSet.next()) {
                HashMap<String, Object> shapeData = new HashMap<>();
                shapeData.put("id", resultSet.getInt(ShapeTableColumns.ID.getIndex()));
                shapeData.put("type", resultSet.getString(ShapeTableColumns.TYPE.getIndex()));
                shapesResultData.add(shapeData);
            }

            return shapesResultData;
        });
    }

}