package com.example.elekt.preparefortest.Model;

import android.content.Intent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 07.07.2017.
 */

public class UserStatistics {
    private Integer userID;
    private Map<Test, Integer> testsHistory = new HashMap<>();
    private Integer rate;
}
