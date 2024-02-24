package com.example.AndroidFragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.AndroidFragments.Classes.Product;
import com.example.AndroidFragments.Classes.ProductAdapter;
import com.example.AndroidFragments.Classes.ProductData;
import com.example.AndroidFragments.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentThree extends Fragment {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;


    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        recyclerView = view.findViewById(R.id.res);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Bundle bundle = getArguments();
        if (bundle != null) {
             //Retrieve username from arguments Bundle
            String username = bundle.getString("username");
            System.out.println(username);
             //Display the username in the right corner of Fragment Three
            TextView usernameTextView = view.findViewById(R.id.textViewFR3);
            usernameTextView.setText(username);
        }
        List<Product> productList = ProductData.getProductList();

        // Initialize adapter with the data
        adapter = new ProductAdapter(productList);

        // Set adapter to RecyclerView
        recyclerView.setAdapter(adapter);
        return view;
    }
}