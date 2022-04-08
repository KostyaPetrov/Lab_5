package ru.kostyapetrov.lab_5.file;


import ru.kostyapetrov.lab_5.collection.*;


import ru.kostyapetrov.lab_5.console.ConsoleManager;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;


public class FileManager {
    private java.time.LocalDate initCollectionDate;
    ArrayList<Integer> uniqueId = new ArrayList<>();
    //Writing data to file
    public void fileWrite(LinkedList<Product> collection){
        String headline="id, name, coordinate X, coordinate Y, creation Date, price, part number, manufacture cost, unit of measure, owner name, owner birthday, owner weight\n";
        StringBuilder products = new StringBuilder(headline);

        for (Product product : collection) {
            System.out.println(product.toString());
            products.append(product).append("\n");
        }



        ConsoleManager consoleManager = new ConsoleManager();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(consoleManager.getNameFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            outputStreamWriter.write(products.toString());
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    //Reading data from file
    public LinkedList<Product> fileRead(String path, ConsoleManager consoleManager, CollectionManager collectionManager) throws IOException{

        StringBuilder fileData= new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(path);

        //reading text from a file in bloks of 200 bytes
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

        int i;


        while((i = bufferedInputStream.read())!= -1){
            fileData.append((char) i);

        }

        LinkedList<Product> fileDataCollection = new LinkedList<>();//TODO

        //fill array with elements from file
        String[] arrElements;
        String delimeter = "\n";
        arrElements = fileData.toString().split(delimeter);

        if (fileData.toString().equals("") | arrElements.length==1) {

            return fileDataCollection;
        }else if(fileData.indexOf(",")!=-1){

                //String headline="id, name, coordinate X, coordinate Y, creation Date, price, part number, manufacture cost, unit of measure, owner name, owner birthday, owner weight\n";
                //        StringBuilder products = new StringBuilder();
                //
                //        for (Product product : lists) {
                //            System.out.println(product.toString());
                //            products.append(product).append("\n");
                //        }
//                for (int k = 0; i < arrStr.length+1; i++) {
//                    fileCollection.add(arrStr[i]);
//                }



            for(int j=1; j<arrElements.length; j++){

                //split elements on product components
                String[] components=arrElements[j].split(",");

                //Check for the number of elements
                if(components.length!=12){
                    System.out.println("In element "+(j+1)+" not all components are present. Add an element or specify another file");
                    return fileRead(consoleManager.getNameFile(),consoleManager,collectionManager);
                }else {

                    //Add new element in collection and write ID in array

                  //  try {
                    fileDataCollection.add(new Product(Integer.valueOf(components[0].trim()), components[1],
                                new Coordinates(Long.parseLong(components[2].trim()), Float.parseFloat(components[3].trim())),
                                LocalDate.parse(components[4].trim()),Integer.parseInt(components[5].trim()),components[6],
                                Float.valueOf(components[7].trim()), UnitOfMeasure.valueOf(components[8].trim()),new Person(components[9],
                                LocalDateTime.parse(components[10].trim()),Double.valueOf(components[11].trim()))));
//,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                        uniqueId.add(Integer.valueOf(components[0].trim()));
                        initCollectionDate=consoleManager.getDate();
//                    }catch (NumberFormatException e) {
//                        System.err.println("Incorrect numeric data");
//                    }

                }
            }
            System.out.println(fileDataCollection);
            collectionManager.setUniqueId(uniqueId);
            return fileDataCollection;

        }else{
            System.out.println("Invalid file data format. Enter other path to file");
            return fileRead(consoleManager.getNameFile(),consoleManager, collectionManager);
        }


    }
    public LocalDate getInitCollectionDate(){
        return initCollectionDate;
    }
//    public ArrayList<Integer> getArrayUniqueId(){
//        return uniqueId;
//    }
}
