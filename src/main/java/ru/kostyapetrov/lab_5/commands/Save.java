package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.file.FileManager;

public class Save implements Commandable {
    private FileManager fileManager;
    private CollectionManager collectionManager;


    public Save(FileManager fileManager,CollectionManager collectionManager){
        this.fileManager=fileManager;
        this.collectionManager=collectionManager;

    }

    @Override
    public void execute(String s){

        fileManager.fileWrite(collectionManager.getCollection());

    }
}
