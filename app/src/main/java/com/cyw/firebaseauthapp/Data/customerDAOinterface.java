package com.cyw.firebaseauthapp.Data;

import java.util.ArrayList;

/**
 * Created by vivian on 2018/1/25.
 */

public interface customerDAOinterface {
    //增加一個物件
    public boolean add(customer s);
    //抓取物件陣列
    public ArrayList<customer> getList();
    //抓取一個物件
    public customer getCustomer(String id);
    //更新一個物件
    public boolean update(customer s);
    //刪除一個物件
    public boolean delete(String id);
}
