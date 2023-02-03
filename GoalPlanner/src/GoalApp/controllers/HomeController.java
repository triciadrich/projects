package GoalApp.controllers;

import GoalApp.data.UserData;
import GoalApp.model.User;
import com.mysql.cj.x.protobuf.MysqlxCursor;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeController {
    static ArrayList<Object> thisUser = new ArrayList<>();
    static LifeAreaController life = new LifeAreaController();
    static GoalMenuController gm = new GoalMenuController();
    static HabitMenuController hm = new HabitMenuController();
    User user = new User();
    UserData userData = new UserData();
    String name;
    String email;
    String password;
    static Scanner scn = new Scanner(System.in);
    static boolean exit;
    static int option;


    public void welcome(){
        while(!exit){
            System.out.println("Welcome to your goal planner choose an option");
            System.out.println("1: Register");
            System.out.println("2: Login");
            System.out.println("3: I don't want to set goals");
            option = scn.nextInt();
            scn.nextLine();
            switch (option){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }

    public void register(){


            System.out.println("Enter name");
            name = scn.nextLine();
            System.out.println("Enter email");
            email  = scn.nextLine();
            System.out.println("Enter password");
            password = scn.nextLine();

        userData.createUser(name,email,password);



        login();
    }

    public ArrayList<Object> login() {
        String userName;
        String pwd;
        System.out.println("Enter name");
        userName = scn.nextLine();
        System.out.println("Enter password");
        pwd = scn.nextLine();
       if((userData.validateUser(userName,pwd).get(0) == "invalid")){
           System.out.println("Invalid");

           welcome();
       }else {
           thisUser.add(0,userData.validateUser(userName,pwd).get(0));
           thisUser.add(1,userData.validateUser(userName,pwd).get(1));
            dashBoardMenu();
           return thisUser;
       }

       return null;
    }
    public static ArrayList<Object> getThisUser(){
        return thisUser;
    }

    public static void dashBoardMenu(){
        while(!exit){
            System.out.println("Welcome "  + thisUser.get(1) + " to your goal planner choose an option");
            System.out.println("1: Life Area Assesment");
            System.out.println("2: Goals");
            System.out.println("3: Habits");
            System.out.println("4: Exit");
            option = scn.nextInt();
            scn.nextLine();
            switch (option){
                case 1:
                    life.lifeMenu();
                    break;
                case 2:
                    gm.goalMenu();
                    break;
                case 3:
                    hm.habitMenu();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }
}
