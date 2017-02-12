package com.lvivdroiddev.cookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lvivdroiddev.cookapp.models.FirstCourseModel;

import java.util.ArrayList;
import java.util.List;

public class FirstCourseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private List<FirstCourseModel> courseList;

    TextView riceptOfCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_course);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent i = getIntent();
        String nameOfCourse = i.getStringExtra("tool");
        int position = i.getIntExtra("pos", 1);
       // upload(position);
        toolbar.setTitle(nameOfCourse);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstCourseActivity.this.finish();
            }
        });


        database = FirebaseDatabase.getInstance();

        reference = database.getReference("FirstCourse");

        courseList = new ArrayList<>();

        riceptOfCourse = (TextView) findViewById(R.id.riceptOfCourse);

        // FirstCourseModel courseModel = courseList.get(position);

      //  riceptOfCourse.setText(courseModel.riceptOfCourseStr + "");

   //     generateData();


    }

  /*  public void upload(int position) {

        FirstCourseModel courseModel = courseList.get(position);

        riceptOfCourse.setText(courseModel.riceptOfCourseStr + "");
    }
    */

    private void generateData() {
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                courseList.add(dataSnapshot.getValue(FirstCourseModel.class));

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                FirstCourseModel courseModel = dataSnapshot.getValue(FirstCourseModel.class);

                int index = getItemIndex(courseModel);

                courseList.set(index, courseModel);


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private int getItemIndex(FirstCourseModel courseModel) {

        int index = -1;
        for (int i = 0; i < courseList.size(); i++) {

            if (courseList.get(i).key.equals(courseModel.key)) {

                index = 1;
                break;

            }

        }

        return index;
    }



}
