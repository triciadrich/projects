package GoalApp.data;

import GoalApp.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserData {
    User u = new User();
    static LifeData life = new LifeData();



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
            preparedStatement = connection.
                    prepareStatement("insert into  goalplanner.user (username, email, password) values (?, ?,?)");

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, passWord);

            int x = preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("select * from user where username = ? AND email = ?");
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,email);



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


    public ArrayList<Object> validateUser(String un, String pwd){
        ArrayList<Object> curentUser = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/goalplanner?" +
                    "user=root&password=root" +
                    "&useSSL=false&allowPublicKeyRetrieval=true");
            preparedStatement = connection.
                    prepareStatement("select * from goalplanner.user where username = ? AND password = ?;");
            preparedStatement.setString(1, un);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                if (resultSet.wasNull()){
                    curentUser.add("invalid");
                }else
                    curentUser.add(resultSet.getInt("userId"));
                    curentUser.add(resultSet.getString("username"));
                    curentUser.add(resultSet.getString("email"));
                    curentUser.add(resultSet.getString("password"));

            }

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
        return curentUser;



    }





























//    public void userDb(){
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/goalplanner?" +
//                    "user=root&password=root" +
//                    "&useSSL=false&allowPublicKeyRetrieval=true");
//            statement = connection.createStatement();
//
//            resultSet = statement.executeQuery("select * from goalplanner.user;");
//
//
//            // call method to map ResultSet to ArrayList of objects
//            ArrayList<User> user = mapResultSetToObjects(resultSet);
//
//
//            // use a for-each loop to print out each object
//            for (User u : user){
//                System.out.println(u.toString());
//            }
//
//
//
//        }catch (SQLException sqle){
//            System.out.println("Exception occured");
//            sqle.printStackTrace();
//        }catch (ClassNotFoundException classe){
//            System.out.println("Exception occured - driver not found on classpath");
//            classe.printStackTrace();
//        }finally {
//            try {
//                statement.close();
//                connection.close();
//            }catch (SQLException esql){
//                esql.printStackTrace();
//            }
//        }
//    }
//
//    public ArrayList<User> mapResultSetToObjects(ResultSet resultSet) throws SQLException {
//
//        while (resultSet.next()) {
//            User u = new User();
//            u.setId(resultSet.getInt("userId"));
//            u.setUserName(resultSet.getString("username"));
//            u.setEmail(resultSet.getString("email"));
//            u.setPassWord(resultSet.getString("password"));
//            user.add(u);
//        }
//        return user;
//    }



}
