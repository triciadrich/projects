package GoalApp.model;

public class User {
    private int id;
    private String userName;
    private String email;
    private String passWord;


    public User(){}

    public User(int id, String userName, String email, String passWord){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
