package GoalApp.controllers;


import GoalApp.data.LifeData;

import java.util.ArrayList;
import java.util.Scanner;

public class LifeAreaController {

    static LifeData ld = new LifeData();
    boolean exit;
    int option;
    Scanner scn = new Scanner(System.in);

    public void lifeMenu(){

            System.out.println(HomeController.getThisUser().get(1) + " This is the life areas");
            System.out.println(ld.getLifeAreas());
            while(!exit){
                System.out.println("1: Take assessment");
                System.out.println("2. go back");
                System.out.println("3. exit");
                option = scn.nextInt();
                scn.nextLine();
                switch(option){
                    case 1:
                        assessment();
                        break;
                    case 2:
                       HomeController.dashBoardMenu();
                        break;
                    case 3:
                        exit = true;
                        break;
                }
            }
    }

    public void assessment(){
        personalScore();
    }

    public ArrayList<Object> personalScore(){
        ArrayList<Object> personal = new ArrayList<>();
        int score = 0;
        personal.add("Personal");
        personal.add(score);
        ld.updateLifeArea(personal);
        System.out.println("Answer questions with a range from 1-10");
        System.out.println("My basic needs are taken care of");
        score = scn.nextInt();
        scn.nextLine();
        System.out.println("I generally feel happy and fulfilled");
        score = score + scn.nextInt();
        scn.nextLine();

        System.out.println("I have a positive attitude and outlook on life");
        score = score + scn.nextInt();
        scn.nextLine();

        System.out.println("I give myself grace for my limits and imperfections");
        score = score + scn.nextInt();
        scn.nextLine();

        System.out.println("I regularly take time for life planning, reflection, and self-care");
        score = score + scn.nextInt();
        scn.nextLine();

        System.out.println("I am comfortable spending time alone");
        score = score + scn.nextInt();
        scn.nextLine();

        System.out.println("There are hobbies and interests I engage in regularly");
        score = score + scn.nextInt();
        scn.nextLine();

        System.out.println("There are personal goals/projects that I want to achieve/complete");
        score = score + scn.nextInt();
        scn.nextLine();

        score = score / 8;
        personal.add(0,"Personal");
        personal.add(1,score);
        ld.updateLifeArea(personal);
        lifeMenu();
        return personal;
    }
}
