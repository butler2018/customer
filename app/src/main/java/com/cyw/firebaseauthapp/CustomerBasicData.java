package com.cyw.firebaseauthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CustomerBasicData extends AppCompatActivity {

    ListView lv;
    String[] str= {"基本資料維護","修改密碼"};
    //boolean fastback=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_basic_data);
        lv=(ListView)findViewById(R.id.listView);
        Myadaptor adapter=new Myadaptor();
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        Intent it=new Intent(CustomerBasicData.this,BasicDataMaintain.class);
                        startActivity(it);
                        break;
                    case 1:
                        //fastback=true;
                        Intent it1=new Intent(CustomerBasicData.this,BasicDataMaintainPWD.class);
                        startActivity(it1);
                        break;
                }


            }
        });
    }

    class Myadaptor extends BaseAdapter     {

        @Override
        public int getCount() {
            return str.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=LayoutInflater.from(CustomerBasicData.this);
            View v=inflater.inflate(R.layout.myitem,null);
            TextView tv=v.findViewById(R.id.textView);
            //Toast.makeText(MasterBasicData.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            tv.setText(str[position]);
            return v;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //if(fastback){finish();}//使用者按了clickedit時fastback就變true
    }


}
