package com.abed.recyclerviewassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RviewHolder>{
    Context context;
    ArrayList<Data> dataArrayList;
    OnClickListener clickListener;

    public RecyclerAdapter(Context context, ArrayList<Data> dataArrayList ,OnClickListener clickListener) {
        this.context = context;
        this.dataArrayList = dataArrayList;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public RviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RviewHolder(LayoutInflater.from(context).inflate(R.layout.item_people_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RviewHolder holder, int position) {
        Data data = dataArrayList.get(position);

        holder.name.setText(dataArrayList.get(position).getName());
        holder.phoneNumber.setText(dataArrayList.get(position).getPhone());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickListener.OnClick(data);


            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    class RviewHolder extends RecyclerView.ViewHolder{
        ImageView image;


        TextView name, age, phoneNumber;
        public RviewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.name);
            phoneNumber =itemView.findViewById(R.id.phone_number);



        }
    }
}
