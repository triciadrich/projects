package GoalApp.controllers;

import GoalApp.data.GoalData;

import java.util.ArrayList;
import java.util.Scanner;

public class GoalMenuController {
    GoalData gd = new GoalData();
    boolean exit;
    int option;
    Scanner scn = new Scanner(System.in);
    public void goalMenu(){
        while(!exit){
            System.out.println("Welcome to your goal planner choose an option");
            System.out.println("1: Create Goal");
            System.out.println("2: View Goals");
            System.out.println("3: Back to main");
            System.out.println("4: exit");
            option = scn.nextInt();
            scn.nextLine();
            switch (option){
                case 1:
                    createGoal();
                    break;
                case 2:
                    viewGoals();
                    break;
                case 3:
                    HomeController.dashBoardMenu();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }

    public void createGoal(){
        ArrayList<Object> createGoal = new ArrayList<>();
        createGoal.add(HomeController.getThisUser().get(0));
        System.out.println("Enter Name of goal");
        createGoal.add(scn.nextLine());
        System.out.println("What date do you plan to complete this - date format 20230505");
        createGoal.add(scn.nextLine());
        System.out.println("What life area is this for");
        createGoal.add(scn.nextLine());
        createGoal.add(0);

        gd.createGoal(createGoal);

    }

    public void viewGoals(){

    }
}
