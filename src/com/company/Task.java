package com.company;

import org.joda.time.LocalDate;

import java.io.*;
import java.nio.Buffer;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Task {
    String task;
    String description;
    LocalDate date; //year, month, day
    LocalTime time;

    private Task(String task, String description, LocalDate date, LocalTime time)
    {
        this.task = task;
        this.description = description;
        this.date = date;
        this.time = time;
    }


    public static void printCurrentDayTask(User user) throws Exception {
        StringBuilder tasks = new StringBuilder();
        String currDate = new LocalDate().toString();
        try {
            File myObj = new File(user.userName + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String task[] = line.split(":");


                if(task[2].equals(currDate)){
                    tasks.append(line + "\n");
                }

            }
            myReader.close();
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        System.out.println(tasks);

    }


    public static void addTask(User user) throws Exception {
        System.out.println("Enter your task");
        String task = getInput.getString();
        System.out.println("Enter a description of the task");
        String description = getInput.getString();
        System.out.println("Enter the date the task needs to be completed in the format YYYY-MM-DD");
        LocalDate date = getInput.getDate();
        System.out.println("Enter the time the task needs to be completed in the format HH:MM");
        LocalTime time = getInput.getTime();

        try
        {
            FileWriter myWriter = new FileWriter(user.userName+".txt", true);
            myWriter.write(task+","+description+","+time+":"+date+"\n");
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
