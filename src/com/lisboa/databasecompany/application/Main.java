package com.lisboa.databasecompany.application;

import com.lisboa.databasecompany.model.entities.Company;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Valor 1, ");
        stringBuilder.append("Valor 1, ");
        stringBuilder.append("Valor 1");

        Company company = new Company();

        StringBuilder values = new StringBuilder();
        values.append("Planta;");
        values.append("planta@gmail.com;");

//        System.out.println("String: " + String.valueOf(values) + "teste");

        company.readRegisters();


    }
}
