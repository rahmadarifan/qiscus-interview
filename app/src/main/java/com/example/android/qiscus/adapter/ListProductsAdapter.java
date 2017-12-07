package com.example.android.qiscus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.qiscus.R;
import com.example.android.qiscus.model.Products;

import java.util.List;

/**
 * Created by Ifan on 12/7/2017.
 */

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.ProductViewHolder> {
    List<Products.Main> productList;
    Context context;

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView tvName, tvPrice, tvDesc;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvDesc= itemView.findViewById(R.id.tv_desc);
            ivProduct = itemView.findViewById(R.id.iv_product);
        }
    }

    public ListProductsAdapter(List<Products.Main> mains, Context context){
        productList = mains;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ListProductsAdapter.ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Products.Main product = productList.get(position);
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText("$ "+product.getPrice());
        holder.tvDesc.setText(product.getDescription());
        List<Products.Image>  images = productList.get(position).getImages();
        if (!images.isEmpty()){
            Glide.with(context.getApplicationContext()).load(images.get(0).getThumb()).into(holder.ivProduct);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
