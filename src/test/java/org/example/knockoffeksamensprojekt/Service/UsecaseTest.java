package org.example.knockoffeksamensprojekt.Service;

import org.example.knockoffeksamensprojekt.Model.MyUser;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@Nested
class UsecaseTest {
    Usecase usecase=new Usecase();

    @Test
    public void testCalculateBMRForMale() {
            // Creating a male user with weight 70kg, height 170cm, and age 30
            MyUser maleUser = new MyUser(1l,"test","testesen","1234","test@mail.com","1234 5678",70,170,30,0,1,2,"Admin");

            // Calculating BMR for male user
            Double expectedBMR = 10 * 70 + 6.25 * 170 - 5 * 30 + 5;
            Double actualBMR = usecase.calculateBMR(maleUser);

            // Asserting that the calculated BMR matches the expected value
            assertEquals(expectedBMR, actualBMR);
        }

        @Test
        public void testCalculateBMRForFemale() {
            // Creating a female user with weight 60kg, height 160cm, and age 25
            MyUser femaleUser = new MyUser(1l,"testk","testesenk","1234","test@mail.com","1234 5678",60,160,25,1,1,2,"Admin");

            // Calculating BMR for female user
            Double expectedBMR = 10 * 60 + 6.25 * 160 - 5 * 25 - 161;
            Double actualBMR = usecase.calculateBMR(femaleUser);

            // Asserting that the calculated BMR matches the expected value
            assertEquals(expectedBMR, actualBMR);
        }
    }
