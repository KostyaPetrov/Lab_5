package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class Clear implements Commandable{

    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public Clear(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){

        collectionManager.setCollection(new LinkedList<>());
        collectionManager.setUniqueId(new ArrayList<>());
        consoleManager.getCommand();
    }
}
