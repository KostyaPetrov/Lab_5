package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;



import java.util.LinkedList;

public class History implements Commandable{

    private CollectionManager collectionManager;

    public History(CollectionManager collectionManager){

        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(String s) {
        LinkedList<String> collectCommand = collectionManager.getHistoryCommand();

        for (int i=0;i<collectCommand.size();i++) {
            System.out.println((i+1)+"."+collectCommand.get(i));
        }


    }



}
