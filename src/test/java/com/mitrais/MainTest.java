package com.mitrais;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private List<Users> listOfUser = new ArrayList<Users>();
    private Users newUser;

    @Test
    void createUsers() {
        AddData();

        List<Users> createUserData = Main.createUsers();

        assertEquals(listOfUser.size(), Main.createUsers().size());

        // if the size is different, test failed
        if (listOfUser.size() != Main.createUsers().size()) {
            return;
        }

        assertAll(
                () -> assertEquals(listOfUser.get(0).getId(), createUserData.get(0).getId()),
                () -> assertEquals(listOfUser.get(0).getName(),  createUserData.get(0).getName()),
                () -> assertEquals(listOfUser.get(0).getPoint(),  createUserData.get(0).getPoint())
        );
        assertAll(
                () -> assertEquals(listOfUser.get(1).getId(),  createUserData.get(1).getId()),
                () -> assertEquals(listOfUser.get(1).getName(),  createUserData.get(1).getName()),
                () -> assertEquals(listOfUser.get(1).getPoint(),  createUserData.get(1).getPoint())
        );
        assertAll(
                () -> assertEquals(listOfUser.get(2).getId(),  createUserData.get(2).getId()),
                () -> assertEquals(listOfUser.get(2).getName(), createUserData.get(2).getName()),
                () -> assertEquals(listOfUser.get(2).getPoint(), createUserData.get(2).getPoint())
        );
    }

    void AddData() {
        // add data
        newUser = new Users();
        newUser.setId(1);
        newUser.setName("Arel");
        newUser.setPoint(2000);
        listOfUser.add(newUser);

        newUser = new Users();
        newUser.setId(2);
        newUser.setName("Bernard");
        newUser.setPoint(2000);
        listOfUser.add(newUser);

        newUser = new Users();
        newUser.setId(3);
        newUser.setName("dia");
        newUser.setPoint(1000);
        listOfUser.add(newUser);
    }
}