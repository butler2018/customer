package com.cyw.firebaseauthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cyw.firebaseauthapp.order.order;

public class Tobe2Confirm extends AppCompatActivity {
    order s;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tobe2_confirm);

        id = getIntent().getStringExtra("OrderId");
        s = MainActivity.odao.getOrder(id);
    }
}
