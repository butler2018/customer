package com.cyw.firebaseauthapp.Data;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by vivian on 2018/1/25.
 */

public class orderCloudDAO implements orderDAOinterface {

        public Context context;
        public ArrayList<customer> mylist;
        FirebaseDatabase database;
        DatabaseReference myRef;

public orderCloudDAO(Context context) {
            this.context = context;
            mylist = new ArrayList<>();
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("OrderData");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Gson gson = new Gson();
                    if (mylist == null)
                    {
                        mylist = new ArrayList<>();
                    }
                    mylist = gson.fromJson(value, new TypeToken<ArrayList<customer>>(){}.getType());
                }
                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value

                }
            });
        }

    public void saveFile(){
        // Write a message to the database
        Gson gson = new Gson();
        String data = gson.toJson(mylist);
        Log.d("Here", "saveFile"+data);
        myRef.setValue(data);
    }


    @Override
    public boolean add(order s) {
        return false;
    }

    @Override
    public ArrayList<order> getList() {
        return null;
    }

    @Override
    public customer getCustomerId(String id) {
        return null;
    }

    @Override
    public boolean update(customer s) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}

