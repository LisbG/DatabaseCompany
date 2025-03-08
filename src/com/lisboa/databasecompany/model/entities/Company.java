package com.lisboa.databasecompany.model.entities;

public class Company extends CrudMethods {
    private final String tableName = "company";
    private StringBuilder fields = new StringBuilder();

    public Company() {
        this.fields.append("CompanyName, ");
        this.fields.append("CompanyEmail");
    }

    @Override
    public void insertRegister(StringBuilder values) {
        String[] valuesSplit = values.toString().split(";");

        String insertQuery = String.format("Insert into %s (%s) values ('%s', '%s')",
                tableName,
                String.valueOf(fields),
                valuesSplit[0],
                valuesSplit[1]
        );

        super.executeQuery(insertQuery);
    }

    @Override
    public void updateRegister(StringBuilder values) {
        super.executeQuery("");
    }

    @Override
    public void deleteRegister(StringBuilder values) {
        super.executeQuery("");
    }

    @Override
    public void readRegisters() {

        String query = String.format("select * from %s", tableName);
        super.executeSelect(query, tableName);
    }
}

