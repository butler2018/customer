package com.cyw.firebaseauthapp.Data;

/**
 * Created by vivian on 2018/1/25.
 */

public class order{

    public String customerId;
    public String balanceTimes;
    public String programName;
    public String price;
    public String customerfeedback;
    public String deadline;
    public String masterId;
    public String orderId;
    public String transferMoney;
    public String transferTime;



    public order(String customerId, String balanceTimes, String programName, String price
                 ,String customerfeedback,String deadline,String masterId,String orderId,
                 String transferMoney,String transferTime)
    {
        this.customerId=customerId;
        this.balanceTimes=balanceTimes;
        this.programName=programName;
        this.price=price;
        this.customerfeedback=customerfeedback;
        this.deadline=deadline;
        this.masterId=masterId;
        this.orderId=orderId;
        this.transferMoney=transferMoney;
        this.transferTime=transferTime;

    }



}

