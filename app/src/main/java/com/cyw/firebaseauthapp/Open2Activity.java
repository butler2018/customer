package com.cyw.firebaseauthapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Data.customer;
import com.cyw.firebaseauthapp.Master.master;
import com.cyw.firebaseauthapp.order.order;

public class Open2Activity extends AppCompatActivity {
    TextView tvOid,tvMid,tvPn,tvSt,tvBt;
    order o;
    master m;
    customer v;
    String OID,VIPId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open2);
        tvOid = findViewById(R.id.textViewOid);
        tvMid = findViewById(R.id.textViewMid);
        tvPn = findViewById(R.id.textViewPn);
        tvSt = findViewById(R.id.textViewSt);
        tvBt = findViewById(R.id.textViewBt);

        OID=getIntent().getStringExtra("OrderID");  // o訂單no

        o=MainActivity.odao.getOrder(OID);  //取得Order

        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        VIPId = sp.getString("id", "");  //取得m

        m=MainActivity.mdao.getMaster(o.masterId);
        v=MainActivity.dao.getCustomer(o.customerId);

      //  Log.d("id::",OID);
        tvOid.setText(o.orderId);
        tvMid.setText(m.name);
        tvPn.setText(String.valueOf(o.programID));
        tvSt.setText(String.valueOf(o.serviceTimes));
        tvBt.setText(String.valueOf(o.balanceTimes));

    }
}
