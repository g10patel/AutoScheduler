package com.company;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.ArrayList;

public class Task {
    String task;
    String description;
    LocalDate date; //year, month, day
    LocalTime time;
    Double timeToComplete;


    private Task(String task, String description, LocalTime time, LocalDate date, Double timeToComplete) {
        this.task = task;
        this.description = description;
        this.date = date;
        this.time = time;
        this.timeToComplete = timeToComplete;
    }

    public static Task toTask(String taskString) {
        String[] taskArr = taskString.split(",");
        String[] timeArr = taskArr[2].split(":");
        return (new Task(taskArr[0], taskArr[1], new LocalTime(Integer.parseInt(timeArr[0]), Integer.parseInt(timeArr[1])), new LocalDate(taskArr[3]), Double.parseDouble(taskArr[4])));

    }

    //Prints all tasks that are due on the current day
    public static void printCurrentDayTask(User user, ArrayList<Task> tasks) {
        StringBuilder currDayTasks = new StringBuilder();
        LocalDate currDate = new LocalDate();
        for (Task i : tasks) {

            if (currDate.equals(i.date)) {
                currDayTasks.append(i.toString());
            }
        }

        System.out.println(currDayTasks);

    }

    public static void deleteTask(User user, ArrayList<Task> tasks) throws Exception {
        System.out.println("Type the number of the task you want to delete");
        printTasks(user, tasks);
        int indexOfTaskToDelete = getInput.getInt() - 1;
        tasks.remove(indexOfTaskToDelete);
    }

    public static ArrayList<Task> completeTask(ArrayList<Task> tasks) {
        System.out.println("Type the number of the task you want to complete");
        int j = 1;
        for (Task i : tasks) {
            System.out.println(j + " : " + i.toString());
            j++;
        }

        int indexOfTaskToDelete = getInput.getInt() - 1;
        while (indexOfTaskToDelete > tasks.size()) {
            System.out.println("Invalid number");
            indexOfTaskToDelete = getInput.getInt() - 1;
        }

        tasks.remove(indexOfTaskToDelete);
        return tasks;
    }

    public static ArrayList<Task> addTask(User user, ArrayList<Task> tasks) throws Exception {
        System.out.println("Enter your task");
        String task = getInput.getString();
        System.out.println("Enter a description of the task");
        String description = getInput.getString();
        System.out.println("Enter the date the task needs to be completed in the format YYYY-MM-DD");
        LocalDate date = getInput.getDate();
        System.out.println("Enter the time the task needs to be completed in the format HH:MM");
        LocalTime time = getInput.getTime();
        System.out.println("Enter the time it will take to complete the task");
        Double timeToComplete = getInput.getDouble();

        Task newTask = new Task(task, description, time, date, timeToComplete);
        tasks.add(newTask);
        return tasks;
    }

    public static void printTasks(User user, ArrayList<Task> tasks) throws Exception {
        System.out.println("Here are all of your tasks");
        int count = 1;
        for (Task i : tasks) {
            System.out.print(count++ + ": ");
            System.out.println(i.toString());
        }
        // adds newline for formatting
        System.out.println();
    }

    //Converts a Task to a readable string
    public String toString() {
        //Formats the time so only HH:MM is printed
        String[] timeArr = this.time.toString().split(":");
        return (this.task + "," + this.description + "," + timeArr[0] + ":" + timeArr[1] + "," + this.date + "," + this.timeToComplete);
    }


}
