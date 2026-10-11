package com.airtribe.entity;

public class person {
    private int id;
    private String Firstname;
    private String Lastname;
    private String Email;

    public person() {}

    public person(int id, String Firstname, String Lastname, String Email) {
        this.id=id;
        this.Firstname=Firstname;
        this.Lastname=Lastname;
        this.Email=Email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getFirstname() {
        return Firstname;
    }
    public void setFirstname(String Firstname) {
        this.Firstname=Firstname;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String Lastname) {
        this.Lastname=Lastname;
    }
    public String getEmail() {
        return Email;

    }
    public void setEmail(String Email) {
        this.Email=Email;
    }
    public String getDisplayName() {
        return Firstname+" "+Lastname;
    }

}
