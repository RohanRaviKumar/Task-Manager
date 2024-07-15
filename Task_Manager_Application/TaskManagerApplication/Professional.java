package TaskManagerApplication;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Professional extends TaskManager implements Operations, Serializable {
    public String description = "";
    public int importance;
    public int difficulty;
    private static final long serialVersionUID = 1L;

    public Professional() {
    }

    public Professional(String uid, String p, String t, String l, String dead, String d, int i, int diff) {
        super(uid, p, t, l, dead);
        description = d;
        importance = i;
        difficulty = diff;
    }

    @Override
    public String toString() {
        return (getUID() + "|" + getPwd() + "|" + getTitle() + "|" + getLabel() + "|" + getDeadline() + "|" + description
                + "|" + difficulty + "|" + importance + "\n");
    }

    public Professional(String allData) {
        int i = 0;
        String u = "", p = "", t = "", l = "", d = "", diff = "", urg = "";

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

        while (allData.charAt(i) != '|') {
            description = description + allData.charAt(i);
            i++;
        }
        i++;

        while (allData.charAt(i) != '|') {
            diff = diff + allData.charAt(i);
            i++;
        }
        i++;

        while (i < allData.length()) {
            urg = urg + allData.charAt(i);
            i++;
        }
        i++;

        assign(u, p, t, l, d);
        importance = Integer.parseInt(urg);
        difficulty = Integer.parseInt(diff);
    }

    public void pendingTasks() {

        if (daysLeft() < 0){
                System.out.println("* TASK " + getTitle() + " PAST DEADLINE\n\n");
        }
        else if ((difficulty == 1 && daysLeft() < 5) || (difficulty == 2 && daysLeft() < 7) || (difficulty == 3 && daysLeft() < 10)) {
            System.out.print("* Task : " + getTitle() + "\n  Days left : " + daysLeft() + "\n");
        }
    }

    public void fullDisplay() {
        super.fullDisplay();
        System.out.println("Description    :     " + description);

        if (difficulty == 1) {
            System.out.println("Difficulty     :     Easy");
        } else if (difficulty == 2) {
            System.out.println("Difficulty     :     Medium");
        } else {
            System.out.println("Difficulty     :     Hard");
        }

        if (importance == 1) {
            System.out.println("Importance     :     Not urgent");
        } else if (importance == 2) {
            System.out.println("Importance     :     Quite urgent");
        } else if (importance == 3) {
            System.out.println("Importance     :     Very urgent");
        }
    }

    public void updateTasks(ArrayList<Professional> pro, String uid, String pwd) {
        if (pro.size() == 0) {
            System.out.println("No professional tasks to update.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the task title to update deadline: ");
        String taskTitleToUpdate = in.nextLine();

        System.out.print("Enter task label : ");
        String taskLabel = in.nextLine();

        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getTitle().equals(taskTitleToUpdate) && pro.get(i).getLabel().equals(taskLabel)
                    && pro.get(i).getUID().equals(uid) && pro.get(i).getPwd().equals(pwd)) {
                System.out.print("Enter the new deadline (in YYYY-MM-DD format): ");
                String newDeadline = in.nextLine();
                pro.get(i).updateDeadline(newDeadline);
                System.out.println("Deadline updated successfully!");
                return; // Exit the loop once the task is found and updated
            }
        }

        System.out.println("Task not found. Please check the task title.");
    }
}
