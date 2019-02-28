package com.smart.shoppingcartapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.smart.shoppingcartapp.models.Product;
import com.smart.shoppingcartapp.resources.Products;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;

    //Vars
    private ShoppingCartRecyclerViewAdapter mAdapter;
    private ArrayList<Product> mProducts = new ArrayList<>();

    //widgets
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mRecyclerView = findViewById(R.id.recycler_view);
        getProducts();
        initRecyclerView();
    }

    private void getProducts(){
        this.mProducts.addAll(Arrays.asList(Products.FEATURED_PRODUCTS));
    }

    private void initRecyclerView() {
        Log.i(TAG, "=>" + this.mProducts.size());
        this.mAdapter = new ShoppingCartRecyclerViewAdapter(this,this.mProducts);
        GridLayoutManager layoutManager = new GridLayoutManager(this,this.NUM_COLUMNS);
        this.mRecyclerView.setLayoutManager(layoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }
}
