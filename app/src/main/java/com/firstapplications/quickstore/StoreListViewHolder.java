package com.firstapplications.quickstore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class StoreListViewHolder extends RecyclerView.ViewHolder
{
    private TextView storeNameTxtView;
    private TextView storeAddressTxtView;
    private TextView storePhoneNumberTxtView;
    private TextView storeWebSiteTxtView;
    private int id_store;

    public StoreListViewHolder(@NonNull View itemView)
    {
        super(itemView);
        storeNameTxtView = (TextView) itemView.findViewById(R.id.store_name);
        storeAddressTxtView = (TextView) itemView.findViewById(R.id.order_product);
        storePhoneNumberTxtView = (TextView) itemView.findViewById(R.id.store_phoneNumber);
        storeWebSiteTxtView = (TextView) itemView.findViewById(R.id.store_webSite);
        itemView.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                Bundle bundle = new Bundle();
                                                bundle.putInt("id", id_store);
                                                Navigation.findNavController(itemView).
                                                        navigate(R.id.detailsOfStoreItem, bundle);
                                            }
                                        });
    }

    public TextView getStoreNameTxtView()
    {
        return storeNameTxtView;
    }

    public void setStoreNameTxtView(String name)
    {
        this.storeNameTxtView.setText(name);
    }

    public TextView getStoreAddressTxtView()
    {
        return storeAddressTxtView;
    }

    public void setStoreAddressTxtView(String address)
    {
        this.storeAddressTxtView.setText(address);
    }

    public TextView getStorePhoneNumberTxtView()
    {
        return storePhoneNumberTxtView;
    }

    public void setStorePhoneNumberTxtView(String phoneNumber)
    {
        this.storePhoneNumberTxtView.setText(phoneNumber);
    }

    public TextView getStoreWebSiteTxtView()
    {
        return storeWebSiteTxtView;
    }

    public void setStoreWebSiteTxtView(String webSite)
    {
        this.storeWebSiteTxtView.setText(webSite);
    }

    public void setId_store(int id_store)
    {
        this.id_store = id_store;
    }
}
