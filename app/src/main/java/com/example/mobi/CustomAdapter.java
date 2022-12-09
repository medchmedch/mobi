package com.example.mobi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> user_id, name, email,pass,bus;
    Activity activity;
    CustomAdapter(Activity activity,Context context, ArrayList<String> user_id,ArrayList<String> name,ArrayList<String> email,ArrayList<String> pass,ArrayList<String> bus){
        this.context=context;
        this.user_id=user_id;
        this.name=name;
        this.email=email;
        this.activity=activity;
        this.pass=pass;
        this.bus=bus;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.user_id_txt.setText(String.valueOf(user_id.get(position)));
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.bus_txt.setText(String.valueOf(bus.get(position)));
        holder.mainLayout.setOnClickListener(v -> {
           Intent intent= new Intent(context, Update.class);
            intent.putExtra("id", String.valueOf(user_id.get(position)));
            intent.putExtra("name", String.valueOf(name.get(position)));
            intent.putExtra("email", String.valueOf(email.get(position)));
            intent.putExtra("bus", String.valueOf(bus.get(position)));
            intent.putExtra("pass", String.valueOf(pass.get(position)));
           activity.startActivityForResult(intent,1);
        });

    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView user_id_txt,name_txt,email_txt,pass_txt,bus_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            user_id_txt = itemView.findViewById(R.id.user_id_txt);
            name_txt = itemView.findViewById(R.id.name_txt);
            email_txt = itemView.findViewById(R.id.email_txt);
            mainLayout=itemView.findViewById(R.id.mainLayout);
            bus_txt=itemView.findViewById(R.id.bus_txt);

        }
    }
}
