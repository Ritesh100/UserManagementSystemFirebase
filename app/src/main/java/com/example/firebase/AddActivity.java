package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
 EditText name,address,contact,email,image;
 Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name= findViewById(R.id.txtName);
         address= findViewById(R.id.txtAddress);
         contact = findViewById(R.id.txtContact);
         email = findViewById(R.id.txtEmail);
         image= findViewById(R.id.txtImage);
          btnAdd = (Button) findViewById(R.id.btnAdd);
          btnBack= (Button) findViewById(R.id.btnBack);

          btnAdd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  insertData();
                  clearAll();

              }
          });
          btnBack.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  finish();
              }
          });
    }
    private void insertData(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("address", address.getText().toString());
        map.put("contact", contact.getText().toString());
        map.put("email", email.getText().toString());
        map.put("image", image.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("users").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Error While insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll(){
        name.setText("");
        address.setText("");
        contact.setText("");
        email.setText("");
        image.setText("");
    }
}