package com.example.listview_test;

import android.os.Parcel;
import android.os.Parcelable;
public class Student implements Parcelable {
    String imageURL;
    String Name;
    String Birth;
    String ClassId;

    Subject[] subjects;
    public Student(String Name, String Birth, String ClassId, Subject[] subjects, String imageURL)
    {
        this.Name = Name;
        this.Birth = Birth;
        this.ClassId = ClassId;
        this.imageURL = imageURL;
        this.subjects = subjects;
    }

    protected Student(Parcel in) {
        imageURL = in.readString();
        Name = in.readString();
        Birth = in.readString();
        ClassId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageURL);
        dest.writeString(Name);
        dest.writeString(Birth);
        dest.writeString(ClassId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName()
    {
        return this.Name;
    }
    public String getBirth()
    {
        return this.Birth;
    }
    public String getclassid()
    {
        return this.ClassId;
    }

    public String getImageURL() {return this.imageURL; }
    public Subject[] getSubjects(){return this.subjects;}
}
