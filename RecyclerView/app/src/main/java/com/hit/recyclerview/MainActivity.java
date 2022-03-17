package com.hit.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerAdapter adapter = new RecyclerAdapter(this, products);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(itemDecoration);
    }

    static {
        products.add(new Product(R.drawable.img1, "Mực", "Mực sốt XO", 120000));
        products.add(new Product(R.drawable.img2, "Bào ngư", "Bào ngư nướng", 130000));
        products.add(new Product(R.drawable.img3, "Cua", "Cua hoàng đế hấp", 140000));
        products.add(new Product(R.drawable.img4, "Tôm", "Tôm hùm rang muối ớt", 150000));
        products.add(new Product(R.drawable.img5, "Tôm", "Tôm hùm sốt XO", 160000));
        products.add(new Product(R.drawable.img6, "Mực", "Mực hấp", 170000));
        products.add(new Product(R.drawable.img7, "Cua", "Cua hoàng đế rang muối",180000));
    }
}