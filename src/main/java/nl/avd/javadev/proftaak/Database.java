package nl.avd.javadev.proftaak;

import java.sql.*;

public abstract class Database<Entity> {

    @FunctionalInterface
    interface UsesStatement<Result> {
        Result apply(PreparedStatement statement) throws SQLException;
    }

    <Result> Result useStatement(String sql, UsesStatement<Result> operator) {
        System.out.println("init");
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/avd-i-proftaak", "root", "");
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            //noinspection UnnecessaryLocalVariable
            Result result = operator.apply(statement);

            System.out.println("connected");
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    abstract Entity recordToEntity(ResultSet resultSet) throws SQLException;
}
