package com.example.elekt.preparefortest.Presenter;


import com.example.elekt.preparefortest.Model.Task;

/**
 * Created by elekt on 07.07.2017.
 */

public class TasksManager implements IManager {
    private static TasksManager taskManager;

    static {
        taskManager = new TasksManager();
    }

    private TasksManager() {
    }

    public TasksManager getInstance() {
        return taskManager;
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public Object remove(Object object) {
        return null;
    }

    public void approve(Task task){

    }
    public void reject(Task task) {

    }
}
