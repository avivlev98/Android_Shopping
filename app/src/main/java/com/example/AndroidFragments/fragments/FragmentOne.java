package com.example.AndroidFragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AndroidFragments.Classes.*;
import com.example.AndroidFragments.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.ViewModelProvider;

public class FragmentOne extends Fragment {
    private UserViewModel userViewModel;


    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        EditText usernameEditText = view.findViewById(R.id.InputUserName);
        EditText passwordEditText = view.findViewById(R.id.InputPassword);
        Button loginButton = view.findViewById(R.id.ButtonLogin);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if username, password, and phone are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!IfUserExists(username, password)) {
                    Toast.makeText(getActivity(), "Username or password not correct", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getActivity(), "User logged in successfully", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                FragmentThree fragmentThree = (FragmentThree) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentThree);

                if (fragmentThree != null) {
                    // FragmentThree already exists, set arguments directly
                    fragmentThree.setArguments(bundle);
                } else {
                    // FragmentThree doesn't exist yet, navigate and pass arguments
                    Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentThree, bundle);
                }


            }
        });


        Button button_CreateNewUser = (Button) view.findViewById(R.id.CreateNewUser);
        button_CreateNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentTwo);
            }
        });

        return view;
    }
    public boolean IfUserExists(String username,String password){
        for (User user : userViewModel.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}