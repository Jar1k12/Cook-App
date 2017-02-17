package com.lvivdroiddev.cookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lvivdroiddev.cookapp.models.FirstCourseModel;
import com.lvivdroiddev.cookapp.models.FirstModelRecept;

public class FirstCourseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    FirstModelRecept modelRecept;


    TextView receptOfCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_course);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent i = getIntent();
        String nameOfCourse = i.getStringExtra("tool");
        String key = i.getStringExtra("key");
        toolbar.setTitle(nameOfCourse);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstCourseActivity.this.finish();
            }
        });


        receptOfCourse = (TextView) findViewById(R.id.riceptOfCourse);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("FirstCourse/" + key);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (modelRecept.getReceptOfCourse() != null) {
                    receptOfCourse.setText(modelRecept.getReceptOfCourse());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
