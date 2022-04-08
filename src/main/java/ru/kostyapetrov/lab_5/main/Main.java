package ru.kostyapetrov.lab_5.main;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.console.ConsoleManager;
import ru.kostyapetrov.lab_5.file.FileManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
//"C:\Users\Костя\Desktop\ITMO\ITMO_2sem\proga\Lab_5\src\main\java\ru\kostyapetrov\lab_5\File\\collection_storage.csv"
//1, Milk, 10,10.0, 2022-04-05, 10, 10, 10.0, LITERS,  Kostya, 2004-12-12T12:12, 70.0
// 3, cat, 45,45.0, 2022-04-05, 45, 45, 45.0, GRAMS,  45, 2000-08-09T13:10, 90.0
        //1, Miklk, 10,10.0, 2022-04-07, 10, 10, 10.0, LITERS,  Kostya, 2004-01-12T12:15, 70.0
        //2, cat, 45,45.0, 2022-04-07, 45, 45, 45.0, GRAMS,  Ilya, 1999-02-23T11:10, 80.0
        //3, Putin, 100,10.0, 2022-04-07, 0, 1, 0.0, MILLILITERS,  Me, 1952-04-12T22:22, 90.0
        System.out.println("Hellow, dear user!\n" +
                "Welcome to the product collection manager\n"+
                "C:\\Users\\Костя\\Desktop\\ITMO\\ITMO_2sem\\proga\\Lab_5\\src\\main\\java\\ru\\kostyapetrov\\lab_5\\File\\\\collection_storage.csv\n");
        ConsoleManager consoleManager = new ConsoleManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager();


        //Read data from a file
        try {
            collectionManager.setCollection(fileManager.fileRead(consoleManager.getNameFile(),consoleManager,collectionManager));
        } catch (IOException e) {
            e.printStackTrace();
        }

        consoleManager.getObject(collectionManager,consoleManager,fileManager);
        consoleManager.getCommand();


     //   CommandManager commandManager = new CommandManager(collectionManager,consoleManager,fileManager);

    }
}


