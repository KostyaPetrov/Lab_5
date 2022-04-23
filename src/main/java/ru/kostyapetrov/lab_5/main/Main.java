package ru.kostyapetrov.lab_5.main;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.commands.CommandManager;
import ru.kostyapetrov.lab_5.console.ConsoleManager;
import ru.kostyapetrov.lab_5.file.FileManager;

/**
 *@author Konstantin Petrov P3108 ITMO
 *
 * Main class that starts the program
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("Hellow, dear user!\n" +
                "Welcome to the product collection manager\n");

        ConsoleManager consoleManager = new ConsoleManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(consoleManager,collectionManager);
        CommandManager commandManager = new CommandManager(collectionManager,consoleManager,fileManager);

        //Read data from a file

        fileManager.fileRead(consoleManager.getNameFile());



        consoleManager.getObject(collectionManager,consoleManager,fileManager,commandManager);

        consoleManager.getCommand();





    }

}


