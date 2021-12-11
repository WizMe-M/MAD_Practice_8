package com.example.mad_practice_8;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Book implements Parcelable {
    private int _imgId;
    private String _name;

    public int getImgId() {
        return _imgId;
    }

    public String getName() {
        return _name;
    }

    public Book(int imgId, String name) {
        _imgId = imgId;
        _name = name;
    }

    public Book(Parcel in) {
        _imgId = in.readInt();
        _name = in.readString();
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("'{0}' ({1})", _name, _imgId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_imgId);
        parcel.writeString(_name);
    }

    //для сохранения списка книг при повороте экрана
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
