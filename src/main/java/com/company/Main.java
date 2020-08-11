package com.company;



public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Enter 1 for an existing user and 2 for a new user");
        int userType = getInput.getUserType();
        while (userType == -1) {
            System.out.println("Invalid entry, please try again");
            System.out.println("Enter 1 for an existing user and 2 for a new user");
            userType = getInput.getUserType();
        }

        if (userType == 1) {
            User user = User.checkExists();
            if (user != null) {
                Planner.Execute(user, Planner.loadData(user));
            } else {
                while (user == null) {
                    System.out.println("Incorrect username/password");
                    System.out.println("Press 1 to create a new username and password or 2 to try again");
                    int num = getInput.getUserType();
                    if (num == 1) {
                        User newUser = User.createUser();
                        User.addUser(newUser);
                        Planner.Execute(newUser, Planner.loadData(newUser));
                        break;
                    }
                    user = User.checkExists();
                }
            }
        } else {

            User newUser = User.createUser();
            User.addUser(newUser);

            Planner.Execute(newUser, Planner.loadData(newUser));
        }

    }

}
