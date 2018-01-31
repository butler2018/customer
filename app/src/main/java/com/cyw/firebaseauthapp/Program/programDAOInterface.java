package com.cyw.firebaseauthapp.Program;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/31.
 */

public interface programDAOInterface {
    //增加一個物件
    public boolean add(program s);
    //抓取物件陣列
    public ArrayList<program> getList();
    //抓取一個物件
    public program getProgram(String masterid,String programid);
    //更新一個物件
    public boolean update(program s);
    //刪除一個物件
    public boolean delete(String masterid,String programid);
}
