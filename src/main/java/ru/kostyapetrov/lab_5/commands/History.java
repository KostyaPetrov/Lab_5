package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.console.ConsoleManager;


import java.util.LinkedList;

public class History implements Commandable{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    public History(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(String s) {
        LinkedList<String> collectCommand = collectionManager.getHistoryCommand();

        for (int i=0;i<collectCommand.size();i++) {
            System.out.println((i+1)+"."+collectCommand.get(i));
        }

        consoleManager.getCommand();
    }



}
