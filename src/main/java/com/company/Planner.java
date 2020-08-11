package com.company;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Planner {


    private Planner ( Settings settings) {
        settings.autoSchedule = false;
    }

    public static void Execute(User user, ArrayList<Task> tasks) throws Exception {
        System.out.println("There are various commands you can choose from.");
        System.out.println("Press 1 to create a task");
        System.out.println("Press 2 to see a list on today's tasks");
        System.out.println("Press 3 to mark a task as complete");
        System.out.println("Press 4 to see a complete list of all tasks");
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
                /*
                Toggle autoschedule
                change username
                change password
                 */
                System.out.println("Enter the number of which setting you would like to change");
                System.out.println("Press 1 to set the time in between tasks");
                System.out.println("Press 2 to set the amount of time you want to work during each session");
                System.out.println("Press 3 to set the daily start time you want to get started on your work");
                System.out.println("Press 4 to set the daily end time you want to stop working for the day");
                System.out.println("Press 5 to set/add restricted times you dont want to work during the day");
                System.out.println("Press 6 to remove a restricted time");

                int choice = getInput.getInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter the amount of time in minutes you want in between work sessions.");

                    case 2:
                        System.out.println("Enter the amount of time in minutes you want to work during each session");

                    case 3:
                        System.out.println("Enter the time(HH:MM) that you want to start working for the day");

                    case 4:
                        System.out.println("Enter the time(HH:MM) that you want to stop working for the day");

                    case 5:
                        System.out.println("Press 1 to add restricted time(s)");
                        System.out.println("Press 2 to remove existed and set new restricted time(s)");

                    case 6:
                        System.out.println("Press the number of the restricted time you wan to remove");
                }
                System.out.println(user.setting.autoSchedule);
                user.setting.toggleAutoSchedule();
                System.out.println(user.setting.autoSchedule);
                Execute(user,tasks);

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
    //If auto schedule is disabled, tasks will be sorted by date. If enabled, tasks will be arranged.
    public static ArrayList<Task> sortTasks(ArrayList<Task> tasks){
        //Sort by date
        //tasks.sort(Comparator.comparing(Task::getDate));
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                LocalDate x1 = o1.date;
                LocalDate x2 = o2.date;

                int comp1 = x1.compareTo(x2);
                if (comp1 != 0)
                {
                    return comp1;
                }

                LocalTime a1 = o1.time;
                LocalTime a2 = o2.time;
                return a1.compareTo(a2);
            }
        });
        return tasks;
    }


    private static void saveData(User user, ArrayList<Task> tasks) throws IOException {
        //Save planner
        tasks = sortTasks(tasks);
        File oldf = new File(user.userName+".txt");
        oldf.delete();
        File newf = new File(user.userName+".txt");
        FileWriter myWriter = new FileWriter(newf, true);
        for (Task a : tasks)
        {
            myWriter.append(a.task+","+a.description+","+a.time+","+a.date+","+a.timeToComplete+"\n");
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
