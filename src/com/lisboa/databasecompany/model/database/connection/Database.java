package com.lisboa.databasecompany.model.database.connection;

import com.lisboa.databasecompany.model.database.exception.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static Connection connection = null;

    public static Connection setConnection(){

        try {
            Properties properties = getProperties();

            if (properties != null) {
                connection = DriverManager.getConnection(properties.getProperty("url"), properties);
                return connection;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties getProperties(){

        try(FileInputStream configFile = new FileInputStream("src/com/lisboa/databasecompany/model/database/properties/db.properties")){

            Properties properties = new Properties();
            properties.load(configFile);

            return properties;

        } catch (IOException e){
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }
}
