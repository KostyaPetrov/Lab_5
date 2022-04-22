package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Coordinates;
import ru.kostyapetrov.lab_5.collection.Person;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;


import java.util.ArrayList;
import java.util.LinkedList;

public class UpdateId implements Commandable{
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;
    private Integer updateId, indexElementCollection;

    public UpdateId(CollectionManager collectionManager, ConsoleManager consoleManager){
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){
        ArrayList<Integer> collectionId = collectionManager.getUniqueId();
        LinkedList<Product> collectionElements = collectionManager.getCollection();

        updateId=consoleManager.getUpdateId();
        if(consoleManager.getExeptionInfo()){
            consoleManager.setExeptionInfo(false);
        }else {


            //find position needed element collection if in collection id elements and replace element new product with old id and creation date, but new else field
            indexElementCollection = collectionId.indexOf(updateId);
            collectionElements.set(indexElementCollection, new Product(updateId, consoleManager.getName(), new Coordinates(consoleManager.getCoordinateX(), consoleManager.getCoordinateY()),
                    collectionElements.get(indexElementCollection).getCreationDate(), consoleManager.getPrice(), consoleManager.getPartNumber(), consoleManager.getManufactureCost(),
                    consoleManager.getUnitOfMeasure(), new Person(consoleManager.getNamePerson(), consoleManager.getBirthdayPerson(), consoleManager.getWeightPerson())));


            //write new colllection in collection storage
            System.out.println(collectionElements);
            collectionManager.setCollection(collectionElements);
        }


    }
}
