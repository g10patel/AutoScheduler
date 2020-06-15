package com.company;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.IOException;

public class Planner {
    public static void Execute(User user) throws Exception {
        File userPlanner = new File(user.userName+".txt");
        if (!userPlanner.exists()) {
            System.out.println("You do not have an existing planner. A blank one has been created.");
            try {
                userPlanner.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }

        }


        System.out.println("There are various commands you can choose from.");
        System.out.println("Press 1 to create a task");
        System.out.println("Press 2 to see a list on today's tasks");
        System.out.println("Press 3 to complete a task");
        System.out.println("Press 4 to delete a task");
        System.out.println("Press 5 for settings");
        System.out.println("Press 0 to quit");
        int input = getInput.getInt();

        switch(input){
            case 1:
                Task.addTask(user);
                Execute(user);

            case 2:
                Task.printCurrentDayTask(user);
                Execute(user);

            case 3:
                Task.printTasks(user);
                Execute(user);

            case 4:

            case 5:
            case 0:
            default :
                System.out.println("Invalid input");
                Execute(user);
        }



    }

}
