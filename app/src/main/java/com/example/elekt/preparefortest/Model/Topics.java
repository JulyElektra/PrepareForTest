package com.example.elekt.preparefortest.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elekt on 07.07.2017.
 */

public class Topics {
    private static Map<String, String> topics = new HashMap<>();

    static  {
        topics.put("Design patterns", "All");
        topics.put("JVM", "Java");
        topics.put("PHP topic", "PHP");
        topics.put("Pointers","C/C++");
        topics.put("Python topic", "Python");
        topics.put("Properties","C#");
    }

    public static Map<String, String> getTopics() {
        return topics;
    }

    public static void addTopic(String topic, String programmingLanguage) {
        topics.put(topic, programmingLanguage);
    }
}
