package collection;


import java.util.LinkedList;

public class CollectionManager {

   // LinkedList<String> collect=new LinkedList<>();

//collet.createElementCollection()
    //LinkedList<String> collec = new LinkedList<>();


    public CollectionManager(){LinkedList<Product> collect=new LinkedList<>();}
    public LinkedList<Product> getNewCollection(){

        return collect;

    }
    public void newCollection(LinkedList<String> collect){

        this.collect.addAll(collect);
    }
}