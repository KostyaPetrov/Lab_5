package ru.kostyapetrov.lab_5.collection;


import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionManager {

   // LinkedList<String> collect=new LinkedList<>();

//collet.createElementCollection()
    //LinkedList<String> collec = new LinkedList<>();
    ArrayList<Integer> listUniqueId;
    LinkedList<Product> collect;
    LinkedList<String> historyCommand=new LinkedList<>();
    public CollectionManager(){

    }
    public LinkedList<Product> getCollection(){

        return collect;

    }

    public void setCollection(LinkedList<Product> collect){

        this.collect=collect;
    }

    public ArrayList<Integer> getUniqueId(){
        return listUniqueId;
    }
    public void setUniqueId(ArrayList<Integer> listUniqueId){
        this.listUniqueId=listUniqueId;
    }


    public LinkedList<String> getHistoryCommand(){
        return historyCommand;
    }
    public void setCommand(String command){
        if(historyCommand.size()<15){
            historyCommand.add(command);
        }else{
            historyCommand.removeFirst();
            historyCommand.add(command);
        }
    }
}


//        ArrayList<Integer> listUniqueId=new ArrayList<>();
//        LinkedList<Product> collect=new LinkedList<>();
//        this.listUniqueId=listUniqueId;
//        this.collect=collect;