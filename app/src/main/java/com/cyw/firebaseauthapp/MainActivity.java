package com.cyw.firebaseauthapp;

import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cyw.firebaseauthapp.Data.DBtype;
import com.cyw.firebaseauthapp.Data.customerCloudDAO;
import com.cyw.firebaseauthapp.Master.masterCloudDAO;
import com.cyw.firebaseauthapp.Program.rogramCloudDAO;
import com.cyw.firebaseauthapp.order.orderCloudDAO;

//登入至師父主畫面(MasterActivity),及註冊按鈕至(RegisterActity)
public class MainActivity extends AppCompatActivity {

    DBtype dbType;
    Button login_btn,register_btn;
    EditText id,password;
    public static customerCloudDAO dao;
    public static orderCloudDAO odao;
    public static rogramCloudDAO pdao;
    public static masterCloudDAO mdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dbType = DBtype.CLOUD; // 1:檔案 2:Firebase CLOUD
        //dao = masterDAOFactory.getDAOInstance(this, dbType);

        dao = new customerCloudDAO(MainActivity.this);
        odao = new orderCloudDAO(MainActivity.this);
        pdao = new rogramCloudDAO(MainActivity.this);
        mdao = new masterCloudDAO(MainActivity.this);

        login_btn = (Button) findViewById(R.id.login_btn);
        register_btn = (Button) findViewById(R.id.register_btn);
        id = (EditText) findViewById(R.id.pwdid);
        password = (EditText) findViewById(R.id.password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = id.getText().toString();
                String PWD = password.getText().toString();
                if(dao.getList()==null){//firebase裡面都沒資料時的寫法
                    Toast.makeText(MainActivity.this, "請進行註冊", Toast.LENGTH_SHORT).show();
                }else if(id.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "請輸入手機號碼,不能空白喔~", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "請輸入密碼,不能空白喔~", Toast.LENGTH_SHORT).show();

                }else if (dao.getCustomer(ID)==null){
                    Toast.makeText(MainActivity.this, "無此電話號碼,請修改或重新註冊!!", Toast.LENGTH_SHORT).show();
                }else if (dao.getCustomer(ID).password.equals(PWD)){
                    SharedPreferences sp = getSharedPreferences("basicdata", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("id",id.getText().toString());
                    editor.commit();

                    Intent it = new Intent(MainActivity.this, CustomerActivity.class);
                    startActivity(it);
                }else{
                    Toast.makeText(MainActivity.this, "密碼錯誤,登入失敗!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(it);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    //此副程式讓app在一開啟的時候能把資料先讀出來



}












