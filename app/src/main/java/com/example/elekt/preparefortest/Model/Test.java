package com.example.elekt.preparefortest.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by elekt on 07.07.2017.
 */

public class Test {
    private Long id;
    private Integer successfullyPassedPercentage = 90;
    private String name;
    private ProgrammingLanguage programmingLanguage;
    private Topic topic;
    private Level level;
    private Collection<Task> tasks;
    private Integer timeLimitsMin;
    private User creator;
    private Boolean isApproved;

    public Test(Long id, String name, ProgrammingLanguage programmingLanguage,
                Topic topic, Level level, Collection<Task> tasks, Integer timeLimitsMin,
                User creator, Boolean isApproved, Integer successfullyPassedPercentage) {
        this.id = id;
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.topic = topic;
        this.level = level;
        if (tasks == null) {
            this.tasks = new ArrayList<>();
        } else {
            this.tasks = tasks;
        }
        this.timeLimitsMin = timeLimitsMin;
        this.creator = creator;
        this.isApproved = isApproved;
        this.successfullyPassedPercentage = successfullyPassedPercentage;
    }

    public Long getId() {
        return id;
    }

    public Integer getSuccessfullyPassedPercentage() {
        return successfullyPassedPercentage;
    }

    public void setSuccessfullyPassedPercentage(Integer successfullyPassedPercentage) {
        this.successfullyPassedPercentage = successfullyPassedPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getTimeLimitsMin() {
        return timeLimitsMin;
    }

    public void setTimeLimitsMin(Integer timeLimitsMin) {
        this.timeLimitsMin = timeLimitsMin;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}
