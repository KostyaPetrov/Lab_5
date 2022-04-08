package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.LinkedList;

public class Show implements Commandable {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private LinkedList<Product> collectionElements;
    public Show(CollectionManager collectionManager, ConsoleManager consoleManager){
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
    }

    @Override
    public void execute(String s){
        collectionElements=collectionManager.getCollection();
        for(int i=0; i<collectionElements.size();i++){
            System.out.println(collectionElements.get(i));
        }


        consoleManager.getCommand();

    }

}

