package com.company;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main /*extends Application*/ {
    //Button button;
    public static void main(String[] args) throws Exception {

      //  launch(args);


        System.out.println("Enter 1 for an existing user and 2 for a new user");
        int userType = getInput.getUserType();
        while (userType == -1)
        {
           System.out.println("Invalid entry, please try again");
           System.out.println("Enter 1 for an existing user and 2 for a new user");
           userType = getInput.getUserType();
        }

       if(userType == 1)
       {
           User user = User.checkExists();
           if (user != null)
           {
               Planner.Execute(user, Planner.loadData(user));
           }
           else
           {
               while (user == null)
               {
                   System.out.println("Incorrect username/password");
                   System.out.println("Press 1 to create a new username and password or 2 to try again");
                   int num = getInput.getUserType();
                   if (num == 1)
                   {
                       User newUser = User.createUser();
                       User.addUser(newUser);
                       Planner.Execute(newUser, Planner.loadData(newUser));
                       break;
                   }
                   user = User.checkExists();
               }
           }
       }
       else
       {
           
           User newUser = User.createUser();
           User.addUser(newUser);

           Planner.Execute(newUser, Planner.loadData(newUser));
       }



	// write your code here
    }

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AutoScheduler");
        button = new Button();
        button.setText("Click Me");

        button.setOnAction(e -> System.out.println("Button Pressed"));//tells button to look in this class to handle method

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }*/


}
