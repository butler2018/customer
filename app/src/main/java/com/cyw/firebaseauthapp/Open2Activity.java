package com.cyw.firebaseauthapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Data.customer;
import com.cyw.firebaseauthapp.Master.master;
import com.cyw.firebaseauthapp.order.order;

public class Open2Activity extends AppCompatActivity {
    TextView tvOid,tvMid,tvPn,tvSt,tvBt;
    order o;
    master m;
    customer v;
    String OID,VIPId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open2);
        tvOid = findViewById(R.id.retextViewOid);
        tvMid = findViewById(R.id.retextViewMid);
        tvPn = findViewById(R.id.textViewPn);
        tvSt = findViewById(R.id.textViewSt);
        tvBt = findViewById(R.id.retextViewBt);

        OID=getIntent().getStringExtra("OrderID");  // o訂單no

        o=MainActivity.odao.getOrder(OID);  //取得Order

        SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
        VIPId = sp.getString("id", "");  //取得m

        m=MainActivity.mdao.getMaster(o.masterId);
        v=MainActivity.dao.getCustomer(o.customerId);

      //  Log.d("id::",OID);
        tvOid.setText(o.orderId);
        tvMid.setText(m.name);
        tvPn.setText(String.valueOf(o.programID));
        tvSt.setText(String.valueOf(o.serviceTimes));
        tvBt.setText(String.valueOf(o.balanceTimes));

    }
//    public void clickDD(View v)
//    {
//        MainActivity.odao.delete(OID);
//        finish();
//    }
//
//    public void clickcf(View v)
//    {
//        o.flag= "OPEN_ORDER";
//        MainActivity.odao.update(o);
//        finish();
//    }




//    public void shareLine() {
//        ComponentName cn = new ComponentName("jp.naver.line.android"
//                , "jp.naver.line.android.activity.selectchat.SelectChatActivity");
//        Intent shareIntent = new Intent();
//        shareIntent.setAction(Intent.ACTION_SEND);
//        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(mActivity.getContentResolver(), bitmap, null, null));
//        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
//        shareIntent.setType("image/jpeg"); //圖
//        //intent.setType("text/plain"); // 文
//        //intent.putExtra(Intent.EXTRA_SUBJECT, "分享的標题");
//        //intent.putExtra(Intent.EXTRA_TEXT, "分享的内容");
//        shareIntent.setComponent(cn);//跳到指定APP的Activity
//        mActivity.startActivity(Intent.createChooser(shareIntent, ""));
//    }




}
