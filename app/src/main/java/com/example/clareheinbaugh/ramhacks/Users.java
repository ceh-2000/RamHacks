package com.example.clareheinbaugh.ramhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Users extends AppCompatActivity {

    TextView mUserList;
    ArrayList<Safe_Users> ListOfUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        mUserList = findViewById(R.id.list_of_users);
        ListOfUsers = new ArrayList<Safe_Users>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");
        //myRef.setValue("Hello, World!");


        //Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                for (Map.Entry<String,Object> entry : map.entrySet()){
                    String number = entry.getKey();
                    Log.i("nummmmmm", number);
                    String name = "";
                    String safe = "";
                    Map<String, Object> user_data_map = (Map<String, Object>)entry.getValue();
                    for (Map.Entry<String,Object> entry2 : user_data_map.entrySet()){
                        if(entry2.getKey().equals("name")){
                            name = (String)entry2.getValue();
                        }
                        else if(entry2.getKey().equals("safe")){
                            safe = (String)entry2.getValue();
                        }

                    }
                    Safe_Users current_User = new Safe_Users(name, number, safe);


                    ListOfUsers.add(current_User);

                }

                String text_of_users = "";
                for(int i = 0; i<ListOfUsers.size(); i++){
                    text_of_users += ListOfUsers.get(i)+"\n";

                }

                mUserList.setText(text_of_users);

                Log.i("SUPERCALLLL", "List of users"+text_of_users);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i("SUPERCALLLL", "Failed to read value.", error.toException());
            }
        });

    }
}
