package com.smart.shoppingcartapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smart.shoppingcartapp.models.Product;

import java.util.ArrayList;

public class ShoppingCartRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingCartRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "ShoppingCartRecyclerViewAdapter";

    //vars
    private ArrayList<Product> mProducts = new ArrayList<>();
    private Context mContext;

    public ShoppingCartRecyclerViewAdapter(Context mContext , ArrayList<Product> mProducts) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ShoppingCartRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_feed_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartRecyclerViewAdapter.ViewHolder holder, int position) {
        RequestOptions requestOptions =  new RequestOptions()
                                        .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(this.mProducts.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return this.mProducts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

}
