package com.cyw.firebaseauthapp.Data;

import java.util.ArrayList;

/**
 * Created by vivian on 2018/1/25.
 *///orderId,customerId,masterId,programName

public interface orderDAOinterface {
    //增加一個物件
    public boolean add(order s);
    //抓取物件陣列
    public ArrayList<order> getList();
    //抓取一個物件
    public customer getCustomerId(String id);
    //更新一個物件
    public boolean update(customer s);
    //刪除一個物件
    public boolean delete(String id);
}
