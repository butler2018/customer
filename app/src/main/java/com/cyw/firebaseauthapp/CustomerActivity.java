package com.cyw.firebaseauthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener{

    Button customerData,orderData,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        customerData=(Button)findViewById(R.id.customerData);
        orderData=(Button)findViewById(R.id.orderData);
        btn3=(Button)findViewById(R.id.btn3);
     //   btn4=(Button)findViewById(R.id.store);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        customerData.setOnClickListener(this);
        orderData.setOnClickListener(this);
        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.customerData:
                Intent it1=new Intent(CustomerActivity.this,CustomerBasicData.class);
                startActivity(it1);
                break;
            case R.id.orderData:
                Intent it2=new Intent(CustomerActivity.this,OrderActivity.class);
                startActivity(it2);
                break;
            case R.id.btn3:
                break;
//            case R.id.store:
//                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
        }
    }
}
