package com.example.listview_test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;

    private final int resourceLayout;


    public StudentAdapter(Context context, int resource, Student[] students)
    {
        super(context, resource, students);
        this.context = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null)
        {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            view = vi.inflate(resourceLayout,null);
        }

        Student student = getItem(position);
        ImageView image = view.findViewById(R.id.card_image);
        TextView name = (TextView) view.findViewById(R.id.card_name);
        TextView birth = (TextView) view.findViewById(R.id.card_birth);
        TextView classid = (TextView) view.findViewById(R.id.card_class);
        Button btnMore = (Button) view.findViewById(R.id.btnMore);


        Glide.with(context)
                .load(Uri.parse(student.getImageURL()))
                .into(image);
        name.setText(student.getName());
        birth.setText(student.getBirth());
        classid.setText(student.getclassid());

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the button click event
                Intent intent = new Intent(getContext(), activity_btnMore.class);
                intent.putExtra("name", name.getText());
                intent.putExtra("birth", birth.getText());
                intent.putExtra("classid", classid.getText());
                intent.putExtra("imageURL", student.getImageURL());
                intent.putExtra("subjects", student.getSubjects());


                getContext().startActivity(intent);
            }
        });

        return view;
    }
}
