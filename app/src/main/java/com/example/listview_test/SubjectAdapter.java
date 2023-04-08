package com.example.listview_test;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SubjectAdapter extends ArrayAdapter<Subject> {
    Context context;
    int resourceLayout;

    public SubjectAdapter(Context context, int resourceLayout, Subject[] subjects)
    {
        super(context, resourceLayout, subjects);
        this.context = context;
        this.resourceLayout = resourceLayout;
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

        Subject subject = getItem(position);

        TextView subjectId = view.findViewById(R.id.subject_id);
        TextView subjectName = view.findViewById(R.id.subject_name);

        subjectId.setText(subject.getId());
        subjectName.setText(subject.getName());

        return view;
    }

}
