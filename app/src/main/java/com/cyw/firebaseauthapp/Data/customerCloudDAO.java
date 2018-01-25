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

public class customerCloudDAO implements customerDAOinterface {

        public Context context;
        public ArrayList<customer> mylist;
        FirebaseDatabase database;
        DatabaseReference myRef;

public customerCloudDAO(Context context) {
            this.context = context;
            mylist = new ArrayList<>();
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("masterData");

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
    public boolean add(customer s) {
        if (mylist == null)
        {
            mylist = new ArrayList<>();
        }

        mylist.add(s);
//        Log.d("Hereadd", "saveFile"+String.valueOf(s.id));

        saveFile();
        return true;
    }




    @Override
    public ArrayList<customer> getList() {
        return mylist;
    }

    @Override
    public customer getCustomer(String id) {
        for (customer s : mylist)
        {
            if (s.id.equals(id))
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean update(customer s) {
        for (customer t : mylist)
        {
            if (t.id.equals(s.id))
            {
                t.name = s.name;
                t.password = s.password;
                t.store=s.store;
             //   t.bankcode=s.bankcode;
             //   t.accountNumber=s.accountNumber;
                saveFile();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (customer s : mylist)
        {
            if (s.id.equals(id))
            {
                mylist.remove(s);
                saveFile();
                return true;
            }
        }
        return false;
    }
}

