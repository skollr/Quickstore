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
        holder.storeNameTxtView.setText(storeList.get(position).getNombre());
        holder.storeAddressTxtView.setText(storeList.get(position).getDireccion());
        holder.storePhoneNumberTxtView.setText(storeList.get(position).getTelefonoFijo());
        holder.storeWebSiteTxtView.setText(storeList.get(position).getPaginaWeb());
    }

    @Override
    public int getItemCount()
    {
        return storeList.size();
    }
}
