package org.example.knockoffeksamensprojekt.Service;

import org.example.knockoffeksamensprojekt.Model.Recipe;
import org.example.knockoffeksamensprojekt.Repository.DBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.knockoffeksamensprojekt.Model.User;

import java.util.List;

@Service
public class Usecase {

    @Autowired
    private DBController dbController;
    private User user;
    private Recipe recipe;

    public void createUpdateUser(User user){
        dbController.createUpdateUser(user);
    }

    public List<Recipe> findAllRecipes(){
        return dbController.findAllRecipes();
    }

    public Double calculateBMR(){
        //I teorien skal denne metode udregne en brugers BMR ud fra deres køn. 0 er mand, 1 er kvinde
        if(user.getGender()==0){
            Double menBMR=((10*user.getWeight())+(6.25*user.getHeight())-(5* user.getAge())+5);
            return menBMR;
        }
        else{
            Double womenBMR=((10*user.getWeight())+(6.25*user.getHeight())-(5* user.getAge())-161);
            return womenBMR;
        }
    }
    public Double calculateDailyCalories(){
        return calculateBMR()* user.getActivityLevel();
        //I teorien skal denne metode udregne en brugers daglige kalorieindtag ved at gange deres BMR med deres aktivitetsniveau
    }

}

