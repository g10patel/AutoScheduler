package com.company;

import org.joda.time.DateTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import java.util.Scanner;

public class Planner {
    public static void Execute(User user, ArrayList<Task> tasks) throws Exception {
        System.out.println("There are various commands you can choose from.");
        System.out.println("Press 1 to create a task");
        System.out.println("Press 2 to see a list on today's tasks");
        System.out.println("Press 3 to make a task as complete");
        System.out.println("Press 4 to complete list of all tasks");
        System.out.println("Press 5 to delete a task");
        System.out.println("Press 6 for settings");
        System.out.println("Press 7 to save your planner");
        System.out.println("Press 0 to quit");
        int input = getInput.getInt();

        switch(input){
            case 1:
                tasks = Task.addTask(user, tasks);
                Execute(user, tasks);

            case 2:
                Task.printCurrentDayTask(user, tasks);
                Execute(user, tasks);

            case 3:
                tasks = Task.completeTask(tasks);
                Execute(user,tasks);

            case 4:
                Task.printTasks(user, tasks);
                Execute(user, tasks);
            case 5:// Delete a task
                Task.deleteTask(user, tasks);
                Execute(user,tasks);

            case 6://TODO

            case 7:
                saveData(user, tasks);
                Execute(user,tasks);
            case 0:
                System.exit(0);
            default :
                System.out.println("Invalid input");
                Execute(user, tasks);

        }


    }

    private static void saveData(User user, ArrayList<Task> tasks) throws IOException {

        File oldf = new File(user.userName+".txt");
        oldf.delete();
        File newf = new File(user.userName+".txt");
        FileWriter myWriter = new FileWriter(newf, true);
        for (Task a : tasks)
        {
            myWriter.append(a.task+","+a.description+","+a.time+","+a.date+"\n");
        }
        myWriter.close();
    }


    public static ArrayList<Task> loadData(User user) throws Exception {
        File userPlanner = new File(user.userName+".txt");
        if (!userPlanner.exists()) {
            System.out.println("You do not have an existing planner. A blank one has been created.");
            try {
                userPlanner.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
                System.exit(1);
            }
        }

        ArrayList<Task> data = new ArrayList<Task>();
        try {
            File myObj = new File(user.userName + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.add(Task.toTask(myReader.nextLine()));
            }
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data;

    }


}
