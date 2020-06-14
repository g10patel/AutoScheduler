package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    String userName;
    String password;

    private User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }


    public static void addUser(User newUser)
    {
        File users = new File("users.txt");
        boolean exists = users.exists();

        if (exists == false)
        {
            try {
                users.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("An error occurred");
                e.printStackTrace();
            }

        }
        
        else
        {
            try
            {
                FileWriter myWriter = new FileWriter("users.txt", true);
                myWriter.write(newUser.userName + " " + newUser.password+"\n");
                myWriter.close();
            }
            catch (IOException e)
            {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        }
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

    // TODO
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
        if (exists == false) return null;

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
                        return (new User(userName, passWord));
                    }
                    else return null;
                }
            }

        }
        return null;
    }


}
