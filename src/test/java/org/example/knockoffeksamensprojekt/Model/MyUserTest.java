package org.example.knockoffeksamensprojekt.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyUserTest {

    @Test
    void getEmail() {
        MyUser user=new MyUser();
        user.setEmail("testuser@mail.com");
        assertEquals("testuser@mail.com",user.getEmail());

    }
}