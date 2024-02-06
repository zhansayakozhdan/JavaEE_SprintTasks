package db;

import models.Task;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    static List<Task> tasks = new ArrayList<>();

    private static Long id = 8L;

    static {
        tasks.add(new Task(1L, "Task1 JavaEE Tomcat Jakarta", "You need to do all tasks", "2024-02-07", false));
        tasks.add(new Task(2L, "Task2", "You need to do", "2024-02-08", false));
        tasks.add(new Task(3L, "Task3", "You need to do", "2024-02-09", true));
        tasks.add(new Task(4L, "Task4", "You need to do", "2024-02-10", true));
        tasks.add(new Task(5L, "Task5", "You need to do", "2024-02-11", true));
        tasks.add(new Task(6L, "Task6", "You need to do", "2024-02-12", false));
        tasks.add(new Task(7L, "Task7", "You need to do", "2024-02-13", false));
    }

    public static List<Task> getAllTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTaskById(Long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static void deleteTaskById(Long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(tasks.get(i));
            }
        }

    }

    public static void updateTask(Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == updatedTask.getId()) {
                task.setName(updatedTask.getName());
                task.setDescription(updatedTask.getDescription());
                task.setDeadlineDate(updatedTask.getDeadlineDate());
                task.setStatus(updatedTask.isStatus());
                return;
            }
        }
    }

}
