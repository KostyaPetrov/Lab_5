package ru.kostyapetrov.lab_5.console;


import ru.kostyapetrov.lab_5.collection.*;
import ru.kostyapetrov.lab_5.commands.CommandManager;
import ru.kostyapetrov.lab_5.file.FileManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleManager {
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;
    private FileManager fileManager;

    protected Map<String, String> map = new HashMap<>();
//    private Scanner in;
    public ConsoleManager(){
//        Scanner in = new Scanner(System.in);
//        this.in=in;
    }
    public void getObject(CollectionManager collectionManager, ConsoleManager consoleManager, FileManager fileManager){
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
        this.fileManager=fileManager;
    }




    public void getCommand(){
        String[] arrCommandLine;
        System.out.println("Enter command(for list commands enter \"help\")");

        Scanner in = new Scanner(System.in);
        String inputCommand = in.nextLine();
        CommandManager commandManager = new CommandManager(collectionManager,consoleManager,fileManager);
        if(!inputCommand.contains(" ")){
            collectionManager.setCommand(inputCommand);
            commandManager.execCommand(inputCommand);

        }else{
            arrCommandLine=inputCommand.split(" ");
            if(arrCommandLine.length!=2){
                System.out.println("Invalid command format");
                getCommand();
            }else{
                map.put(arrCommandLine[0],arrCommandLine[1]);
                collectionManager.setCommand(arrCommandLine[0]);
                commandManager.execCommand(arrCommandLine[0]);
            }

        }


    }

    public String getNameFile(){
        System.out.println("Enter path to file");
        Scanner in = new Scanner(System.in);

        return (in.nextLine());

    }


    ArrayList<Integer> listUniqueId = new ArrayList<>();
    public Integer getUniqueId(){
        if(collectionManager.getUniqueId()!=null){
            listUniqueId.addAll(collectionManager.getUniqueId());
        }
        if (listUniqueId.isEmpty()){
            listUniqueId.add(1);
            return 1;
        }else {
            listUniqueId.add(Collections.max(listUniqueId) + 1);
            return Collections.max(listUniqueId);
        }
    }

    public String getName(){
        System.out.println("Enter name product");
        Scanner in = new Scanner(System.in);

        return (in.nextLine());
    }

    public Long getCoordinateX(){
        System.out.println("Enter coordinates(X less then 486)");
        System.out.print("X=");
        Scanner in = new Scanner(System.in);

        return ((long) in.nextInt());
    }
    public Float getCoordinateY(){
        System.out.print("Y=");
        Scanner in = new Scanner(System.in);
        return in.nextFloat();
    }

    public LocalDate getDate(){
        return LocalDate.now();
    }

    public Integer getPrice(){
        System.out.println("Enter price product");
        Scanner in = new Scanner(System.in);

        return in.nextInt();
    }

    public String getPartNumber(){
        System.out.println("Enter part number");
        Scanner in = new Scanner(System.in);

        return (in.nextLine());
    }

    public Float getManufactureCost(){
        System.out.println("Enter manufacture cost");
        Scanner in = new Scanner(System.in);

        return in.nextFloat();
    }

    public UnitOfMeasure getUnitOfMeasure(){

        System.out.println("Enter unit of measure(LITERS, MILLILITERS, GRAMS)");
        Scanner in = new Scanner(System.in);
        String unitOfMeasure = in.nextLine();
        return (UnitOfMeasure.valueOf(unitOfMeasure));

    }
    public String getNamePerson(){
        System.out.println("Enter name person");
        Scanner in = new Scanner(System.in);
        return (in.nextLine());
    }

    public LocalDateTime getBirthdayPerson(){
        System.out.println("Enter birthday person(\"yyyy-MM-dd HH:mm\")");
        Scanner in = new Scanner(System.in);
        String birthday = in.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        return (LocalDateTime.parse(birthday, format));
    }

    public Double getWeightPerson(){
        System.out.println("Enter weight person");
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }
    public Product getProduct(){
        return new Product(getUniqueId() ,getName(),new Coordinates(getCoordinateX(),getCoordinateY()), getDate(), getPrice(), getPartNumber(), getManufactureCost(), getUnitOfMeasure(), new Person(getNamePerson(),getBirthdayPerson(),getWeightPerson()));
    }


    public Integer getUpdateId(){
        return Integer.valueOf(map.get("update"));
    }


    public Integer getRemoveId(){

        return Integer.valueOf(map.get("remove_by_id"));
    }

    public Float getRemoveManufactureCost(){
        return Float.valueOf(map.get("remove_all_by_manufacture_cost"));
    }

    public String getСomparisonUnitOfMeasure(){
        return map.get("count_greater_than_unit_of_measure");
    }

    public void closeScan(){
        Scanner in = new Scanner(System.in);
        in.close();
    }



}
