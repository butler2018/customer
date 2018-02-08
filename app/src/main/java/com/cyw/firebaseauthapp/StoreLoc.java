package com.cyw.firebaseauthapp;

import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cyw.firebaseauthapp.Store.Store;
import com.google.android.gms.location.LocationListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class StoreLoc extends AppCompatActivity{
    ListView lv1;
    ArrayList<Store> stores;
    Myadapter adapter;
    String nowLocation,add;
    LocationManager lm;
    TextView tv;
    MyListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_loc);
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        tv = (TextView) findViewById(R.id.textViewNow);
        listener = new MyListener();  //於頁面顯示現在地址

        lv1 = (ListView) findViewById(R.id.store_listView);
        adapter = new Myadapter();
        stores = new ArrayList<>();
        stores.add(new Store("林口店", "新北市林口區文化二路一段563-3號1樓", "02 2602 5511", R.drawable.store001));
        stores.add(new Store("中和店", "新北市中和區景新街340號", "02 2602 5511", R.drawable.store002));
        lv1.setAdapter(adapter);

        Nowlocation();

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent it = new Intent(StoreLoc.this, StoreMap.class);
                  String[] fromto = {nowLocation, stores.get(i).address};
//                it.putExtra("fromto", fromto);
//                startActivity(it);


                String vDirectionUrl = "https://maps.google.com/maps?f=d"
                        + "&saddr=" + fromto[0]
                        + "&daddr=" + fromto[1]
                        + "&hl=tw";

                // 在 Google 地圖 App 顯示導航
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(vDirectionUrl) );
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);

            }
        });
    }


    class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return stores.size();
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
            LayoutInflater inflater = LayoutInflater.from(StoreLoc.this);
            View v = inflater.inflate(R.layout.myitem_store, null);
            TextView tv = v.findViewById(R.id.store_name);
            TextView tv1 = v.findViewById(R.id.store_addr);
            TextView tv2 = v.findViewById(R.id.store_tel);
            ImageView iv = v.findViewById(R.id.store_pic);
            tv.setText(stores.get(position).storeName);
            tv1.setText(stores.get(position).address);
            tv2.setText(stores.get(position).tel);
            iv.setImageResource(stores.get(position).pic);
            return v;
        }
    }

    public void Nowlocation() {
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[] {ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 321
            );
            return;
        } else {
            startLoc();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 321)
        {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //取得權限，進行檔案存取
                startLoc();
            } else {

            }
        }
    }

    private void startLoc() {
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
    }
    class MyListener implements android.location.LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            Log.d("LOC", "Change!! " + location.getLatitude() + "," + location.getLongitude());
            Location loc101 = new Location("LOC");
            loc101.setLatitude(25.0336);
            loc101.setLongitude(121.5646);
            nowLocation = (location.getLatitude() + "," + location.getLongitude());
            float dist = location.distanceTo(loc101);
            Log.d("LOC", "Dist:" + dist);

            Geocoder geocoder = new Geocoder(StoreLoc.this, Locale.TRADITIONAL_CHINESE);//設定語言
            lm.removeUpdates(listener);
            //Geocoder gc = new Geocoder(getActivity(), Locale.TRADITIONAL_CHINESE);
            try {
                List<Address> mylist = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                Address addr = mylist.get(0);
                add = addr.getAddressLine(0);
                Log.d("LOC", addr.getAddressLine(0));
                tv.setText(String.valueOf(add)); // 地址放入
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }


}

