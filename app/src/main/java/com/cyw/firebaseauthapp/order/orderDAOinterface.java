package com.cyw.firebaseauthapp.order;

import java.util.ArrayList;

/**
 * Created by vivian on 2018/1/25.
 */

public interface orderDAOinterface {
    //增加一個物件
    public boolean add(order s);
    //抓取物件陣列
    public ArrayList<order> getList();
    //抓取一個物件
    public order getOrder(String id);

    public boolean update(order s);
    //刪除一個物件
 //   public boolean delete(String customerId);
}
