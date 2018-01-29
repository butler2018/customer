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
        public ArrayList<order> mylist1;
        FirebaseDatabase database;
        DatabaseReference myRef;

public orderCloudDAO(final Context context) {
            this.context = context;
            mylist1 = new ArrayList<>();
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("orderData");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Gson gson = new Gson();
                    if (mylist1 == null)
                    {
                        mylist1 = new ArrayList<>();
                    }
                    mylist1 = gson.fromJson(value, new TypeToken<ArrayList<order>>(){}.getType());
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
        String data = gson.toJson(mylist1);
        Log.d("Here", "saveFile"+data);
        myRef.setValue(data);
    }
    @Override
    public boolean add(order s) {
        if (mylist1 == null)
        {
            mylist1 = new ArrayList<>();
        }

        mylist1.add(s);
//        Log.d("Hereadd", "saveFile"+String.valueOf(s.id));

        saveFile();
        return true;
    }




    @Override
    public ArrayList<order> getList() {
        return mylist1;
    }

    @Override
    public order getCustomer(String id) {
        for (order s : mylist1)
        {
            if (s.customerId.equals(id))
            {
                return s;
            }
        }
        return null;
    }


    @Override
    public boolean update(order s)
    {
            for (order t : mylist1)
            {
                if (t.customerId.equals(s.customerId)) {
                    t.balanceTimes = s.balanceTimes;
                    //          t.password = s.password;
                    //       t.store=s.store;
                    saveFile();
                    return true;
                }
            }
            return false;
        }

//        @Override
//        public boolean delete(String id)
//
//    {
//        for (order s : mylist1)
//        {
//            if (s.customerId.equals(id))
//            {
//                mylist1.remove(s);
//                saveFile();
//                return true;
//            }
//        }
//        return false;
//    }


    }
