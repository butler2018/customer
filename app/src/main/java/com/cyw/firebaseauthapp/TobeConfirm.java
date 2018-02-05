package com.cyw.firebaseauthapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
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
import android.widget.Toast;

import com.cyw.firebaseauthapp.order.flag;
import com.cyw.firebaseauthapp.order.order;

import java.util.ArrayList;

public class TobeConfirm extends AppCompatActivity {
    String customerID;
    String Mode = "TO_BE_CONFIRM";
    //int check;
    ListView lv;
    TextView tv;
    ArrayList<order> orderList;
    ArrayList<String> tcList;
    TobeConfirm.Myadapter adapter;
    flag check;
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tobe_confirm);
        lv = (ListView) findViewById(R.id.tobelistView);
        //取得ID
        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        customerID = sp.getString("id", "");
        orderList=MainActivity.odao.getList();
        tcList=new ArrayList<>();

    }

    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        tcList.clear();
        //    wMoneyList1.clear();
        // 讀陣列
        for (int i=0;i<orderList.size();i++)
        {
            if(orderList.get(i).customerId.toString().equals(customerID)
                    &&(orderList.get(i).flag.equals(Mode)))
            {
                //Log.d("order","抓的"+orderList.get(i).customerId.toString()+"原本:"+customerID);
                tcList.add(orderList.get(i).orderId);
                //      wMoneyList1.add(orderList.get(i).orderId);
                check = flag.FIND;
            }

        }
        if(check != flag.FIND) {
            tv = findViewById(R.id.tobetextView);
            tv.setText("未搜尋到訂單");
        }else
        {
            adapter=new TobeConfirm.Myadapter();
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it=new Intent(TobeConfirm.this,Open2Activity.class);
                    String OID=tcList.get(i).toString();
                    it.putExtra("OrderID",OID);
                    startActivity(it);
                }
            });

        }
    }
    class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return tcList.size();
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
            LayoutInflater inflater=LayoutInflater.from(TobeConfirm.this);
            View v=inflater.inflate(R.layout.myitem,null);
            TextView tv=v.findViewById(R.id.textView);
            //TextView tv1=v.findViewById(R.id.VIPname);
            String OID=tcList.get(position).toString();
            //String CID=MainActivity.dao_o.getOrder(OID).customerId;
            //String CName=MainActivity.dao_v.getVIP(CID).name;
            //Log.d("waiting Transfer","order:"+OID+" VIPid:"+CID+"  VIPname:"+CName);
            tv.setText("訂單號碼:"+OID);
            //tv1.setText("客戶姓名:"+CName);
            return v;
        }
    }


    }



