package com.example.AndroidFragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.AndroidFragments.Classes.UserViewModel;
import com.example.AndroidFragments.R;
import com.example.AndroidFragments.Classes.User;
import androidx.lifecycle.ViewModelProvider;
//import com.example.AndroidFragments.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {

    private UserViewModel userViewModel;

    public FragmentTwo() {
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
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        EditText usernameEditText = view.findViewById(R.id.newInputUS);
        EditText passwordEditText = view.findViewById(R.id.newPassInput);
        EditText phoneEditText = view.findViewById(R.id.newPhone);
        Button registerButton = view.findViewById(R.id.newCreateUS);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                // Check if username, password, and phone are empty
                if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if username already exists
                for (User user : userViewModel.getUserList()) {
                    if (user.getUsername().equals(username)) {
                        Toast.makeText(getActivity(), "Username already exists", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                // Register the user
                User newUser = new User(username, password, phone);
                userViewModel.getUserList().add(newUser);
                Toast.makeText(getActivity(), "User registered successfully", Toast.LENGTH_SHORT).show();

                // Clear input fields after registration
                usernameEditText.setText("");
                passwordEditText.setText("");
                phoneEditText.setText("");
            }
        });

        return view;
    }
    private void displayUserList() {
        StringBuilder userListText = new StringBuilder("User List:\n");
        for (User user : userViewModel.getUserList()) {
            userListText.append("Username: ").append(user.getUsername()).append(", Password: ").append(user.getPassword()).append(", Phone: ").append(user.getPhoneNumber()).append("\n");
        }
        Toast.makeText(getActivity(), userListText.toString(), Toast.LENGTH_LONG).show();
    }
}
