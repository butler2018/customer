package com.cyw.firebaseauthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Data.customer;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OpenOrder extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_order);
        lv = (ListView) findViewById(R.id.openlistView);
    }
    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        ArrayList<String> customerId = new ArrayList<>(); // 讀陣列
        for (customer s : MainActivity.dao.getList()) {
            customerId.add(s.id);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(OpenOrder.this
                , android.R.layout.simple_list_item_1, customerId);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent(OpenOrder.this, Open2Activity.class);
                it.putExtra("id", MainActivity.dao.getList().get(position).id);
                startActivity(it);
            }
        });


    }
}
