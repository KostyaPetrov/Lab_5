package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;
import ru.kostyapetrov.lab_5.file.FileManager;


import java.util.LinkedList;

public class Info implements Commandable{
    private CollectionManager collectionManager;
    private FileManager fileManager;
    private ConsoleManager consoleManager;
    private LinkedList<Product> collectionElements;

    public Info(CollectionManager collectionManager, FileManager fileManager, ConsoleManager consoleManager){
        this.collectionManager=collectionManager;
        this.fileManager=fileManager;
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){

        collectionElements=collectionManager.getCollection();
        if(collectionElements.isEmpty()){
            System.out.println("Collection is empty");
        }else{

            System.out.format("LinkedList, %s, %s\n", fileManager.getInitCollectionDate(), collectionElements.size());
        }

        consoleManager.getCommand();

    }
}
