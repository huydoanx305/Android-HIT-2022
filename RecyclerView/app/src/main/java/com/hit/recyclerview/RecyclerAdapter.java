package com.hit.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Product> products;

    public RecyclerAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.image.setImageResource(product.getImage());
        holder.type.setText(product.getType());
        holder.name.setText(product.getName());
        holder.price.setText("RS " + product.getPrice().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable viewColor = (ColorDrawable) holder.itemView.getBackground();
                if(viewColor.getColor() == Color.BLACK) {
                    holder.itemView.setBackgroundColor(Color.parseColor("#ee9b00"));
                    holder.name.setTextColor(Color.BLACK);
                } else {
                    holder.itemView.setBackgroundColor(Color.BLACK);
                    holder.name.setTextColor(Color.WHITE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.isEmpty() ? 0 : products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView type, name, price;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.image);
        }
    }
}
