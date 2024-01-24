package com.megateamaj.notetaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class UpdateActivity extends AppCompatActivity {
    EditText title, description;
    Button cancel, save;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.editTextTitleUpdate);
        description = findViewById(R.id.editTextTextDescriptionUpdate);
        cancel = findViewById(R.id.btnCancelUpdate);
        save = findViewById(R.id.btnSaveUpdate);

        getData();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNote();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "nothing Updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void UpdateNote() {
        String titleLast = title.getText().toString();
        String descriptionLast = description.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("noteTitleLast", titleLast);
        intent.putExtra("noteDescriptionLast", descriptionLast);
        if(noteId != -1)
        {
            intent.putExtra("noteId", noteId);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void getData(){
        Intent i = getIntent();
        String noteTitle = i.getStringExtra("noteTitle");
        String noteDescription = i.getStringExtra("noteDescription");
        noteId = i.getIntExtra("id", -1);

        title.setText(noteTitle);
        description.setText(noteDescription);

    }
}