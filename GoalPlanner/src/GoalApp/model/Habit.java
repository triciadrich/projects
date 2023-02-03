package GoalApp.model;

import java.util.Date;

public class Habit {
    private int id;
    private String name;
    private Date created;
    private User user;

    public Habit(int id, String name, Date created, User user) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", user=" + user +
                '}';
    }
}
