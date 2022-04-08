package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class AddIfMax implements Commandable {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    public AddIfMax(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(String s){
        Product newProduct=consoleManager.getProduct();
        LinkedList<Product> collectionElements=collectionManager.getCollection();
        ArrayList<Integer> arrPrice = new ArrayList<>();
        for(Product collectionElement:collectionElements){
            arrPrice.add(collectionElement.getPrice());
        }
        if(newProduct.getPrice()> Collections.max(arrPrice)){
            collectionElements.add(newProduct);
            collectionManager.setCollection(collectionElements);
            System.out.println("Element added");
        }else{
            System.out.println("Price of your product is not highest. Product noy added.");
        }

        consoleManager.getCommand();
    }
}
