package org.example.knockoffeksamensprojekt.Model;

public class User {
    private Long userId;
    private String fname, sname, password, email, phoneNumber;
    private double weight;
    private int height, age, gender, activityLevel, goal, role;

    public User() {
    }

    public User(Long userId, String fname, String ename, String password, String email, String phoneNumber, double weight, int height, int age, int gender, int activityLevel, int goal, int role) {
        this.userId = userId;
        this.fname = fname;
        this.sname = ename;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.goal = goal;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fname='" + fname + '\'' +
                ", ename='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", gender=" + gender +
                ", activityLevel=" + activityLevel +
                ", goal=" + goal +
                ", role=" + role +
                '}';
    }
}
