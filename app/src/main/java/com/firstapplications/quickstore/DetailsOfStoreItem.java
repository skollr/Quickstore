package com.firstapplications.quickstore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsOfStoreItem#} factory method to
 * create an instance of this fragment.
 */
public class DetailsOfStoreItem extends Fragment {
    private List<Store> storeList;
    private static Store storeForDetails;
    private TextView nameOfStore, products, address, phone, mobilePhone, webPage;
    private Button goToOrdersButton, goToMaps;


    public DetailsOfStoreItem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            storeList = objectMapper.readValue(getResources().openRawResource(R.raw.stores),
                    objectMapper.getTypeFactory().
                            constructCollectionType(ArrayList.class, Store.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id_store = getArguments().getInt("id");
        for (Store store : storeList) {
            if (store.getId_store() == id_store) {
                storeForDetails = store;
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_of_store_item, container, false);
        nameOfStore = (TextView) view.findViewById(R.id.txt_nameOfStore_details);
        products = (TextView) view.findViewById(R.id.txt_products_details);
        address = (TextView) view.findViewById(R.id.txt_address_details);
        phone = (TextView) view.findViewById(R.id.txt_phone_details);
        mobilePhone = (TextView) view.findViewById(R.id.txt_mobile_phone_number_details);
        webPage = (TextView) view.findViewById(R.id.txt_web_page_details);
        goToOrdersButton = (Button) view.findViewById(R.id.goToOrders_btn);
        goToMaps = (Button) view.findViewById(R.id.goToMaps);

        nameOfStore.setText(storeForDetails.getNombre());
        products.setText(storeForDetails.getCategorias());
        address.setText(storeForDetails.getDireccion());
        phone.setText(storeForDetails.getTelefonoFijo());
        mobilePhone.setText("Not available");
        webPage.setText(storeForDetails.getPaginaWeb());
        goToOrdersButton.setOnClickListener(new View.OnClickListener()
                                                {
                                                    @Override
                                                    public void onClick(View v)
                                                    {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putString("products", storeForDetails.getCategorias());
                                                        Navigation.findNavController(v).
                                                                navigate(R.id.action_detailsOfStoreItem_to_ordersFragment, bundle);
                                                    }
                                                });
        goToMaps.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                Uri uri = Uri.parse(storeForDetails.getGeoLocalizacion());
                                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                startActivity(intent);
                                            }
                                        });
        return view;
    }
}