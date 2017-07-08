package com.example.elekt.preparefortest.Presenter;


import android.content.Context;
import android.graphics.PorterDuff;

import com.example.elekt.preparefortest.Model.Model;
import com.example.elekt.preparefortest.Model.User;
import com.example.elekt.preparefortest.View.Register;

import java.nio.ByteBuffer;

/**
 * Created by elekt on 07.07.2017.
 */

public class UserManager implements IManager {
    private static UserManager userManager;

    static {
        userManager = new UserManager();
    }

    private UserManager() {
    }

    public UserManager getInstance() {
        return userManager;
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public Object remove(Object object) {
        return null;
    }

    public void block(User user) {

    }

    public void unBlock(User user) {

    }

    public static boolean isExists(String login, Context context) {
        Model model = new Model(context);
        User user = model.getUser(login);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }


    public static void addUser(String login, String password, Context context) {
        Model model = new Model(context);
        model.addUser(login, password);
    }

    public static boolean isValid(String login, String password, Context context) {
        Model model = new Model(context);
        User user = model.getUser(login);
        if (user!= null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
