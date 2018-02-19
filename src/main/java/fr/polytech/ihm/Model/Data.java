package fr.polytech.ihm.Model;

import java.util.ArrayList;

public class Data {
    private static Data ourInstance = new Data();
    private ArrayList<Task> tasks;
    private int lastId=0;

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        //test tasks
        this.tasks=new ArrayList<Task>();
    }

    public static void addTask(String title,String author,String assignee,String category,String date,String location,String description,int upvote, int emergency){
        ourInstance.tasks.add(
                new Task(ourInstance.lastId+1,title,author,assignee,category,date,location,description,0,emergency)
        );
    }

    public static Task getById(int id){
        for(Task t : ourInstance.tasks){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }
}
