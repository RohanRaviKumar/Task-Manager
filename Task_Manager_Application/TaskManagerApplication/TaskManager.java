package TaskManagerApplication;

public class TaskManager {
    public String UID, pwd, taskTitle, label, deadline;

    public TaskManager() {
    }

    public TaskManager(String uid, String p, String t, String l, String d) {
        this.UID = uid;
        this.pwd = p;
        this.taskTitle = t;
        this.label = l;
        this.deadline = d;
    }

    public void fullDisplay() {
        System.out.println("Task Title     :     " + taskTitle);
        System.out.println("Label          :     " + label);
        System.out.println("Days left      :     " + daysLeft());
    }

    public String getTitle() {
        return taskTitle;
    }

    public String getLabel() {
        return label;
    }

    public void assign(String uid, String p, String t, String l, String d) {
        this.UID = uid;
        this.pwd = p;
        taskTitle = t;
        label = l;
        deadline = d;
    }

    public int daysLeft() {
        TimeRemainingToCompleteTask t = new TimeRemainingToCompleteTask();
        return t.noOfDays(deadline);
    }

    public String getDeadline() {
        return deadline;
    }

    public void updateDeadline(String newDeadline) {
        this.deadline = newDeadline;
    }

    public String getUID() {
        return UID;
    }

    public String getPwd() {
        return pwd;
    }
}
