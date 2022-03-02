package com.mitrais;

import java.util.ArrayList;
import java.util.List;

public class Transaction
{
    private List<HistoryData> transactionHistoryList;

    // constructor
    public Transaction()
    {
        transactionHistoryList = new ArrayList<HistoryData>(){};
    }

    // send point write to history
    public void SendPoint(Users userSender, Users userReceiver, int point, int day, int month, int year)
    {
        HistoryData history = new HistoryData();

        if (userSender.getPoint() > point)
        {
            userSender.reducePoint(point);
            userReceiver.addPoint(point);
            history.status = "Transaction success";
        }
        else {
            history.status = "Transaction fail (doesn't have enough point)";
        }


        history.date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
        history.userSender = userSender.getName();
        history.userReceiver = userReceiver.getName();
        history.point = point;

        // add history
        transactionHistoryList.add(history);
    }

    // print the history
    public void PrintHistory()
    {
        System.out.println("\n----- Show History-----");
        for (HistoryData data : transactionHistoryList)
        {
            System.out.println("\nDate: " + data.date);
            System.out.println(data.userSender + " -> " + data.userReceiver + " : " + data.point + "P");
            System.out.println("Status: " + data.status);
        }
    }
}