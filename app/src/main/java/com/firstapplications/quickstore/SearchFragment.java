package com.firstapplications.quickstore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment
{

    private List<Store> storeList;
    private List<Store> storeListQueried;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            storeList = objectMapper.readValue(getResources().openRawResource(R.raw.stores),
                    objectMapper.getTypeFactory().
                            constructCollectionType(ArrayList.class, Store.class));

            for(Store store : storeList)
            {
                System.out.println(store);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        String query = getArguments().getString("query");

        storeListQueried = new ArrayList<Store>();
        for(Store store : storeList)
        {
            if(store.getCategorias().contains(query))
            {
                storeListQueried.add(store);
            }
        }
        if(storeListQueried.size() > 0)
        {
            recyclerView.setAdapter(new StoreListRecyclerViewAdapter(storeListQueried));
        }
    }
}
