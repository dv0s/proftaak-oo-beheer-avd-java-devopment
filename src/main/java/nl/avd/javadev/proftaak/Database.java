package nl.avd.javadev.proftaak;

import java.sql.*;

public class Database {

    @FunctionalInterface
    interface UsesStatement<Result> {
        Result apply(PreparedStatement statement) throws SQLException;
    }

    <Result> Result useStatement(String sql, UsesStatement<Result> operator) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/avd-i-proftaak", "root", "");
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            return operator.apply(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
