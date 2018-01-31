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

public class OpenOrder extends AppCompatActivity {
    ListView lv;
    String ID;
    String Mode = "OPEN_ORDER";
    int check;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_order);
        lv = (ListView) findViewById(R.id.openlistView);
        //取得ID
        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        ID = sp.getString("id", "");
    }

    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        ArrayList<String> studentNames = new ArrayList<String>(); // 讀陣列
        for (order s : MainActivity.odao.getList()) {
           // if(ID.equals(s.customerId)&& (s.flag.equals(flag.OPEN_ORDER))) {
            if(ID.equals(s.customerId)&& (flag.OPEN_ORDER.equals(s.flag))) {
                studentNames.add(s.orderId);
                check = 123;
            }
        }
        if(check != 123) {
            tv = findViewById(R.id.opentextView);
            tv.setText("未搜尋到訂單");
        }else
            {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(OpenOrder.this
                    , android.R.layout.simple_list_item_1, studentNames);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent it = new Intent(OpenOrder.this, Open2Activity.class);

                    it.putExtra("OrderId", MainActivity.odao.getList().get(position).orderId);


                    startActivity(it);
                }
            });
        }
        }

}




