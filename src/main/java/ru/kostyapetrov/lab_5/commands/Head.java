package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;


public class Head implements Commandable {

    private CollectionManager collectionManager;
    public Head( CollectionManager collectionManager){

        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){

        System.out.println(collectionManager.getCollection().getFirst());

    }
}
