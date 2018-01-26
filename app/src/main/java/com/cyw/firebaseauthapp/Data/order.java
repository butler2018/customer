package com.cyw.firebaseauthapp.Data;

import java.io.StringBufferInputStream;

/**
 * Created by vivian on 2018/1/26.
 */

public class order {
   String orderId;
   String customerId;
   String masterId;
   String programName;
   String transferTime;
   String transferMoney;
   String confirmTransferMoney;
   String balance;
   String customerfeedback;

   public void order(String orderId,String customerId,String masterId,String programName, String transferTime,String transferMoney,
           String confirmTransferMoney,String balance,String customerfeedback){
          this.orderId = orderId;
          this.customerId = customerId;
          this.masterId = masterId;
          this.programName = programName;
          this.transferTime = transferTime;
          this.transferMoney = transferMoney;
          this.confirmTransferMoney=confirmTransferMoney;
          this.customerfeedback=customerfeedback;
          this.balance = balance;


    }



}
