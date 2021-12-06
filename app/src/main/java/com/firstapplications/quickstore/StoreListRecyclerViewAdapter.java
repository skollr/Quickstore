package com.firstapplications.quickstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreListRecyclerViewAdapter extends RecyclerView.Adapter<StoreListViewHolder>
{
    private List<Store> storeList;

    public StoreListRecyclerViewAdapter(@NonNull List<Store> storeList)
    {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public StoreListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.qstr_store_item,
                                                                            parent, false);
        return new StoreListViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListViewHolder holder, int position)
    {
        holder.setStoreNameTxtView(storeList.get(position).getNombre());
        holder.setStoreAddressTxtView(storeList.get(position).getDireccion());
        holder.setStorePhoneNumberTxtView(storeList.get(position).getTelefonoFijo());
        holder.setStoreWebSiteTxtView(storeList.get(position).getPaginaWeb());
        holder.setId_store(storeList.get(position).getId_store());
    }

    @Override
    public int getItemCount()
    {
        return storeList.size();
    }
}
