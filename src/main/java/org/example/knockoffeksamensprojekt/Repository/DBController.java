package org.example.knockoffeksamensprojekt.Repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.example.knockoffeksamensprojekt.Model.User;

@Repository
public class DBController {
    private JdbcTemplate jdbcTemplate;
    String sql;

    public DBController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public User createUpdateUser (User user){
        try {
            if(user.getUserId()==null){
                sql="INSERT INTO user(userid,fname,sname,password,email,phoneNumber,weight,height,age,gender,activityLevel,goal,role) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql,user.getUserId(),user.getFname(),user.getSname(),user.getPassword(),user.getEmail(),user.getPhoneNumber(),user.getWeight(),user.getHeight(),user.getAge(),user.getGender(),user.getActivityLevel(),user.getGoal(),user.getRole());
            }else{
                sql = "UPDATE user SET fname=?,sname=?,password=?,email=?,phoneNumber=?,weight=?,height=?,age=?,gender=?,activityLevel=?,goal=?,role=? WHERE userId="+String.valueOf(user.getUserId());
                jdbcTemplate.update(sql,user.getUserId(),user.getFname(),user.getSname(),user.getPassword(),user.getEmail(),user.getPhoneNumber(),user.getWeight(),user.getHeight(),user.getAge(),user.getGender(),user.getActivityLevel(),user.getGoal(),user.getRole());
            }return user;
        } catch(DataAccessException e){
            throw new RuntimeException("Error creating user", e);
        }
    }


}
