package TaskManagerApplication;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Personal extends TaskManager implements Operations, Serializable {
    private static final long serialVersionUID = 1L;
    public String description = "";
    public int i = 0;

    public Personal() {
    }

    public Personal(String uid, String p, String t, String l, String date, String d) {
        super(uid, p, t, l, date);
        description = d;
    }

    public Personal(String allData) {
        String u = "", p = "", t = "", l = "", d = "";

        while (allData.charAt(i) != '|') {
            u = u + allData.charAt(i);
            i++;
        }
        i++;

        while (allData.charAt(i) != '|') {
            p = p + allData.charAt(i);
            i++;
        }
        i++;

        while (allData.charAt(i) != '|') {
            t = t + allData.charAt(i);
            i++;
        }
        i++;

        while (allData.charAt(i) != '|') {
            l = l + allData.charAt(i);
            i++;
        }
        i++;

        while (allData.charAt(i) != '|') {
            d = d + allData.charAt(i);
            i++;
        }
        i++;
        while (i < allData.length()) {
            description = description + allData.charAt(i);
            i++;
        }

        assign(u, p, t, l, d);
    }

    @Override
    public String toString() {
        return (getUID() + "|" + getPwd() + "|" + getTitle() + "|" + getLabel() + "|" + getDeadline() + "|" + description
                + "\n");
    }

    public void pendingTasks() {

        if (daysLeft() < 0){
            System.out.print("* TASK : " + getTitle() + " PAST DEADLINE\n\n");
        }

        else if (daysLeft() < 2) {
            System.out.print("* Task : " + getTitle() + "\n  Days left : " + daysLeft() + "\n");
        }
    }

    public void fullDisplay() {
        super.fullDisplay();
        System.out.println("Description    :     " + description);
    }

    public void updateTasks(ArrayList<Personal> per, String uid, String pwd) {
        if (per.size() == 0) {
            System.out.println("No personal tasks to update.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the task title to update deadline: ");
        String taskTitleToUpdate = in.nextLine();

        System.out.print("Enter task label : ");
        String taskLabel = in.nextLine();

        for (int i = 0; i < per.size(); i++) {
            if (per.get(i).getTitle().equals(taskTitleToUpdate) && per.get(i).getLabel().equals(taskLabel)
                    && per.get(i).getUID().equals(uid) && per.get(i).getPwd().equals(pwd)) {
                System.out.print("Enter the new deadline (in YYYY-MM-DD format): ");
                String newDeadline = in.nextLine();
                per.get(i).updateDeadline(newDeadline);
                System.out.println("Deadline updated successfully!");
                return; // Exit the loop once the task is found and updated
            }
        }

        System.out.println("Task not found. Please check the task title.");
    }
}
