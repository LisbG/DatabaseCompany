package com.lisboa.databasecompany.model.entities;

import com.lisboa.databasecompany.model.database.connection.Database;
import com.lisboa.databasecompany.model.database.exception.DbException;
import com.lisboa.databasecompany.model.interfaces.CRUD;

import java.sql.*;

public abstract class CrudMethods implements CRUD {

    private final Connection connection = Database.setConnection();
    private PreparedStatement preparedStatement;

    public void executeQuery(String query) {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Success!");
                } else {
                    System.out.println("No changes");
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void executeSelect(String query, String tableName) {

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                StringBuilder selectReturn = new StringBuilder();
                while (resultSet.next()) {
                    for (int x = 1; x <= resultSetMetaData.getColumnCount(); x++) {
                        selectReturn.append(resultSet.getString(x)).append(" | ");
                    }
                    System.out.println(selectReturn);
                    selectReturn.setLength(0);
                }
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
