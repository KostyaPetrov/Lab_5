package commands;

import console.ConsoleManager;
import file.FileManager;
import collection.CollectionManager;

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

        fileManager.fileWrite(collectionManager.getNewCollection());


        consoleManager.getCommand();
    }
}
