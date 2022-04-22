package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Coordinates;
import ru.kostyapetrov.lab_5.collection.Person;
import ru.kostyapetrov.lab_5.collection.Product;

import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.LinkedList;

public class Add implements Commandable {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    public Add(CollectionManager collectionManager, ConsoleManager consoleManager) {
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){


        LinkedList<Product> list = collectionManager.getCollection();
        Product product=consoleManager.getProduct();

        list.add(product);



        System.out.println(list);
        collectionManager.setCollection(list);





    }

}