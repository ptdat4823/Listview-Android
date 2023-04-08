package com.example.listview_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView = null;

    public Subject[] subjects1 = new Subject[]{
            new Subject("SE114.N21","nhap mon ung dung di dong"),
            new Subject("SE104.N21", "nhap mon cnpm")
    };
    public Subject[] subjects2 = new Subject[]{
            new Subject("SE111.N21","mo hinh hoa"),
            new Subject("SE105.N21", "he dieu hanh")
    };
    public Student[] student = new Student[]{
            new Student("Dat","4/8/2003", "KTPM", subjects1,"https://images.unsplash.com/photo-1559629819-638a8f0a4303?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8Ym95fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60"),
            new Student("Linh","11/2/2007", "HTTT", subjects2, "https://plus.unsplash.com/premium_photo-1673792686302-7555a74de717?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTl8fGdpcmx8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new StudentAdapter(this, R.layout.listview_item, student));
    }
}

