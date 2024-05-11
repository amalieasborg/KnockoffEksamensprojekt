package org.example.knockoffeksamensprojekt.Model;

public class Person {
    private String fname;
    private String ename;
    private String password;
    private String email;
    private String phoneNumber;

    public Person() {
    }

    public Person(String fname, String ename, String password, String email, String phoneNumber) {
        this.fname = fname;
        this.ename = ename;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
