package com.megateamaj.notetaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class AddNoteActivity extends AppCompatActivity {

    EditText title, description;
    Button cancel, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.editTextTitle);
        description = findViewById(R.id.editTextTextDescription);
        cancel = findViewById(R.id.btnCancel);
        save = findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "nothing Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    public void saveNote(){

        String noteTitle = title.getText().toString();
        String noteDescription = description.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("noteTitle", noteTitle);
        intent.putExtra("noteDescription", noteDescription);
        setResult(RESULT_OK, intent);
        finish();

    }
}