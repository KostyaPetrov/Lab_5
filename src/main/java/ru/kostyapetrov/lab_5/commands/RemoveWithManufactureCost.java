package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;
import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.util.LinkedList;


public class RemoveWithManufactureCost implements Commandable{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private Float removeCost;
    public RemoveWithManufactureCost(ConsoleManager consoleManager, CollectionManager collectionManager){
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return  this.removeCost== that.getManufactureCost();
    }

    @Override
    public int hashCode() {
        return this.removeCost.hashCode();
    }

    @Override
    public void execute(String arg) {
        LinkedList<Product> collectionElements=collectionManager.getCollection();

        removeCost=consoleManager.getRemoveManufactureCost();
        if(consoleManager.getExeptionInfo()){
            consoleManager.setExeptionInfo(false);
        }else {

            for (int i = 0; i < collectionElements.size(); i++) {

                if (removeCost.equals(collectionElements.get(i).getManufactureCost())) {
                    collectionElements.remove(i);
                    //for the correct output of the final collection
                    i = i - 1;
                } else {
                    System.out.println(collectionElements.get(i));
                }
            }
            collectionManager.setCollection(collectionElements);
        }
    }
}
