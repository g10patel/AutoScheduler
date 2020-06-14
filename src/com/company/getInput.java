package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class getInput {

    public static int getUserType()
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        if(a != 1 && a != 2)
        {
            return -1;
        }

        return a;

    }

    public static String getString()

    {
        Scanner in = new Scanner(System.in);
        String ret = in.nextLine();

        return ret;
    }

    public static int getInt()
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        if(a<1)
        {

            return -1;
        }
        return a;
    }

    public static Date getDate() throws Exception
    {
        String dateString = getString();
        Date date = new SimpleDateFormat("YYYY/MM/DD").parse(dateString);
        return date;
    }

    public static LocalTime getTime()
    {
        LocalTime time;
        String timeString = getString();
        time = LocalTime.parse(timeString);
        return time;
    }

    public static StringBuilder getFile(User user) throws Exception
    {
        StringBuilder tasks = new StringBuilder();
        try {
            File myObj = new File(user.userName + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                tasks.append(myReader.nextLine());
            }
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return tasks;
    }




}
