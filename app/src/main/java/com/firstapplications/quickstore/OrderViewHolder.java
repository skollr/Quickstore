package com.firstapplications.quickstore;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderViewHolder extends RecyclerView.ViewHolder
{
    private TextView product;
    public OrderViewHolder(@NonNull View itemView)
    {
        super(itemView);
        product = (TextView) itemView.findViewById(R.id.order_product);
    }

    public void setProduct(String product)
    {
        this.product.setText(product);
    }
}
