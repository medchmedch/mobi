package com.example.mobi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText name_input,email_input,pass_input,bus_input;
    Button update_button, delete_button;
    String id, name, email,pass,bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name_input=findViewById(R.id.name_input2);
        pass_input=findViewById(R.id.pass_input2);
        bus_input=findViewById(R.id.bus_input2);
        email_input=findViewById(R.id.mail_input2);
        update_button=findViewById(R.id.add_button2);
        delete_button=findViewById(R.id.add_button3);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydatabase myDB = new Mydatabase(Update.this);
                name = name_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                pass=pass_input.getText().toString().trim();
                bus=bus_input.getText().toString().trim();

                myDB.updateData(id, name, email,pass,bus);

            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();

            }
        });
        getIntentData();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);}
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Mydatabase myDB = new Mydatabase(Update.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
    void getIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("email")  &&
                getIntent().hasExtra("pass") &&
                getIntent().hasExtra("bus")){
            id= getIntent().getStringExtra("id");
            name= getIntent().getStringExtra("name");
            email= getIntent().getStringExtra("email");
            pass=getIntent().getStringExtra("pass");
            bus=getIntent().getStringExtra("bus");

            name_input.setText(name);
            email_input.setText(email);
            pass_input.setText(pass);
            bus_input.setText(bus);


        }else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }
}