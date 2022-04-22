package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.*;
import ru.kostyapetrov.lab_5.console.ConsoleManager;
import ru.kostyapetrov.lab_5.file.FileManager;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class ExecuteScript implements Commandable{
    private ConsoleManager consoleManager;
    private FileManager fileManager;
    private CollectionManager collectionManager;

    public ExecuteScript(ConsoleManager consoleManager, FileManager fileManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.fileManager=fileManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){
        String[] scriptFile= fileManager.getFileScript();
        int count=0;
        for(int i=0; i<scriptFile.length;i++){
            if(scriptFile[i].trim().equals("add")){
                LinkedList<Product> list = collectionManager.getCollection();
                list.add(new Product(consoleManager.getUniqueId(), scriptFile[i+1],
                        new Coordinates(Long.parseLong(scriptFile[i + 2].trim()), Float.parseFloat(scriptFile[i + 3].trim())),
                        consoleManager.getDate(), Integer.parseInt(scriptFile[i+4].trim()), scriptFile[i+5],
                        Float.valueOf(scriptFile[i+6].trim()), UnitOfMeasure.valueOf(scriptFile[i+7].trim()), new Person(scriptFile[i+8],
                        LocalDateTime.parse(scriptFile[i+9].trim()), Double.valueOf(scriptFile[i+10].trim()))));
                i+=10;
                collectionManager.setCollection(list);
            }else if(scriptFile[i].contains(" ") && scriptFile[i].split(" ")[0].equals("update")){
                ArrayList<Integer> collectionId = collectionManager.getUniqueId();
                LinkedList<Product> collectionElements = collectionManager.getCollection();

                Integer updateId=Integer.valueOf(scriptFile[i].split(" ")[1]);


                //find position needed element collection if in collection id elements and replace element new product with old id and creation date, but new else field
                Integer indexElementCollection= collectionId.indexOf(updateId);
                collectionElements.set(indexElementCollection,new Product(updateId,scriptFile[i+1],
                        new Coordinates(Long.parseLong(scriptFile[i +2].trim()), Float.parseFloat(scriptFile[i + 3].trim())),
                        collectionElements.get(indexElementCollection).getCreationDate(), Integer.parseInt(scriptFile[i+4].trim()), scriptFile[i+5],
                        Float.valueOf(scriptFile[i+6].trim()), UnitOfMeasure.valueOf(scriptFile[i+7].trim()), new Person(scriptFile[i+8],
                        LocalDateTime.parse(scriptFile[i+9].trim()), Double.valueOf(scriptFile[i+10].trim()))));

                i+=10;
                //write new colllection in collection storage
                collectionManager.setCollection(collectionElements);
            }else{
                consoleManager.getCommand(scriptFile[i]);
                if(consoleManager.getExeptionInfo()){
                    consoleManager.setExeptionInfo(false);
                    break;
                }
                if(scriptFile[i].equals("exit")){
                    consoleManager.setEndScriptCommand("exit");
                    break;
                }

            }
            if(i==scriptFile.length-1){
                System.out.println("Script from file completed");
            }
        }
    }

}
