package GoalApp.data;

import java.sql.*;

public class data {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static PreparedStatement preparedStatement;


    public void createUser(String userName, String email, String passWord){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/goalplanner?" +
                    "user=root&password=root" +
                    "&useSSL=false&allowPublicKeyRetrieval=true");
            statement = connection.createStatement();
            int x = statement.executeUpdate("INSERT INTO goalplanner.user (username, email, password) VALUES ("userName","email" ,"passWord")");
        }catch (SQLException sqle){
            System.out.println("Exception occured");
            sqle.printStackTrace();
        }catch (ClassNotFoundException classe){
            System.out.println("Exception occured - driver not found on classpath");
            classe.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (SQLException esql){
                esql.printStackTrace();
            }
        }

    }

}
