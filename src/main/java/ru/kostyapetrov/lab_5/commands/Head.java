package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;

import ru.kostyapetrov.lab_5.console.ConsoleManager;

public class Head implements Commandable {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    public Head(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){

        System.out.println(collectionManager.getCollection().getFirst());
        consoleManager.getCommand();
    }
}
