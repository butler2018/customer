package com.cyw.firebaseauthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cyw.firebaseauthapp.order.order;

public class Open2Activity extends AppCompatActivity {
    TextView tvOid,tvMid,tvPn,tvSt,tvBt;
    order s;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open2);
        tvOid = findViewById(R.id.textViewOid);
        tvMid = findViewById(R.id.textViewMid);
        tvPn = findViewById(R.id.textViewPn);
        tvSt = findViewById(R.id.textViewSt);
        tvBt = findViewById(R.id.textViewBt);

        id = getIntent().getStringExtra("OrderId");
        s = MainActivity.odao.getOrder(id);
        tvOid.setText(s.orderId);
        tvMid.setText(s.masterId);
        tvPn.setText(String.valueOf(s.programID));
        tvSt.setText(String.valueOf(s.serviceTimes));
        tvBt.setText(String.valueOf(s.balanceTimes));

    }
}
