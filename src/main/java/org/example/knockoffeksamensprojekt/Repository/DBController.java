package org.example.knockoffeksamensprojekt.Repository;

import org.example.knockoffeksamensprojekt.Model.Dish;
import org.example.knockoffeksamensprojekt.Model.Ingredient;
import org.example.knockoffeksamensprojekt.Model.Recipe;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.example.knockoffeksamensprojekt.Model.User;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

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
    public void deleteUserById(Long userId){
        sql="DELETE FROM user where userId =?";
        jdbcTemplate.update(sql,userId);
    }

    public Optional<User> findUserById(Long userId){
        try {
            sql = "SELECT * FROM user WHERE userId=?";
            User user = jdbcTemplate.queryForObject(sql, new Object[]{userId},userRowmapper());
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); // Return empty Optional if no user is found
        } catch(DataAccessException e){
            throw new RuntimeException("Error accessing data while finding user", e);
        }
    }

    private RowMapper<User> userRowmapper(){
        return (rs, rowNum) ->{
            User user = new User();
            user.setUserId(rs.getLong("userId"));
            user.setFname(rs.getString("fname"));
            user.setSname(rs.getString("sname"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setWeight(rs.getDouble("weight"));
            user.setHeight(rs.getInt("height"));
            user.setAge(rs.getInt("age"));
            user.setGender(rs.getInt("gender"));
            user.setActivityLevel(rs.getInt("activityLevel"));
            user.setGoal(rs.getInt("goal"));
            user.setRole(rs.getInt("role"));
            return user;
        };
    }


    public Ingredient createUpdateIngredient(Ingredient ingredient){
        try{
            if (ingredient.getIngredientId()==null){
                sql="INSERT INTO ingredient(name,calories,protein,fat,carbs) VALUES (?,?,?,?,?)";
                jdbcTemplate.update(sql,ingredient.getName(),ingredient.getCalories(),ingredient.getProtein(),ingredient.getFat(),ingredient.getCarbs());
            }else{
                sql="update ingredient set name=?,calories=?,protein=?,fat=?,carbs=? where ingredientId="+String.valueOf(ingredient.getIngredientId());
                jdbcTemplate.update(sql,ingredient.getName(),ingredient.getCalories(),ingredient.getProtein(),ingredient.getFat(),ingredient.getCarbs());
            }
            return ingredient;
        }catch(DataAccessException e){
            throw new RuntimeException("Error creating ingredient", e);
        }
    }
    public void deleteIngredientById(Long ingredientId){
        sql="DELETE FROM ingredient where ingredientId =?";
        jdbcTemplate.update(sql,ingredientId);
    }

    public List<Dish> findAllDishes(){
        try {
            sql="SELECT * FROM dish";
            return jdbcTemplate.query(sql,dishRowmapper());
        }catch(DataAccessException e){
            throw new RuntimeException("Error finding all dishes", e);
        }
    }

    public RowMapper<Dish> dishRowmapper(){
        return (rs, rowNum) ->{
            Dish dish = new Dish();
            dish.setName(rs.getString("name"));
            dish.setType(rs.getString("type"));
            return dish;
        };
    }

    public List<Recipe> findAllRecipes(){
        try {
            sql="SELECT * FROM recipe";
            return jdbcTemplate.query(sql,recipeRowmapper());
        }catch(DataAccessException e){
            throw new RuntimeException("Error while finding all recipes",e);
        }
    }

    public RowMapper<Recipe> recipeRowmapper(){
        return(rs, rowNum) ->{
            Recipe recipe = new Recipe();
            recipe.setCalories(rs.getInt("calories"));
            recipe.setProtein(rs.getInt("protein"));
            recipe.setFat(rs.getInt("fat"));
            recipe.setCarbs(rs.getInt("carbs"));
            recipe.setDescription(rs.getString("description"));
            return recipe;
        };
    }

}
