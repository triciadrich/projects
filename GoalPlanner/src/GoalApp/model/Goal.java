package GoalApp.model;

import java.util.Date;

public class Goal {

    private int id;
    private String name;
    private Date created;
    private Date estComp;
    private int percentComplete;
    private User user;
    private LifeArea lifeArea;

    public Goal(int id, String name, Date created, Date estComp, int percentComplete, User user, LifeArea lifeArea) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.estComp = estComp;
        this.percentComplete = percentComplete;
        this.user = user;
        this.lifeArea = lifeArea;
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

    public Date getEstComp() {
        return estComp;
    }

    public void setEstComp(Date estComp) {
        this.estComp = estComp;
    }

    public int getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LifeArea getLifeArea() {
        return lifeArea;
    }

    public void setLifeArea(LifeArea lifeArea) {
        this.lifeArea = lifeArea;
    }
}
