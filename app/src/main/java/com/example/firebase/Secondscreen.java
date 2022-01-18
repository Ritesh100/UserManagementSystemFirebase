package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class Secondscreen extends AppCompatActivity {
   RecyclerView recyclerView;
   mainAdaptor mainAdaptor;
   FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);
        recyclerView = (RecyclerView)findViewById(R.id. recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<mainModel> options =
                new FirebaseRecyclerOptions.Builder<mainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), mainModel.class)
                        .build();
      //  Log.d("abc", "onCreate: Sucess ========== "+options);
        mainAdaptor = new mainAdaptor(options);
        recyclerView.setAdapter(mainAdaptor);
        floatingActionButton =findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddActivity.class));


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdaptor.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdaptor.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                txt_search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                txt_search(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
     private void txt_search(String str){
         FirebaseRecyclerOptions<mainModel> options =
                 new FirebaseRecyclerOptions.Builder<mainModel>()
                         .setQuery(FirebaseDatabase.getInstance().getReference().child("users").orderByChild("name").startAt(str).endAt(str+"~"), mainModel.class)
                         .build();
         mainAdaptor = new mainAdaptor(options);
         mainAdaptor.startListening();
         recyclerView.setAdapter(mainAdaptor);
     }

}