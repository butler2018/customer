package com.cyw.firebaseauthapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.cyw.firebaseauthapp.order.flag;
import com.cyw.firebaseauthapp.order.order;

import java.util.ArrayList;

public class OpenOrder extends AppCompatActivity {
    ListView lv;
    String customerID;
    String Mode = "OPEN_ORDER";
    //int check;
    TextView tv;
    String OID;
    ArrayList<order> orderList;
    ArrayList<String> opList;
    OpenOrder.Myadapter adapter;
    flag check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_order);
        lv = (ListView) findViewById(R.id.openlistView);
        //取得ID
        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        customerID = sp.getString("id", "");
        orderList=MainActivity.odao.getList();
        opList=new ArrayList<>();

    }

    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        opList.clear();
        //    wMoneyList1.clear();
        // 讀陣列
        for (int i=0;i<orderList.size();i++)
        {
            if(orderList.get(i).customerId.toString().equals(customerID)
                    &&(orderList.get(i).flag.equals(Mode)))
            {
                //Log.d("order","抓的"+orderList.get(i).customerId.toString()+"原本:"+customerID);
                opList.add(orderList.get(i).orderId);
                //      wMoneyList1.add(orderList.get(i).orderId);
            }
            check = flag.FIND;
        }
        if(check != flag.FIND) {
            tv = findViewById(R.id.opentextView);
            tv.setText("未搜尋到訂單");
        }else
        {
            adapter=new OpenOrder.Myadapter();
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it=new Intent(OpenOrder.this,Open2Activity.class);
                    String OID=opList.get(i).toString();
                    it.putExtra("OrderID",OID);
                    startActivity(it);
                }
            });

        }
    }
    class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return opList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater=LayoutInflater.from(OpenOrder.this);
            View v=inflater.inflate(R.layout.myitem,null);
            TextView tv=v.findViewById(R.id.textView);
            //TextView tv1=v.findViewById(R.id.VIPname);
            String OID=opList.get(position).toString();
            //String CID=MainActivity.dao_o.getOrder(OID).customerId;
            //String CName=MainActivity.dao_v.getVIP(CID).name;
            //Log.d("waiting Transfer","order:"+OID+" VIPid:"+CID+"  VIPname:"+CName);
            tv.setText("訂單號碼:"+OID);
            //tv1.setText("客戶姓名:"+CName);
            return v;
        }
    }
}