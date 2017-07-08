package com.example.elekt.preparefortest.Model;

import java.util.ArrayList;
import java.util.logging.*;

/**
 * Created by elekt on 07.07.2017.
 */

public class Test {
    private Long id;
    private static final Integer SUCCESSFULLY_PASSED_PERCENTAGE = 90;
    private String name;
    private String programmingLanguage;
    private Topic topic;
    private Level level;
    private ArrayList<Task> tasks = new ArrayList<>();
    private Integer timeLimitsMin;
    private User creator;
    private Boolean isApproved;

}
