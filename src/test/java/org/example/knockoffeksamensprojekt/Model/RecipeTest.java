package org.example.knockoffeksamensprojekt.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {



    @Test
    void calculateCalories() {
        Recipe recipe=new Recipe();
        ArrayList<Ingredient> ingredientListForDish=new ArrayList<>();
        Ingredient i1=new Ingredient(1L,"Carrot",41,3,2,10,100);
        ingredientListForDish.add(i1);

        assertEquals(15,recipe.calculateCalories(ingredientListForDish));
    }
}