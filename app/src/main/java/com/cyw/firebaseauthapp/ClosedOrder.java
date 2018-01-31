package com.cyw.firebaseauthapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Data.flag;
import com.cyw.firebaseauthapp.order.order;

import java.util.ArrayList;

public class ClosedOrder extends AppCompatActivity {
    ListView lv;
    String ID;
    String Mode = "CLOSED_ORDER";
    TextView tv;
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_order);

        lv = (ListView) findViewById(R.id.closelistView);
        //取得ID
        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        ID = sp.getString("id", "");
    }

    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        ArrayList<String> studentNames = new ArrayList<String>(); // 讀陣列
        for (order s : MainActivity.odao.getList()) {
          //  if(ID.equals(s.customerId)&& (flag.CLOSED_ORDER.equals(s.flag))) {
                if(ID.equals(s.customerId)&& (Mode.equals(s.flag))) {
                studentNames.add(s.orderId);
                    check = 1;
                }
        }
        if(check != 1) {
            tv = findViewById(R.id.closedtextView);
            tv.setText("未搜尋到訂單");
        }else {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ClosedOrder.this
                    , android.R.layout.simple_list_item_1, studentNames);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent it = new Intent(ClosedOrder.this, Open2Activity.class);
                    it.putExtra("OrderId", MainActivity.odao.getList().get(position).orderId);
                    startActivity(it);
                }
            });
        }
    }

}



