package GoalApp.data;

import java.sql.*;
import java.util.ArrayList;

public class GoalData {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static PreparedStatement preparedStatement;

    public void createGoal(ArrayList<Object> goal){
        int lifeId = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/goalplanner?" +
                    "user=root&password=root" +
                    "&useSSL=false&allowPublicKeyRetrieval=true");
            preparedStatement = connection.prepareStatement("select * from goalplanner.lifearea where name = ?"); //gets the lifearea id based on a string parameter first
            preparedStatement.setObject(1, goal.get(3));
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                lifeId = resultSet.getInt("idLifearea"); //sets the id variable
            }

            preparedStatement = connection.
                    prepareStatement("insert into  goalplanner.goal (name, estimatedCompletion, percentComplete, user_userId, LifeArea_idLifearea) values (?,?,?,?,? )"); //creates the goal

            preparedStatement.setObject(1, goal.get(1)); //goal name
            preparedStatement.setObject(2, goal.get(2));//estcompletetion
            preparedStatement.setObject(3, goal.get(4));//percentcomplete
            preparedStatement.setObject(4,goal.get(0));//userID
            preparedStatement.setInt(5,lifeId);//lifearea id

            int x = preparedStatement.executeUpdate();

        }catch (SQLException sqle){
            System.out.println("Exception occured");
            sqle.printStackTrace();
        }catch (ClassNotFoundException classe){
            System.out.println("Exception occured - driver not found on classpath");
            classe.printStackTrace();
        }finally {
            try {

                connection.close();
            }catch (SQLException esql){
                esql.printStackTrace();
            }
        }

    }
}
