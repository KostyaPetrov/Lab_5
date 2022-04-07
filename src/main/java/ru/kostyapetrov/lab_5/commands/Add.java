package commands;
import collection.Product;
import console.*;
import collection.CollectionManager;

import java.util.LinkedList;

public class Add implements Commandable{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    public Add(CollectionManager collectionManager, ConsoleManager consoleManager) {
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){

        Product element = new Product();
        //CollectionManager collectionManager = new CollectionManager();

        LinkedList<Product> oldCollection = new LinkedList<>(collectionManager.getNewCollection());
        oldCollection.add(element.createElementCollection());
        collectionManager.newCollection(oldCollection);



        //ConsoleManager consoleManager=new ConsoleManager();
        consoleManager.getCommand();



    }

}