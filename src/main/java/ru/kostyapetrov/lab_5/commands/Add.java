package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;

import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.LinkedList;

public class Add implements Commandable {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private LinkedList<Product> list;
    public Add(CollectionManager collectionManager, ConsoleManager consoleManager) {
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){

       // Product element = new Product();
        //CollectionManager collectionManager = new CollectionManager();

        //LinkedList<Product> list = new LinkedList<>();
       // oldCollection.add(element.createElementCollection());
       // collectionManager.newCollection(oldCollection);
        list=collectionManager.getCollection();
        list.add(consoleManager.getProduct());
        System.out.println(list);
        collectionManager.setCollection(list);

        //ConsoleManager consoleManager=new ConsoleManager();
        consoleManager.getCommand();



    }

}