package ru.kostyapetrov.lab_5.collection;


import java.time.LocalDate;


public class Product {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int price; //Значение поля должно быть больше 0
    private String partNumber; //Длина строки должна быть не меньше 24, Строка не может быть пустой, Длина строки не должна быть больше 50, Поле не может быть null
    private Float manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле может быть null

//    ArrayList listId = new ArrayList<>();
    public Product(Integer id, String name, Coordinates coordinates, LocalDate creationDate, int price, String partNumber, Float manufactureCost, UnitOfMeasure unitOfMeasure, Person owner){
        this.id=id;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=creationDate;
        this.price=price;
        this.partNumber=partNumber;
        this.manufactureCost=manufactureCost;
        this.unitOfMeasure=unitOfMeasure;
        this.owner=owner;
    }

//    public void uniqueId(){
//        if (listId.isEmpty()){
//            listId.add(1);
//            this.id= 1;
//        }else {
//            listId.add((int) Collections.max(listId) + 1);
//            this.id= (int) Collections.max(listId) + 1;
//
//        }
//    }


    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s",id,name,coordinates, creationDate,price,partNumber,manufactureCost,unitOfMeasure,owner);
    }

    public Integer getPrice(){
        return price;
    }
    public LocalDate getCreationDate(){
        return creationDate;
    }
    public Float getManufactureCost(){return manufactureCost;}
    public UnitOfMeasure getUnitOfMeasure(){
        return unitOfMeasure;
    }
//    public String createElementCollection(){
//        uniqueId();
//
//        ConsoleManager consoleManager = new ConsoleManager();
//
//
//
//        this.name=consoleManager.getName();
//
//        Coordinates coordinates=new Coordinates(consoleManager.getCoordinateX(),consoleManager.getCoordinateY());
//
//
//
//        LocalDate date = LocalDate.now();
//        this.creationDate= date;
//
//        this.price=consoleManager.getPrice();
//
//        this.partNumber=consoleManager.getPartNumber();
//
//        this.manufactureCost=consoleManager.getManufactureCost();
//
//        this.unitOfMeasure= UnitOfMeasure.valueOf(consoleManager.getUnitOfMeasure());
//
//        Person owner = new Person(consoleManager.namePerson(),consoleManager.birthdayPerson(),consoleManager.weightPerson());
//
//        String element = new String(id+" | "+
//                name +" | "+
//                coordinates.getX() +" | "+
//                coordinates.getY() +" | "+
//                creationDate+" | "+
//                price+" | "+
//                partNumber+" | "+
//                manufactureCost+" | "+
//                unitOfMeasure+" | "+
//                owner.getNamePerson()+" | "+
//                owner.getBirthday()+" | "+
//                owner.getWeight());
//
//        return element;
//    }
}
