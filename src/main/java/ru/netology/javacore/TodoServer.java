package ru.netology.javacore;
import com.google.gson.Gson;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class TodoServer {

    private int port;
    private Todos todos;
    private Gson gson;


    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
        this.gson = new Gson();
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    out.println("Сервер запущен");
                    String jsonString = in.readLine();
                    getResponse(jsonString);
                    out.println(this.todos.getAllTasks());
                }
            }
        } catch (
                IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    private void getResponse(String jsonString) {
        Map<String, String> map = this.gson.fromJson(jsonString, Map.class);
        switch (map.get("type")) {
            case "ADD":
                this.todos.addTask(map.get("task"));
                break;
            case "REMOVE":
                this.todos.removeTask(map.get("task"));
                break;
            case "RESTORE":
                this.todos.restoreTask();
                break;
            default:
                break;
        }
    }
}

