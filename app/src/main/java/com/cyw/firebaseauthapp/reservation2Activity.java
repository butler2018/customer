package com.cyw.firebaseauthapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cyw.firebaseauthapp.Data.customer;
import com.cyw.firebaseauthapp.Master.master;
import com.cyw.firebaseauthapp.order.order;

public class reservation2Activity extends AppCompatActivity {
    TextView tvOid,tvMid,tvPn,tvSt,tvBt;
    order o;
    master m;
    customer v;
    String OID,VIPId;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation2);

    tvOid = findViewById(R.id.retextViewOid);
    tvMid = findViewById(R.id.retextViewMid);
    tvPn = findViewById(R.id.retextViewPn) ;
    tvSt = findViewById(R.id.retextViewSt);
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

public void clickre(View v)
{
    showDialog_3();
}
    private void showDialog_3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(reservation2Activity.this);
        builder.setTitle("結帳確認密碼");
        builder.setMessage("按確認將扣除1次服務");
        final EditText et = new EditText(reservation2Activity.this);
        builder.setView(et);

        builder.setPositiveButton("確認送出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(reservation2Activity.this, "扣除成功", Toast.LENGTH_LONG).show();
                finish();
            }

        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //do nothing
            }
        });
        builder.show();



//        AlertDialog.Builder builder = new AlertDialog.Builder(reservation2Activity.this);
//        builder.setTitle("結帳確認密碼");
//        builder.setIcon(android.R.drawable.ic_dialog_info);
//        builder.setMessage("請輸入密碼");
//
//        final EditText et = new EditText(context);
//        builder.setView(et);
//        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                Toast.makeText(context, "扣除成功",
//                        Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.create().show();





    }






}




