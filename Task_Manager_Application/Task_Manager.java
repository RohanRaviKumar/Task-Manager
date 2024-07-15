import java.util.*;
import java.io.*;
import java.time.*;
import TaskManagerApplication.*;

class Task_Manager{

    public static void writeToFilePersonal(ArrayList<Personal> per){
        try {
            FileWriter myWriter = new FileWriter("Personal.txt");
            for (Personal p : per){
                myWriter.write(p.toString());
            }
            myWriter.close();
        }
        
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Personal> readFromFilePersonal(){
        try {
            File myObj = new File("Personal.txt");
            ArrayList<Personal> per = new ArrayList<>();
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                per.add(new Personal(data));
            }
            myReader.close();
            return per;
        }
            
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToFileProfessional(ArrayList<Professional> pro){
       try {
            FileWriter myWriter = new FileWriter("Professional.txt");
            for (Professional p : pro){
                myWriter.write(p.toString());
            }
            myWriter.close();
        }
        
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Professional> readFromFileProfessional(){
        try {
            File myObj = new File("Professional.txt");
            ArrayList<Professional> pro = new ArrayList<>();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                pro.add(new Professional(data));
            }

            myReader.close();
            return pro;
        }
          
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        System.out.println("WELCOME USER !!!\n");
		Scanner in = new Scanner(System.in);

		int choice=1, typeChoice=0, y=1, reg=1;
		String buff;
		TimeRemainingToCompleteTask t = new TimeRemainingToCompleteTask();

        ArrayList<Personal> per = new ArrayList<>();
        ArrayList<Professional> pro = new ArrayList<>();

        String uid="", pwd="";
        int logChoice = 1;

        per = readFromFilePersonal();
        pro = readFromFileProfessional();
        int check = 0;

        for (int i=0; i<3; i++){
            System.out.print("Enter username : ");
            uid = in.nextLine();

            System.out.print("Enter password : ");
            pwd = in.nextLine();


            for (Personal p : per){
                if (p.getUID().equals(uid) && p.getPwd().equals(pwd)){
                    check = 1;
                }
            }

            for (Professional p : pro){
                if (p.getUID().equals(uid) && p.getPwd().equals(pwd)){
                    check = 1;
                }
            }

            if (check == 0){
                System.out.print("\nLogin not found. Do you want to\n1) Login again\n2) Register\nEnter choice : ");
                // buff = in.nextLine();
                logChoice = in.nextInt();
                System.out.println("\n");
                buff = in.nextLine();
                if (logChoice == 2){
                    i=3;
                }
            }

            else{
                break;
            }

        }


        if (logChoice == 2){
            //Register

            System.out.print("Let's get started with your login ID and password\n\nEnter you login ID : ");
            uid = in.nextLine();

            System.out.print("Enter your password : ");
            pwd = in.nextLine();

            System.out.print("\nYou have successfully created an account. Now add your first task to proceed\n\nEnter type of task to add\n1) Personal\n2) Professional\nEnter your choice : ");
            typeChoice = in.nextInt();
            System.out.println();
            buff = in.nextLine();

            if (typeChoice != 1 && typeChoice != 2){
                System.out.println("Invalid task type chosen. Try again\n");
            }

            String title, l, des, dd;
            int diff, imp;

            if (typeChoice == 1){

                System.out.println("==============================================\n                 PERSONAL TASK\n==============================================");

                System.out.print("Enter task title : ");
                title = in.nextLine();

                System.out.print("Enter label : ");
                l = in.nextLine();

                System.out.print("Enter deadline (in YYYY-MM-DD format) : ");
                dd = in.nextLine();

                System.out.print("Enter task description : ");
                des = in.nextLine();

                per.add(new Personal(uid, pwd, title, l, dd, des));
                System.out.println("\nPersonal task added successfully\n");
            }

            else{

                System.out.println("==============================================\n                PROFESSIONAL TASK\n==============================================");

                System.out.print("Enter task title : ");
                title = in.nextLine();

                System.out.print("Enter label : ");
                l = in.nextLine();

                System.out.print("Enter deadline (in YYYY-MM-DD format) : ");
                dd = in.nextLine();

                System.out.print("Enter task description : ");
                des = in.nextLine();

                // buff = in.nextLine();

                System.out.print("Choose task difficulty\n1) Easy\n2) Medium\n3) Hard\nEnter choice : ");
                diff = in.nextInt();

                System.out.print("Choose importance\n1) Not urgent\n2) Quite urgent\n3) Very urgent\nEnter choice : ");
                imp = in.nextInt();

                buff = in.nextLine();

                pro.add(new Professional(uid, pwd, title, l, dd, des, imp, diff));
                System.out.println("\nProfessional task added successfully\n");
            }

            check = 1;
        }

        if (check == 0){
            System.out.println("Too many login attempts terminating application\n");
        }

        if (check == 1){
            while (choice!=0){
                System.out.print("\n\n=========================================\n              OPERATIONS\n=========================================\n\nEnter which operation you want to perform\n\n1) Add tasks\n2) View all your tasks\n3) View your pending tasks\n4) Update your tasks\n5) Check off tasks\n6) Logout\n\nEnter choice : ");
                choice = in.nextInt();
                in.nextLine();

                if (choice == 1){
                    System.out.print("\nEnter which type of tasks you want to add\n1) Personal\n2) Professional\n");
                    typeChoice = in.nextInt();
                    buff = in.nextLine();
                    System.out.println();

                    if (typeChoice != 1 && typeChoice != 2){
                        System.out.println("Invalid task type chosen. Try again\n");
                        continue;
                    }

                    String title, l, des, dd;
                    int diff, imp;

                    if (typeChoice == 1){

                        System.out.println("==============================================\n                 PERSONAL TASK\n==============================================");

                        System.out.print("Enter task title : ");
                        title = in.nextLine();

                        System.out.print("Enter label : ");
                        l = in.nextLine();

                        System.out.print("Enter deadline (in YYYY-MM-DD format) : ");
                        dd = in.nextLine();

                        System.out.print("\nEnter task description : ");
                        des = in.nextLine();

                        per.add(new Personal(uid, pwd, title, l, dd, des));
                        System.out.println("Personal task added successfully\n");
                    }

                    else{

                        System.out.println("==============================================\n                PROFESSIONAL TASK\n==============================================");

                        System.out.print("Enter task title : ");
                        title = in.nextLine();

                        System.out.print("Enter label : ");
                        l = in.nextLine();

                        System.out.print("Enter deadline (in YYYY-MM-DD format) : ");
                        dd = in.nextLine();

                        System.out.print("\nEnter task description : ");
                        des = in.nextLine();

                        // buff = in.nextLine();

                        System.out.print("Choose task difficulty\n1) Easy\n2) Medium\n3) Hard\nEnter choice : ");
                        diff = in.nextInt();

                        System.out.print("Choose importance\n1) Not urgent\n2) Quite urgent\n3) Very urgent\nEnter choice : ");
                        imp = in.nextInt();

                        buff = in.nextLine();

                        pro.add(new Professional(uid, pwd, title, l, dd, des, imp, diff));
                        System.out.println("Professional task added successfully\n");
                    }
                }

                else if (choice == 2){

                    int num = 0;

                    for (Personal p : per){
                        if (uid.equals(p.getUID()) && pwd.equals(p.getPwd())){
                            num++;
                        }
                    }

                    if (num > 0){
                        System.out.println("=============================================\n                Personal tasks\n=============================================");
                        for (int i=0; i<per.size(); i++){
                            if (uid.equals(per.get(i).getUID()) && pwd.equals(per.get(i).getPwd())){
                                per.get(i).fullDisplay();
                                System.out.println("\n");
                            }
                        }
                    }

                    else{
                        System.out.println("\nPersonal tasks tab is empty");
                    }

                    int num2 = 0;

                    for (Professional p : pro){
                        if (uid.equals(p.getUID()) && pwd.equals(p.getPwd())){
                            num2++;
                        }
                    }

                    if (num2 > 0){
                        System.out.println("=============================================\n              Professional tasks\n=============================================");
                        for (int i=0; i<pro.size(); i++){
                            if (uid.equals(pro.get(i).getUID()) && pwd.equals(pro.get(i).getPwd())){
                                pro.get(i).fullDisplay();
                                System.out.println("\n");
                            }
                        }
                    }

                    else{
                        System.out.println("\nProfessional tasks tab is empty");
                    }
                    
                }

                else if (choice == 3){

                    int num = 0;

                    for (Personal p : per){
                        if (uid.equals(p.getUID()) && pwd.equals(p.getPwd())){
                            num++;
                        }
                    }

                    if (num > 0){
                        System.out.println("=======================================\n       Personal tasks (pending)\n=======================================");
                        for (int i=0; i<per.size(); i++){
                            if (uid.equals(per.get(i).getUID()) && pwd.equals(per.get(i).getPwd())){
                                per.get(i).pendingTasks();
                            }
                        }
                    }

                    else{
                        System.out.println("\nPersonal tasks tab is empty");
                    }
                    
                    int num2 = 0;

                    for (Professional p : pro){
                        if (uid.equals(p.getUID()) && pwd.equals(p.getPwd())){
                            num2++;
                        }
                    }

                    if (num2 > 0){
                        System.out.println("=======================================\n      Professional tasks (pending)\n=======================================");
                        for (int i=0; i<pro.size(); i++){
                            if (uid.equals(pro.get(i).getUID()) && pwd.equals(pro.get(i).getPwd())){
                                pro.get(i).pendingTasks();
                            }
                        }
                    }

                    else{
                        System.out.println("\nProfessional tasks tab is empty");
                    }
                    
                }

                else if (choice == 4) {

                    System.out.print("\nEnter which type of task you want to update\n1) Personal\n2) Professional\n");
                    typeChoice = in.nextInt();
                    buff = in.nextLine();

                    if (typeChoice == 1 && per.size() > 0) {
                        int num = 0;

                        for (Personal p : per){
                            if (uid.equals(p.getUID()) && pwd.equals(p.getPwd())){
                                num++;
                            }
                        }

                        if (num > 0){
                            System.out.println("==============================================\n                 Personal tasks\n==============================================");
                            for (int i=0; i<per.size(); i++){
                                if (uid.equals(per.get(i).getUID()) && pwd.equals(per.get(i).getPwd())){
                                    per.get(i).fullDisplay();
                                    System.out.println("\n");
                                }
                            }
                            
                            per.get(0).updateTasks(per,uid,pwd);
                        }

                        else{
                            System.out.println("\nPersonal tasks tab is empty");
                        }

                        
                    }
                    
                    else if (typeChoice == 2 && pro.size() > 0){
                        int num = 0;

                        for (Personal p : per){
                            if (uid.equals(p.getUID()) && pwd.equals(p.getPwd())){
                                num++;
                            }
                        }

                        if (num > 0){
                            System.out.println("==============================================\n               Professional tasks\n==============================================");
                            for (int i=0; i<pro.size(); i++){
                                if (uid.equals(pro.get(i).getUID()) && pwd.equals(pro.get(i).getPwd())){
                                    pro.get(i).fullDisplay();
                                    System.out.println("\n");
                                }
                            }
                            
                            pro.get(0).updateTasks(pro,uid,pwd);
                        }

                        else{
                            System.out.println("\nPersonal tasks tab is empty");
                        }
                        
                    }

                    else{
                        System.out.println("Your task tab is empty. Add tasks\n");
                    }
                }

                else if (choice == 5){
                    System.out.print("Enter which type of tasks you want to check off\n1) Personal\n2) Professional\n");
                    typeChoice = in.nextInt();
                    buff = in.nextLine();

                    if (typeChoice != 1 && typeChoice != 2){
                        System.out.println("Invalid task type chosen. Try again\n");
                        continue;
                    }

                    else if (typeChoice == 1){

                        int num = 0;

                        for (Personal p : per){
                            if (p.getUID().equals(uid) && p.getPwd().equals(pwd)){
                                num++;
                            }
                        }

                        if (num>0){
                            System.out.println("==============================================\n                 Personal tasks\n==============================================");
                            for (int i=0; i<per.size(); i++){
                                if (uid.equals(per.get(i).getUID()) && pwd.equals(per.get(i).getPwd())){
                                    per.get(i).fullDisplay();
                                    System.out.println("\n");
                                }
                            }
                            
                            String ti, la;
                            System.out.print("Enter the task title which you want to check off : ");
                            ti = in.nextLine();

                            System.out.print("Enter the task label which you want to check off : ");
                            la = in.nextLine();
                            int f = 0;

                            for (int i=0; i<per.size(); i++){
                                if (per.get(i).getUID().equals(uid) && per.get(i).getPwd().equals(pwd) && per.get(i).getTitle().equals(ti) && per.get(i).getLabel().equals(la)){
                                    per.remove(i);
                                    f = 1;
                                    System.out.println("\nTask checked off successfully");
                                    break;
                                }
                            }

                            if (f == 0){
                                System.out.println("\nProfessional task not found");
                            }
                        }

                        else{
                            System.out.println("\nNo personal tasks found");
                        }
                    }

                    else if (typeChoice == 2){

                        int num = 0;

                        for (Professional p :pro){
                            if (p.getUID().equals(uid) && p.getPwd().equals(pwd)){
                                num++;
                            }
                        }

                        if (num > 0){
                            System.out.println("==============================================\n              Professional tasks\n==============================================");
                            for (int i=0; i<pro.size(); i++){
                                if (uid.equals(pro.get(i).getUID()) && pwd.equals(pro.get(i).getPwd())){
                                    pro.get(i).fullDisplay();
                                    System.out.println("\n");
                                }
                            }

                            String ti, la;
                            System.out.print("Enter the task title which you want to check off : ");
                            ti = in.nextLine();

                            System.out.print("Enter the task label which you want to check off : ");
                            la = in.nextLine();
                            int f = 0;
                            for (int i=0; i<pro.size(); i++){
                                if (pro.get(i).getUID().equals(uid) && pro.get(i).getPwd().equals(pwd) && pro.get(i).getTitle().equals(ti) && pro.get(i).getLabel().equals(la)){
                                    pro.remove(i);
                                    f = 1;
                                    System.out.println("\nTask checked off successfully");
                                    break;
                                }
                            }

                            if (f == 0){
                                System.out.println("\nProfessional task not found");
                            }
                        }

                        else{
                            System.out.println("\nNo professional tasks found");
                        }
                        
                    }
                }

                else{
                    System.out.println("\nEducation is the most powerful weapon which you can use to change the World !!!\n");
                    break;
                }
            }

            writeToFilePersonal(per);
            writeToFileProfessional(pro);
        }
    }
}