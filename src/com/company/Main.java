//David Semchishin
//Java Project 3
//4/13/2023

package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        ArrayList<Task> myList = new ArrayList<Task>();
        try {
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List all tasks.");
            System.out.println("(5) Find by priority");
            System.out.println("(0) Exit.");
            System.out.println("Please make your choice: ");

            int userInput = input.nextInt();
            input.nextLine();


            while (true) {
                if (userInput == 1) {
                    addTask(myList);

                } else if (userInput == 2) {
                    removeTask(myList);

                } else if (userInput == 3) {
                    updateTask(myList);

                } else if (userInput == 4) {
                    Collections.sort(myList);
                    System.out.println(myList);

                } else if (userInput == 0) {
                    System.exit(0);
                } else if (userInput == 5) {
                    prioCheck(myList);
                }


                System.out.println("Please make your choice: ");
                userInput = input.nextInt();
                input.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Sorry, there was an error in your code somewhere!");
        }
    }
    static ArrayList<Task> addTask(ArrayList<Task> a) {
        System.out.println("Please enter the title of the task you'd like to add: ");
        String title = input.nextLine();

        System.out.println("Please enter the description of the task you'd like to add: ");
        String description = input.nextLine();

        System.out.println("Please enter the priority of the task you'd like to add: ");
        int priority = input.nextInt();

        input.nextLine();

        Task aNewTask = new Task(title, description, priority);

        a.add(aNewTask);
        return a;
    }

    static ArrayList<Task> removeTask(ArrayList<Task> a) {
        System.out.println("Please enter the index of the task you'd like to remove: ");
        String task = input.nextLine();
        a.remove(Integer.parseInt(task));
        return a;
    }

    static ArrayList<Task> updateTask(ArrayList<Task> a) {
        System.out.println("What index would you like to replace: ");
        int ind = input.nextInt();
        input.nextLine();

        System.out.println("Please enter the title of the task you'd like to add: ");
        String title = input.nextLine();

        System.out.println("Please enter the description of the task you'd like to add: ");
        String description = input.nextLine();

        System.out.println("Please enter the priority of the task you'd like to add: ");
        int priority = input.nextInt();

        input.nextLine();

        Task aNewTask = new Task(title, description, priority);

        a.set(ind, aNewTask);
        return a;
    }

    static ArrayList<Task> prioCheck(ArrayList<Task>tasks){
        System.out.println("What priority task do you want to find?");
        for(Task item:tasks){
            int userInput = input.nextInt();
            int prio = item.getPriority();
            if(prio == userInput){
                System.out.println(item);
            }
        }
        return tasks;
    }
}

class Task implements Comparable<Task>, Iterable<Task>{
    private String title;
    private String description;
    private int priority;

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        int compareResult = this.title.compareTo(o.title);


        if(compareResult==0){
            if(this.priority< o.priority){
                return -1;
            }
        }
        return compareResult;
    }

    @Override
    public Iterator<Task> iterator() {
        return this.iterator();
    }
}