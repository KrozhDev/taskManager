package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {


    private final int MAX_NUM_OF_TASKS = 7;
    private int numOfTasks;
    private List<String> tasks;

    Todos testTodos = new Todos();

    @BeforeEach
    void beforeEach() {
        testTodos.addTask("Бегать");
        testTodos.addTask("Прыгать");
        testTodos.addTask("Летать");
    }



    @Test
    void addTask() {
        ArrayList expected = new ArrayList<>(Arrays.asList("бегать", "прыгать", "летать"));
        ArrayList tested = (ArrayList) testTodos.getTasks();

        Assertions.assertArrayEquals(expected.toArray(),tested.toArray());

    }

    @Test
    void removeTask() {
        testTodos.removeTask("прыгать");
        ArrayList expected = new ArrayList<>(Arrays.asList("бегать", "летать"));
        ArrayList tested = (ArrayList) testTodos.getTasks();

        Assertions.assertArrayEquals(expected.toArray(),tested.toArray());
    }

    @Test
    void restoreTask() {
        testTodos.restoreTask();

        ArrayList expected = new ArrayList<>(Arrays.asList("бегать", "прыгать"));
        ArrayList tested = (ArrayList) testTodos.getTasks();

        Assertions.assertArrayEquals(expected.toArray(),tested.toArray());

    }

    @Test
    void getAllTasks() {

        String expected = "бегать летать прыгать";
        String tested = testTodos.getAllTasks();

        Assertions.assertEquals(expected.hashCode(), tested.hashCode());

    }
}