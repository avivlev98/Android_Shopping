package com.example.AndroidFragments.Classes;

import androidx.lifecycle.ViewModel;
import com.example.AndroidFragments.Classes.User;
import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUserList() {
        return userList;
    }
}
