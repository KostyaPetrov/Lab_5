package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.console.ConsoleManager;
import ru.kostyapetrov.lab_5.file.FileManager;

public class Save implements Commandable {
    private FileManager fileManager;
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public Save(FileManager fileManager,CollectionManager collectionManager,ConsoleManager consoleManager){
        this.fileManager=fileManager;
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
    }

    @Override
    public void execute(String s){

        fileManager.fileWrite(collectionManager.getCollection());


        consoleManager.getCommand();
    }
}
