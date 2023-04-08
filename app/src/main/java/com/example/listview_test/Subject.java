package com.example.listview_test;

import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable {
    String Id;
    String Name;

    public Subject(String id, String name)
    {
        this.Id = id;
        this.Name = name;
    }

    protected Subject(Parcel in) {
        Id = in.readString();
        Name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(Name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    public String getId(){return this.Id;}
    public String getName(){return this.Name;}

}
