package com.example.clareheinbaugh.ramhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



import com.example.clareheinbaugh.ramhacks.R;


public class ToolBar extends Fragment {
    Button mUsers;
    Button mEmergency;
    Button mReports;
    Button mHome;
    Button mHistory;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view =  inflater.inflate(R.layout.fragment_tool_bar, parent, false);

        return view;

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        mUsers = (Button) view.findViewById(R.id.users);
        mUsers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Users.class);
                startActivityForResult(myIntent, 0);
            }
        });

        mEmergency = (Button) view.findViewById(R.id.emergency);
        mEmergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Emergency.class);
                startActivityForResult(myIntent, 0);
            }
        });

        mReports = (Button) view.findViewById(R.id.reports);
        mReports.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Reports.class);
                startActivityForResult(myIntent, 0);
            }
        });

        mHome = (Button) view.findViewById(R.id.home);
        mHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        mHistory = (Button) view.findViewById(R.id.history);
        mHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), history.class);
                startActivityForResult(myIntent, 0);
            }
        });





    }
}
