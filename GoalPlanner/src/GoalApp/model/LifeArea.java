package GoalApp.model;


import java.util.Date;

public class LifeArea {
    private int id;
    private String name;
    private int score;
    private Date created;


    public LifeArea(int id, String name, int score, Date created) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.created = created;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "LifeArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", created=" + created +
                '}';
    }
}
