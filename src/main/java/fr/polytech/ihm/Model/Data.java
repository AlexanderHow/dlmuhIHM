package fr.polytech.ihm.Model;

import java.util.ArrayList;
import java.util.Date;

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
        tasks.add(new Task(1,"Test1","Quentin","Alexandre",EnumCategory.MAINTENANCE.getLibelle(),new Date().toString(),EnumLocation.E130.toString(),"Ceci est un test 1",0,1));
        tasks.add(new Task(2,"Test2","Camille","Francis",EnumCategory.UTILITAIRE.getLibelle(),new Date().toString(),EnumLocation.O201.toString(),"Ceci n'est pas un test 1",3,3));
        tasks.add(new Task(3,"Ampoule claquée","Camil","Barnabé",EnumCategory.RESSOURCE.getLibelle(),new Date().toString(),EnumLocation.AMPHIFORUM.toString(),"Ca va être tout noir",3,2));

        this.lastId=2;
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

    public ArrayList<Task> getData(){
        return ourInstance.tasks;
    }

    public ArrayList<Task> getDataToDo(){
        ArrayList<Task> td = new ArrayList<Task>();
        for(Task t : ourInstance.tasks){
            if(t.isToDo() && !t.isDisabled()){
                td.add(t);
            }
        }
        return td;
    }

    public ArrayList<Task> getDataInProgress(){
        ArrayList<Task> ip = new ArrayList<Task>();
        for(Task t : ourInstance.tasks){
            if(t.isInProgress() && !t.isDisabled()){
                ip.add(t);
            }
        }
        return ip;
    }

    public ArrayList<Task> getDataDone(){
        ArrayList<Task> r = new ArrayList<Task>();
        for(Task t : ourInstance.tasks){
            if(t.isResolved() && !t.isDisabled()){
                r.add(t);
            }
        }
        return r;
    }

    public ArrayList<Task> getDataFiltered(int state, String search, String cate ,String loc){

        ArrayList<Task> r = new ArrayList<Task>();
        for(Task t : ourInstance.tasks){
            if(!t.isDisabled() &&
                    (t.getResolvedLvl()==state) &&
                    (search.equals("") || t.getTitle().contains(search)) &&
                    (cate.equals("") || t.getCategory().equals(cate)) &&
                    (loc.equals("") || t.getLocation().equals(loc))
                    ){
                r.add(t);
            }
        }
        return r;
    }
}
