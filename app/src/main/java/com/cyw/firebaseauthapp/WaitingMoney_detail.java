package com.cyw.firebaseauthapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cyw.firebaseauthapp.Data.customer;
import com.cyw.firebaseauthapp.order.flag;
import com.cyw.firebaseauthapp.Master.master;
import com.cyw.firebaseauthapp.order.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WaitingMoney_detail extends AppCompatActivity {
    TextView orderId_wmd,masterName_wmd,store_wmd,program_wmd,price_wmd,times_wmd,bankCode_wmd,bankAccount_wmd,deadline_wmd,VIPId_wmd,VIPName_wmd;
    EditText editText;
    Button payCash_wmd;
    String OID,VIPId;
    order o;
    master m;
    customer v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_money_detail);
        orderId_wmd=(TextView)findViewById(R.id.orderId_wmd);
        masterName_wmd=(TextView)findViewById(R.id.masterName__wmd);
        store_wmd=(TextView)findViewById(R.id.store__wmd);
        program_wmd=(TextView)findViewById(R.id.program__wmd);;
        price_wmd=(TextView)findViewById(R.id.price__wmd);
        times_wmd=(TextView)findViewById(R.id.times__wmd);
        bankCode_wmd=(TextView)findViewById(R.id.bankCode__wmd);
        bankAccount_wmd=(TextView)findViewById(R.id.bankAccount__wmd);
        deadline_wmd=(TextView)findViewById(R.id.deadline__wmd);
        VIPId_wmd=(TextView)findViewById(R.id.VIPId__wmd);
        VIPName_wmd=(TextView)findViewById(R.id.VIPName_wmd);
        payCash_wmd=(Button)findViewById(R.id.payCash_wmd);
     //   deleteOrder_wmd=(Button)findViewById(R.id.deleteOrder_wmd);
        editText=(EditText)findViewById(R.id.payCasheditText);


        OID=getIntent().getStringExtra("OrderID");  // o訂單no

        o=MainActivity.odao.getOrder(OID);  //取得Order

        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        VIPId = sp.getString("id", "");  //取得master

        m=MainActivity.mdao.getMaster(o.masterId);
        v=MainActivity.dao.getCustomer(o.customerId);

        orderId_wmd.setText(OID);
        masterName_wmd.setText(m.name.toString());
        store_wmd.setText(m.store.toString());
        program_wmd.setText(o.programID.toString());
        price_wmd.setText(Integer.valueOf(o.price).toString());
        times_wmd.setText(Integer.valueOf(o.balanceTimes).toString());
        bankCode_wmd.setText(m.bankcode.toString());
        bankAccount_wmd.setText(m.accountNumber.toString());
        deadline_wmd.setText(o.deadline.toString());
        VIPId_wmd.setText(VIPId);
        VIPName_wmd.setText(v.name.toString());

        payCash_wmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o.flag= "TO_BE_CONFIRM";
                o.balanceTimes=Integer.valueOf(times_wmd.getText().toString());
                o.customerfeedback=editText.getText().toString();
                //轉帳時間(就是現在)
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
                Calendar c = Calendar.getInstance();
                String currentTime = df.format(c.getTime());
                o.transferTime=currentTime;
                o.transferMoney=Integer.valueOf(price_wmd.getText().toString());
                o.serviceTimes=0;

                MainActivity.odao.update(o);

                Toast.makeText(WaitingMoney_detail.this, "回覆成功,待確認", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

//        deleteOrder_wmd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.dao.delete(OID);
//                finish();
//            }
//        });

    }
}
