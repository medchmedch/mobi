package com.example.mobi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText name_input, email_input,pass_input,bus_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input);
        email_input = findViewById(R.id.mail_input);
        add_button = findViewById(R.id.add_button);
        pass_input=findViewById(R.id.pass_input);
        bus_input=findViewById(R.id.bus_input);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydatabase myDB = new Mydatabase(AddActivity.this);
                myDB.addUser(name_input.getText().toString().trim(),
                        email_input.getText().toString().trim(),pass_input.getText().toString().trim(),bus_input.getText().toString().trim());

            }
        });
    }


}