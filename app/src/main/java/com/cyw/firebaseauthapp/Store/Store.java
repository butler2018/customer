package com.cyw.firebaseauthapp.Store;

/**
 * Created by Student on 2018/2/6.
 */

public class Store {
    public String storeName;
    public String address;
    public String tel;
    public int pic;

    public Store(String storeName,String address, String tel,int pic) {
        this.storeName=storeName;
        this.address=address;
        this.tel=tel;
        this.pic=pic;
    }
}