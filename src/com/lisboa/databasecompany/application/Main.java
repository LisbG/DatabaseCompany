package com.lisboa.databasecompany.application;

import com.lisboa.databasecompany.model.database.connection.Database;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = Database.setConnection();
    }
}
