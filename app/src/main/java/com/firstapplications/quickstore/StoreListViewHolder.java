package com.firstapplications.quickstore;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class StoreListViewHolder extends RecyclerView.ViewHolder
{
    public TextView storeNameTxtView;
    public TextView storeAddressTxtView;
    public TextView storePhoneNumberTxtView;
    public TextView storeWebSiteTxtView;

    public StoreListViewHolder(@NonNull View itemView)
    {
        super(itemView);
        storeNameTxtView = (TextView) itemView.findViewById(R.id.store_name);
        storeAddressTxtView = (TextView) itemView.findViewById(R.id.store_address);
        storePhoneNumberTxtView = (TextView) itemView.findViewById(R.id.store_phoneNumber);
        storeWebSiteTxtView = (TextView) itemView.findViewById(R.id.store_webSite);
        itemView.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                Navigation.findNavController(v).
                                                navigate(R.id.action_nav_fragment_home_to_detailsOfStoreItem);
                                            }
                                        });
    }
}
