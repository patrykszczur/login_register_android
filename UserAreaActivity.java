package com.example.patryk.loginregister_v13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername) ;
        final EditText etAge = (EditText) findViewById(R.id.etAge) ;
        final TextView tvMessage = (TextView) findViewById(R.id.tvMessage) ;


        Intent intent = getIntent() ;
        String name = intent.getStringExtra("name") ;

        String mg = name + "hallo this is first version alkotron app" ;
        tvMessage.setText(mg);
    }
}
