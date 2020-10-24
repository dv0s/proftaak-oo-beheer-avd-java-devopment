package nl.avd.javadev.proftaak;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShapeDatabase extends Database {

    public Integer save(Shape shape) {
        return useStatement("INSERT INTO shapes (type, properties, volume) VALUES (?, ?, ?)", statement -> {
            statement.setString(1, shape.getType().toString());
            statement.setString(2, shape.getPropertySting());
            statement.setDouble(3, ((Calculable) shape).getVolume());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();

            return rs.next() ? rs.getInt(1) : null;
        });
    }

    public Integer delete(Shape shape) {
        return useStatement("DELETE FROM shapes WHERE id = ?", statement -> {
            statement.setInt(1, shape.getId());

            return statement.executeUpdate();
        });
    }

    public HashMap<String, Object> getShapeData(Integer id) {
        return useStatement("SELECT properties, volume FROM shapes WHERE id = ?", statement -> {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            HashMap<String, Object> shapeData = new HashMap<>();

            while (resultSet.next()) {
                shapeData.put("properties", resultSet.getString(1));
                shapeData.put("volume", resultSet.getDouble(2));
            }

            return shapeData;
        });
    }

    public List<HashMap<String, Object>> getAll() {
        return useStatement("SELECT id, type FROM shapes", statement -> {
            ResultSet resultSet = statement.executeQuery();
            List<HashMap<String, Object>> shapesResultData = new ArrayList<>();

            while (resultSet.next()) {
                HashMap<String, Object> shapeData = new HashMap<>();
                shapeData.put("id", resultSet.getInt(1));
                shapeData.put("type", resultSet.getString(2));
                shapesResultData.add(shapeData);
            }

            return shapesResultData;
        });
    }

}