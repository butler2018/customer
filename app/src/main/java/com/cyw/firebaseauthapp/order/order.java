package com.cyw.firebaseauthapp.order;

/**
 * Created by vivian on 2018/1/25.
 */

public class order {

    public String orderId;
    public String customerId;
    public String masterId;
    public String programID;
    public String deadline;
    public String transferTime;
    public int price;
    public int transferMoney;
    public int balanceTimes;
    public int serviceTimes;
    public String customerfeedback;
    public String flag;


    public order(String orderId, String customerId, String masterId, String programID, String deadline, String transferTime, int price, int transferMoney, int balanceTimes, int serviceTimes, String customerfeedback, String flag) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.masterId = masterId;
        this.programID = programID;
        this.deadline = deadline;
        this.transferTime = transferTime;
        this.price = price;
        this.transferMoney = transferMoney;
        this.balanceTimes = balanceTimes;
        this.serviceTimes = serviceTimes;
        this.customerfeedback = customerfeedback;
        this.flag = flag;


    }
}