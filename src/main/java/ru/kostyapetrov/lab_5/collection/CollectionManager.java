package ru.kostyapetrov.lab_5.collection;


import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionManager {

    ArrayList<Integer> listUniqueId;
    LinkedList<Product> collect;
    LinkedList<String> historyCommand=new LinkedList<>();
    public CollectionManager(){}
//getter and setter product collection
    public LinkedList<Product> getCollection(){

        return collect;

    }

    public void setCollection(LinkedList<Product> collect){

        this.collect=collect;
    }

//Getter and setter collection with unique id
    public ArrayList<Integer> getUniqueId(){
        return listUniqueId;
    }
    public void setUniqueId(ArrayList<Integer> listUniqueId){
        this.listUniqueId=listUniqueId;
    }

//getter and setter for collection command
    public LinkedList<String> getHistoryCommand(){
        return historyCommand;
    }
    public void setCommand(String command){
//only the last 15 commands are stored, so there is a check
        if(historyCommand.size()<15){
            historyCommand.add(command);
        }else{
            historyCommand.removeFirst();
            historyCommand.add(command);
        }
    }
}