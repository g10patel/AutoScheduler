package com.company;

import org.joda.time.DateTime;

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
        if (input == 1)
        {
            Task.addTask(user);
        }
        if(input == 3)
        {
            Task.printTasks(user);
        }
        if(input == 0)
        {
            return;
        }



    }

}
