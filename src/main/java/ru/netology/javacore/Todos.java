package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private final int MAX_NUM_OF_TASKS = 7;

    private int numOfTasks;
    private List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>();
        this.numOfTasks = 0;
    }


    public void addTask(String task) {
        if (this.tasks.size() < MAX_NUM_OF_TASKS) {
            this.tasks.add(task.toLowerCase());
        }
    }

    public void removeTask(String task) {
        this.tasks.remove(task);
    }

    public void restoreTask() {
        this.tasks.remove(this.tasks.size() - 1);
    }

    public String getAllTasks() {
        String outputString = this.tasks
                .stream()
                .sorted()
                .collect(Collectors.joining(" "));
        return outputString;
    }

    public List<String> getTasks() {
        return this.tasks;
    }
}


