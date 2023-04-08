package com.example.listview_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class activity_btnMore extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_more);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String birth = intent.getStringExtra("birth");
        String classid = intent.getStringExtra("classid");
        String imageURL = intent.getStringExtra("imageURL");
        Parcelable[] parcelables = intent.getParcelableArrayExtra("subjects");
        Subject[] subjects = new Subject[parcelables.length];
        for (int i = 0; i < parcelables.length; i++) {
            subjects[i] = (Subject) parcelables[i];
        }

        TextView card_name = (TextView) findViewById(R.id.card_name);
        TextView card_birth = (TextView) findViewById(R.id.card_birth);
        TextView card_classid = (TextView) findViewById(R.id.card_class);
        ImageView image = (ImageView) findViewById(R.id.card_image);

        card_name.setText(name);
        card_birth.setText(birth);
        card_classid.setText(classid);

        Glide.with(this)
                .load(Uri.parse(imageURL))
                .into(image);

        ListView listView_subject = (ListView) findViewById(R.id.listview_subject);
        listView_subject.setAdapter(new SubjectAdapter(this, R.layout.listview_subject_item, subjects));


        ImageButton btnReturn = (ImageButton) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}