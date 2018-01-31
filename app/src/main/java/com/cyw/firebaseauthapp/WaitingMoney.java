package com.cyw.firebaseauthapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Data.flag;
import com.cyw.firebaseauthapp.order.order;

import java.util.ArrayList;

public class WaitingMoney extends AppCompatActivity {
    String ID;
   // String Mode = "WAIT_TRANSFER";
    ListView lv;
    TextView tv;
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_money);

          lv = (ListView) findViewById(R.id.waitlistView);
        //取得ID
        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        ID = sp.getString("id", "");
//       //final master masterinfo = MainActivity.dao_m.getMaster(masterID);
   }
    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        ArrayList<String> studentNames = new ArrayList<String>(); // 讀陣列
        for (order s : MainActivity.odao.getList()) {
            //if(ID.equals(s.customerId)&& (flag.WAIT_TRANSFER.equals(s.flag))) {
                if(ID.equals(s.customerId)&& (flag.WAIT_TRANSFER.equals(s.flag))) {
                studentNames.add(s.orderId);
                    check = 123;
                }
        }
        if(check != 123) {
            tv = findViewById(R.id.waittextView);
            tv.setText("未搜尋到訂單");
        }else
            {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(WaitingMoney.this
                    , android.R.layout.simple_list_item_1, studentNames);
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent it=new Intent(WaitingMoney.this,WaitingMoney_detail.class);
                       // String OID=wMoneyList.get(i).toString();
                      //  it.putExtra("OrderID",orderId);
                        it.putExtra("OrderId", MainActivity.odao.getList().get(position).orderId);
                        startActivity(it);
                    }
                });











//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(WaitingMoney.this
//                    , android.R.layout.simple_list_item_1, studentNames);
//            lv.setAdapter(adapter);
//            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                    Intent it = new Intent(WaitingMoney.this, Waiting2Money.class);
//                    it.putExtra("OrderId", MainActivity.odao.getList().get(position).orderId);
//
//                    startActivity(it);
//                }
//            });
        }
    }

}





