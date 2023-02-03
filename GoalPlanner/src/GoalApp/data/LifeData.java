package GoalApp.data;

import GoalApp.controllers.HomeController;

import java.sql.*;
import java.util.ArrayList;

public class LifeData {
    static UserData ud = new UserData();
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static PreparedStatement preparedStatement;







    public ArrayList<Object> getLifeAreas() {
        ArrayList<Object> areas = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/goalplanner?" +
                    "user=root&password=root" +
                    "&useSSL=false&allowPublicKeyRetrieval=true");

            preparedStatement = connection.prepareStatement("select * from goalplanner.lifearea where user_id = ?");
            preparedStatement.setObject(1,HomeController.getThisUser().get(0));

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                areas.add(resultSet.getString("name"));
                areas.add(resultSet.getInt("score"));
            }

        } catch (SQLException sqle) {
            System.out.println("Exception occured");
            sqle.printStackTrace();
        } catch (ClassNotFoundException classe) {
            System.out.println("Exception occured - driver not found on classpath");
            classe.printStackTrace();

        } finally {
            try {

                connection.close();
            } catch (SQLException esql) {
                esql.printStackTrace();
            }
        }
        return areas;


    }

    public void updateLifeArea(ArrayList<Object> lifearea) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/goalplanner?" +
                    "user=root&password=root" +
                    "&useSSL=false&allowPublicKeyRetrieval=true");
            preparedStatement = connection.
                    prepareStatement("update goalplanner.lifearea set score = ? where name = ? AND where user_id = ?");
            preparedStatement.setObject(1, lifearea.get(1));
            preparedStatement.setObject(2, lifearea.get(0));
            preparedStatement.setObject(3,HomeController.getThisUser().get(0));

            int x = preparedStatement.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Exception occured");
            sqle.printStackTrace();
        } catch (ClassNotFoundException classe) {
            System.out.println("Exception occured - driver not found on classpath");
            classe.printStackTrace();
        } finally {
            try {

                connection.close();
            } catch (SQLException esql) {
                esql.printStackTrace();
            }
        }


    }

}