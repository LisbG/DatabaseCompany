package com.lisboa.databasecompany.model.interfaces;

public interface CRUD {

    public void insertRegister(StringBuilder values);
    public void updateRegister(StringBuilder values);
    public void deleteRegister(StringBuilder values);
    public void readRegisters();
}
