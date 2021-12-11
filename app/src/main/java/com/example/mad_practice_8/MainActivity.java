package com.example.mad_practice_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> _books;
    RecyclerView _recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets data from somewhere into a model's list
        setData();

        _recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, _books);
        _recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(getString(R.string.books), _books);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        _books = savedInstanceState.getParcelableArrayList(getString(R.string.books));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, _books);
        _recyclerView.setAdapter(adapter);
    }

    private void setData() {
        _books = new ArrayList<>();
        _books.add(new Book(R.drawable.cover_1984, "1984"));
        _books.add(new Book(R.drawable.cover_arial, "Ариэль"));
        _books.add(new Book(R.drawable.cover_mumu, "Муму"));
        _books.add(new Book(R.drawable.cover_otcy_i_deti, "Отцы и дети"));
        _books.add(new Book(R.drawable.cover_temnaya_bashnya, "Тёмная башня"));
        _books.add(new Book(R.drawable.cover_trudno_byt_bogom, "Трудно быть богом"));
    }
}