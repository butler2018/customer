package com.cyw.firebaseauthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Data.order;

public class Open2Activity extends AppCompatActivity {
    TextView tvOid,tvMid,tvPn,tvT,tvPr,tvAn,tvAb,tvDl;
   // order s;
    int it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open2);
        tvOid = findViewById(R.id.textViewOid);
        tvMid = findViewById(R.id.textViewMid);
        tvPn = findViewById(R.id.textView);
        tvT = findViewById(R.id.textViewT);
        tvPr = findViewById(R.id.textViewPr);
        tvAn = findViewById(R.id.textViewAn);
        tvAb = findViewById(R.id.textViewAb);
        tvDl = findViewById(R.id.textViewDl);

        String om = "Open";
        it = getIntent().getIntExtra("id",0);
        String id = Integer.valueOf(it).toString();

  //      s = MainActivity.odao.getOrder(id,om);
  //      tvOid.setText(s.orderId);
//        tvMid.setText(s.MasterId);
//        tvPn.setText(s.programName);
//        tvT.setText(s.times);
//        tvPr.setText(s.price);
//        tvAn.setText(s.accountNumber);
//        tvAb.setText(s.accountBank);
//        tvDl.setText(s.deadLine);





    }
}
