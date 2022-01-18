package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText username, password;
 Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }
    void login(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin")&&
                password.getText().toString().equals("admin")){
                  //  Toast.makeText(getApplicationContext(), "Welcome Admin.....", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, userList.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(getApplicationContext(), "Please Enter Correct Information", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}