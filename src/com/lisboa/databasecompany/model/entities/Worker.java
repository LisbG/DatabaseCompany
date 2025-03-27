package com.lisboa.databasecompany.model.entities;

public class Worker extends CrudMethods {
    private final String tableName = "worker";
    private StringBuilder fields = new StringBuilder();

    public Worker() {
        fields.append("WorkerName, ");
        fields.append("WorkerBaseSalary, ");
        fields.append("CompanyId");
    }

    @Override
    public void insertRegister(StringBuilder values) {

        String[] valuesSplit = values.toString().split(";");

        String insertQuery = String.format("Insert into %s (%s) values ('%s', %s, %s)",
                tableName,
                String.valueOf(fields),
                valuesSplit[0],
                valuesSplit[1],
                valuesSplit[2]
        );
        super.executeQuery(insertQuery);
//        System.out.println(insertQuery);
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
        super.executeQuery("");
    }
}
