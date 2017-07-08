package com.example.elekt.preparefortest.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 20.06.2017.
 */

public class UserAccounts {
    private static Map<String, String> accounts = new HashMap<>();

    static {
        accounts.put("admin", "admin");
    }

    public static Map<String, String> getAccounts() {
        return accounts;
    }

    public static boolean isValid(String login, String password) {
        if (accounts.get(login).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isExists(String login) {
        if (accounts.get(login) != null) {
            return true;
        } else {
            return false;
        }
    }
}
