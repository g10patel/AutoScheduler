package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

public class Task {
    String task;
    String description;
    Date date; //year, month, day
    LocalTime time;

    private Task(String task, String description, Date date, LocalTime time)
    {
        this.task = task;
        this.description = description;
        this.date = date;
        this.time = time;
    }




    public static void addTask(User user) throws Exception {
        System.out.println("Enter your task");
        String task = getInput.getString();
        System.out.println("Enter a description of the task");
        String description = getInput.getString();
        System.out.println("Enter the date the task needs to be completed in the format YYYY/MM/DD");
        Date date = getInput.getDate();
        System.out.println("Enter the time the task needs to be completed in the format HH:MM");
        LocalTime time = getInput.getTime();

        try
        {
            FileWriter myWriter = new FileWriter(user.userName+".txt", true);
            myWriter.write(task+","+description+","+date+","+time+"\n");
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    public static void printTasks(User user) throws Exception {
        System.out.println("Here are all of your tasks");
        System.out.println(getInput.getFile(user));
        Planner.Execute(user);
    }


}
