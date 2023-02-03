package GoalApp.model;

import java.util.Date;

public class Task {
        private int id;
        private String name;
        private Date dueDate;
        private Date created;
        private boolean complete;
        private Goal goal;


        public Task(int id, String name, Date dueDate, Date created, boolean complete, Goal goal) {
                this.id = id;
                this.name = name;
                this.dueDate = dueDate;
                this.created = created;
                this.complete = complete;
                this.goal = goal;
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

        public Date getDueDate() {
                return dueDate;
        }

        public void setDueDate(Date dueDate) {
                this.dueDate = dueDate;
        }

        public Date getCreated() {
                return created;
        }

        public void setCreated(Date created) {
                this.created = created;
        }

        public boolean isComplete() {
                return complete;
        }

        public void setComplete(boolean complete) {
                this.complete = complete;
        }

        public Goal getGoal() {
                return goal;
        }

        public void setGoal(Goal goal) {
                this.goal = goal;
        }
}
