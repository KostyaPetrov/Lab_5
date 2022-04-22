package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.LinkedList;

public class CountGreaterThanUnitMeasure implements Commandable{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    public CountGreaterThanUnitMeasure(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){

        LinkedList<Product> collectionElements=collectionManager.getCollection();
        String comparisonUnitOfMeasure=consoleManager.getСomparisonUnitOfMeasure();
        int count=0;
        for(Product element:collectionElements){
            if(comparisonUnitOfMeasure.compareTo(element.getUnitOfMeasure().getWord())<0){
                count+=1;
            }
        }
        System.out.println("In collection "+count+" elements great than "+comparisonUnitOfMeasure);


    }
}
