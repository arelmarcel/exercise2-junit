package com.mitrais;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void sendPoint() {
        Transaction transaction = new Transaction();
        HistoryData history = new HistoryData();
        Users arel = new Users();
        arel.setId(1);
        arel.setName("Arel");
        arel.setPoint(2000);

        Users bernard = new Users();
        bernard.setId(2);
        bernard.setName("Bernard");
        bernard.setPoint(2000);

        List<Users> usersList = new ArrayList<>();
        usersList.add(arel);
        usersList.add(bernard);



        transaction.SendPoint(usersList.get(0), usersList.get(1), 100, 12, 1,2020);

        List<HistoryData> historyLists =  transaction.getHistory();


        assertAll(
                () -> assertEquals(1900,  arel.getPoint() ),
                () -> assertNotEquals(2000, bernard.getPoint()),

                () -> assertEquals("Transaction success", historyLists.get(0).status),
                () -> assertNotEquals("Transaction fail (doesn't have enough point)", historyLists.get(0).status),

                () -> assertNotNull(historyLists)

        );

        transaction.SendPoint(usersList.get(0), usersList.get(1), 10000, 12, 1,2020);

        List<HistoryData> historyLists2 =  transaction.getHistory();
        assertAll(
                () -> assertEquals(1900,  arel.getPoint() ),
                () -> assertNotEquals(2000, bernard.getPoint()),

                () -> assertEquals("Transaction fail (doesn't have enough point)", historyLists2.get(1).status),
                () -> assertNotEquals("Transaction success", historyLists2.get(1).status),

                () -> assertNotNull(historyLists2)

        );

    }
}