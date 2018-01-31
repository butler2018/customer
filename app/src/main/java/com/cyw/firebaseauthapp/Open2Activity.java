package com.cyw.firebaseauthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cyw.firebaseauthapp.order.order;

public class Open2Activity extends AppCompatActivity {
    TextView tvOid,tvMid,tvPn,tvSt,tvBt;
    order o;
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
        o = MainActivity.odao.getOrder(id);
        Log.d("id:",id);
        tvOid.setText(o.orderId);
        tvMid.setText(o.masterId);
        tvPn.setText(String.valueOf(o.programID));
        tvSt.setText(String.valueOf(o.serviceTimes));
        tvBt.setText(String.valueOf(o.balanceTimes));

    }
}
