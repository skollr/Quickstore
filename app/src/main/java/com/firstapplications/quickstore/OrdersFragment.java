package com.firstapplications.quickstore;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment
{
    private TextView txtQuantity;
    private AutoCompleteTextView autoCompleteTextView;
    private Button minusButton;
    private Button plusButton;
    private Button aggregateButton;
    private int quantityOrdered;
    private RecyclerView recyclerView;
    private List<ProductOrdered> productOrderedList = new ArrayList<ProductOrdered>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        quantityOrdered = 1;
        txtQuantity = (TextView) view.findViewById(R.id.quantity);
        txtQuantity.setText(String.valueOf(quantityOrdered));
        minusButton = (Button) view.findViewById(R.id.btn_minus);
        plusButton = (Button) view.findViewById(R.id.btn_plus);
        aggregateButton = (Button) view.findViewById(R.id.btn_aggregate);
        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.autocomplete_products);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_forOrders);
        minusButton.setOnClickListener(new View.OnClickListener()
                                            {
                                                @Override
                                                public void onClick(View v)
                                                {
                                                    if(quantityOrdered >= 0)
                                                    {
                                                        quantityOrdered --;
                                                        txtQuantity.setText(String.valueOf(quantityOrdered));
                                                    }
                                                }
                                            });
        plusButton.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                quantityOrdered ++;
                                                txtQuantity.setText(String.valueOf(quantityOrdered));
                                            }
                                        });

        aggregateButton.setOnClickListener(new View.OnClickListener()
                                            {
                                                @Override
                                                public void onClick(View v)
                                                {
                                                    if(!autoCompleteTextView.getText().toString().equals(""))
                                                    {
                                                        productOrderedList.add(new ProductOrdered(autoCompleteTextView.getText().toString(),
                                                                                                    Integer.valueOf(txtQuantity.getText().toString())));
                                                        Log.i("OrdersFragment.java", productOrderedList.get(0).toString());
                                                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                                        recyclerView.setAdapter(new OrderRecyclerViewAdapter(productOrderedList));
                                                    }

                                                }
                                            });
        return view;
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
        String products = getArguments().getString("products");
        String[] productsInArray = products.split(",");
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.list_item, productsInArray);
        AutoCompleteTextView autocompleteProducts = view.findViewById(R.id.autocomplete_products);
        autocompleteProducts.setAdapter(arrayAdapter);
    }
}
