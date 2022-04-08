package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveId implements Commandable {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private Integer indexElementCollection;
    private LinkedList<Product> collectionElements;
    private ArrayList<Integer> collectionId;
    public RemoveId(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){
        Integer removeId = consoleManager.getRemoveId();

        collectionElements=collectionManager.getCollection();
        collectionId=collectionManager.getUniqueId();
//get position element in collection and remove them
        indexElementCollection=collectionId.indexOf(removeId);

        System.out.println(indexElementCollection);
        int i= indexElementCollection;
        collectionElements.remove(i);
        collectionId.remove(i);

//write new colllection in collection storage
        System.out.println(collectionElements);
        collectionManager.setCollection(collectionElements);
        collectionManager.setUniqueId(collectionId);

        consoleManager.getCommand();
    }

}
