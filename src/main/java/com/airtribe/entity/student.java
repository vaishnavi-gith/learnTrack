package com.airtribe.entity;

public class student extends person {
    private String batch;
    private boolean active;

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getBatch() {
        return batch;
    }
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public student(int id, String Firstname,String Lastname,String batch) {
        super(id,Firstname,Lastname,"");
        this.batch = batch;
        this.active = true;
    }
    public student(int id, String Firstname,String Lastname,String Email,String batch) {
        super(id,Firstname,Lastname,Email);
        this.batch = batch;
        this.active = true;
    }
    @Override
    public String getDisplayName() {
        return "Student" + super.getDisplayName() + " " + batch;
    }
}

