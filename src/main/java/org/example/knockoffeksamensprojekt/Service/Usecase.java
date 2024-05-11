package org.example.knockoffeksamensprojekt.Service;

import org.example.knockoffeksamensprojekt.Repository.DBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.knockoffeksamensprojekt.Model.User;

@Service
public class Usecase {

    @Autowired
    private DBController dbController;
    private User user;

    public void createUpdateUser(User user){
        dbController.createUpdateUser(user);
    }


}
