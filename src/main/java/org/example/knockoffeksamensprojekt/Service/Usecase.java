package org.example.knockoffeksamensprojekt.Service;

import org.example.knockoffeksamensprojekt.Model.Recipe;
import org.example.knockoffeksamensprojekt.Repository.DBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.knockoffeksamensprojekt.Model.MyUser;

import java.util.List;

@Service
public class Usecase {

    @Autowired
    private DBController dbController;
    private MyUser myUser;
    private Recipe recipe;

    public void createUpdateUser(MyUser myUser){
        dbController.createUpdateUser(myUser);
    }

    public List<Recipe> findAllRecipes(){
        return dbController.findAllRecipes();
    }

    public Double calculateBMR(){
        //I teorien skal denne metode udregne en brugers BMR ud fra deres køn. 0 er mand, 1 er kvinde
        if(myUser.getGender()==0){
            Double menBMR=((10* myUser.getWeight())+(6.25* myUser.getHeight())-(5* myUser.getAge())+5);
            return menBMR;
        }
        else{
            Double womenBMR=((10* myUser.getWeight())+(6.25* myUser.getHeight())-(5* myUser.getAge())-161);
            return womenBMR;
        }
    }
    public Double calculateDailyCalories(){
        return calculateBMR()* myUser.getActivityLevel();
        //I teorien skal denne metode udregne en brugers daglige kalorieindtag ved at gange deres BMR med deres aktivitetsniveau
    }

}

