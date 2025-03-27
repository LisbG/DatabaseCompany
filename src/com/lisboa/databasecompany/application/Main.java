package com.lisboa.databasecompany.application;

import com.lisboa.databasecompany.model.entities.QueryModel;

public class Main {
    public static void main(String[] args) {

        StringBuilder values = new StringBuilder();

        values.append("company;");
        values.append("companyName");
        values.append("eu te amo");
        values.append("companyId");
        values.append("2");


        QueryModel.updateModel("company", values);

    }
}
