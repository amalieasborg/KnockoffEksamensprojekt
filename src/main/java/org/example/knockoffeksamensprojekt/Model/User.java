package org.example.knockoffeksamensprojekt.Model;

public class User extends Person{
    private Long userId;
    private String height;
    private String weight;
    private String age;
    private boolean gender;

    public User() {
    }

    public User(String fname, String ename, String password, String email, String phoneNumber, Long userId, String height, String weight, String age, boolean gender) {
        super(fname, ename, password, email, phoneNumber);
        this.userId = userId;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
