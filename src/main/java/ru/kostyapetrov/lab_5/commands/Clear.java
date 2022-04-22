package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;


import java.util.ArrayList;
import java.util.LinkedList;

public class Clear implements Commandable{

    private CollectionManager collectionManager;


    public Clear(CollectionManager collectionManager){

        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){

        collectionManager.setCollection(new LinkedList<>());
        collectionManager.setUniqueId(new ArrayList<>());

    }
}
