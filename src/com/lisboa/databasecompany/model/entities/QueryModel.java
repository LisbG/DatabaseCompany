package com.lisboa.databasecompany.model.entities;

import com.lisboa.databasecompany.model.database.connection.Database;
import com.lisboa.databasecompany.model.database.exception.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class QueryModel {

    public static void updateModel(String tableName, StringBuilder values) {
        checkParameters(tableName, values);
    }

    private static void checkParameters(String tableName, StringBuilder values) {
        try (Connection connection = Database.setConnection()) {

            if (connection != null) {
                String query = String.format("select * from %s", tableName);
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                resultSet.next();

                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    System.out.println(resultSetMetaData.getColumnType(i));
                }


            }
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }
}
