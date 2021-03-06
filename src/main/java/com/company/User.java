package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    String userName;
    String password;
    Settings setting;


    private User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
        this.setting = new Settings();
    }


    public static void addUser(User newUser) throws IOException {
        File users = new File("users.txt");
        boolean exists = users.exists();

        if (!exists) {
            try {
                users.createNewFile();

            } catch (IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }

        }

        FileWriter myWriter = new FileWriter("users.txt", true);
        myWriter.write(newUser.userName + " " + newUser.password+ " " + newUser.setting.autoSchedule+"\n");
        myWriter.close();
    }

    public static User createUser()
    {
        String userName;
        String passWord;
        System.out.println("Please enter a username");
        userName = getInput.getString();
        System.out.println("Please enter a password");
        passWord = getInput.getString();

        return (new User(userName, passWord));
    }


    // scan usernames and passwords exclusivly
    public static User checkExists() throws FileNotFoundException {
        String userName;
        String passWord;

        System.out.println("Please enter a username");
        userName = getInput.getString();
        System.out.println("Please enter a password");
        passWord = getInput.getString();


        File users = new File("users.txt");
        boolean exists = users.exists();
        if (!exists) return null;

        else
        {
            final Scanner scanner = new Scanner(users);
            while (scanner.hasNextLine())
            {
                final String lineFromLine = scanner.nextLine();
                if(lineFromLine.contains(userName + " "))
                {
                    if(lineFromLine.contains(passWord))
                    {
                        User toReturn = new User(userName, passWord);
                        toReturn.setting.autoSchedule = Boolean.parseBoolean(lineFromLine.split(" ")[2]);
                        return (toReturn);
                    }
                    else return null;
                }
            }
        }
        return null;
    }


}
