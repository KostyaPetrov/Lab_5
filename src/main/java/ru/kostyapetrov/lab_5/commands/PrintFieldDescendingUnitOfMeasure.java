package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.collection.Product;


import java.util.ArrayList;
import java.util.Collections;


public class PrintFieldDescendingUnitOfMeasure implements Commandable{

    private CollectionManager collectionManager;
    public PrintFieldDescendingUnitOfMeasure(CollectionManager collectionManager){

        this.collectionManager=collectionManager;
    }
    @Override
    public void execute(String s){
        ArrayList<String> arrayUnitOfMesure = new ArrayList<>();
        for(Product element: collectionManager.getCollection()){
            arrayUnitOfMesure.add(element.getUnitOfMeasure().getWord());
        }
        Collections.sort(arrayUnitOfMesure,Collections.reverseOrder());

        for(int i=0; i<arrayUnitOfMesure.size();i++){
            System.out.println(arrayUnitOfMesure.get(i));
        }

    }
}
