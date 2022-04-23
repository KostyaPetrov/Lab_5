package ru.kostyapetrov.lab_5.console;


import ru.kostyapetrov.lab_5.collection.*;
import ru.kostyapetrov.lab_5.commands.CommandManager;
import ru.kostyapetrov.lab_5.exeption.*;
import ru.kostyapetrov.lab_5.file.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleManager {
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;
    private FileManager fileManager;
    private CommandManager commandManager;

    protected Map<String, String> map = new HashMap<>();
    private String endCommand="";

    public ConsoleManager(){

    }
    public void getObject(CollectionManager collectionManager, ConsoleManager consoleManager, FileManager fileManager,CommandManager commandManager){
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
        this.fileManager=fileManager;
        this.commandManager=commandManager;
    }




    public void getCommand() {
        String[] arrCommandLine;

        System.out.println("Enter command(for list commands enter \"help\")");
        Scanner in = new Scanner(System.in);






        try{
            String inputCommand = in.nextLine();
            if(inputCommand.isEmpty()){
                throw new IncorrectCommandExeption("Command can not be null");
            }
            inputCommand=inputCommand.trim();
            if (!inputCommand.contains(" ")) {
                if(!commandManager.getMap().containsKey(inputCommand)){
                    throw new IncorrectCommandExeption("No such command exists. ABOBA");
                }
                collectionManager.setCommand(inputCommand);
                commandManager.execCommand(inputCommand);
            } else {
                arrCommandLine = inputCommand.split(" ");
                if (!arrCommandLine[0].equals("remove_by_id") && !arrCommandLine[0].equals("execute_script") && !arrCommandLine[0].equals("remove_all_by_manufacture_cost") && !arrCommandLine[0].equals("remove_all_by_manufacture_cost")) {
                    throw new IncorrectCommandExeption("Invalid command format");
                } else {
                    /*
                    *put data from command line to map for pass to a method
                     */
                    map.put(arrCommandLine[0], arrCommandLine[1]);
                    collectionManager.setCommand(arrCommandLine[0]);
                    commandManager.execCommand(arrCommandLine[0]);
                }
            }

            String endCommand=getEndScriptCommand();
            if(endCommand.equals("exit") || inputCommand.equals("exit"))   {

                closeScan();



            }else{
                getCommand();

            }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            getCommand();
        }catch (NoSuchElementException ex){
            in=new Scanner(System.in);
            getCommand();
        }
    }



    public void getCommand(String inputCommand){
        String[] arrCommandLine;
        ArrayList<String> collection;
        try {
            if(inputCommand.isEmpty()){
                throw new IncorrectCommandExeption("Command can not be null");
            }

            inputCommand=inputCommand.trim();
            if (!inputCommand.contains(" ")) {
                if(!commandManager.getMap().containsKey(inputCommand)){
                    throw new IncorrectCommandExeption("\""+inputCommand+"\""+" command does not exist. ABOBA");
                }
                collectionManager.setCommand(inputCommand);
                commandManager.execCommand(inputCommand);

            } else {
                arrCommandLine = inputCommand.split(" ");
                collection=collectionManager.getCollectionPathToScript();
                if (!arrCommandLine[0].equals("remove_by_id") && !arrCommandLine[0].equals("execute_script") && !arrCommandLine[0].equals("remove_all_by_manufacture_cost") && !arrCommandLine[0].equals("remove_all_by_manufacture_cost")) {
                    throw new IncorrectCommandExeption("\"" + inputCommand + "\"" + " invalid command format");

                } else {
                    if(arrCommandLine[0].equals("execute_script") && collection.contains(arrCommandLine[1].trim())) {
                        collectionManager.setCollectionPathToScript(new ArrayList<>());
                        throw new RecursiveScriptExeption("Recursive in file");
                    }else{
                        collection.add(arrCommandLine[1]);
                        collectionManager.setCollectionPathToScript(collection);
                    }
                    map.put(arrCommandLine[0], arrCommandLine[1]);
                    collectionManager.setCommand(arrCommandLine[0]);
                    commandManager.execCommand(arrCommandLine[0]);
                }


            }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            setExeptionInfo(true);
        }
    }


    boolean exeptionInfo=false;
    public boolean getExeptionInfo(){
        return exeptionInfo;
    }
    public void setExeptionInfo(boolean exeptionInfo){
        this.exeptionInfo=exeptionInfo;
    }



    public String getNameFile(){


        System.out.println("Enter path to file");
        Scanner in = new Scanner(System.in);
        try {

            return (in.nextLine());

        }catch (NoSuchElementException e){
            System.err.println("You must enter path to file");
            in=new Scanner(System.in);
            return getNameFile();
        }


    }

    public String getPathToFile(){

        System.out.println("Enter path to file");
        Scanner in = new Scanner(System.in);
        try {
            String path=in.nextLine();

            return (path);

        }catch (NoSuchElementException e) {
            in = new Scanner(System.in);
            return "Exit";
        }
    }

    ArrayList<Integer> listUniqueId = new ArrayList<>();
    public Integer getUniqueId(){

        if(!collectionManager.getUniqueId().isEmpty()){
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
        String inputCommand = in.nextLine();
        try {
            if (inputCommand.isEmpty()) {
                throw new FieldProductExeption("Name cannot be null");

            } else {
                return (inputCommand);
            }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            return getName();
        }
    }

    public Long getCoordinateX() {
        System.out.println("Enter coordinates(X less then 486)");
        System.out.println("Input X");

        Scanner in = new Scanner(System.in);



        try {
            String inputCommandLine = in.nextLine();
            Long inputCommand=Long.parseLong(inputCommandLine);
            if (inputCommand > 485) {
                throw new FieldProductExeption("Coordinate X must be less then 486");
            }else if(inputCommandLine.isEmpty()){
                throw new FieldProductExeption("Coordinate can not be null");
            } else {

                return inputCommand;

            }

        } catch (CommandExeption e) {
            System.err.println(e.getMessage());
            return getCoordinateX();

        }catch(NumberFormatException ex){
            System.err.println("Coordinate X must be number");
            return getCoordinateX();
        }
    }



    public Float getCoordinateY(){
        System.out.println("Input Y");
        Scanner in = new Scanner(System.in);

        try {
            String inputCommandLine = in.nextLine();
            Float inputCommand=Float.parseFloat(inputCommandLine);
            if (inputCommand > 485) {
                throw new FieldProductExeption("Coordinate X must be less then 486");
            }else if(inputCommandLine.isEmpty()){
                    throw new FieldProductExeption("Coordinate can not be null");
            } else {
                return inputCommand;
            }
        } catch (CommandExeption e) {
            System.err.println(e.getMessage());
            return getCoordinateY();
        }catch (NumberFormatException e){
            System.err.println("Coordinate Y must be number");
            return getCoordinateY();
        }
    }

    public LocalDate getDate(){
        return LocalDate.now();
    }

    public Integer getPrice(){
        System.out.println("Enter price product");
        Scanner in = new Scanner(System.in);
        try {
            String inputCommandLine=in.nextLine();
            Integer inputCommand = Integer.parseInt(inputCommandLine);
            if(inputCommand<0) {
                throw new FieldProductExeption("Price must be greater than 0");
            }else if(inputCommandLine.isEmpty()){
                throw new FieldProductExeption("Price can not be null");

            }else {
                return inputCommand;
            }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            return getPrice();
        }catch (NumberFormatException e){
            System.err.println("Price must be number");
            return getPrice();
        }

    }

    public String getPartNumber(){
        System.out.println("Enter part number");
        Scanner in = new Scanner(System.in);
        try {
            String inputCommand = in.nextLine();
            if (inputCommand.length() > 23 && inputCommand.length() < 51) {

                return (inputCommand);
            }else if(inputCommand.isEmpty()){
                throw new FieldProductExeption("Part number can not be null");

            } else {
                throw new FieldProductExeption("Length part number must be greater than 23 and less than 51");

            }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            return getPartNumber();
        }
    }

    public Float getManufactureCost(){

        System.out.println("Enter manufacture cost");
        Scanner in = new Scanner(System.in);


        try {
            String inputCommandLine=in.nextLine();
            Float inputCommand=Float.parseFloat(inputCommandLine);
            if(inputCommandLine.isEmpty()){
                return null;
            }else {
                return (inputCommand);
            }
        }catch (NumberFormatException e){
            System.err.println("Manufacture cost must be a number");
            return getManufactureCost();
        }

    }

    public UnitOfMeasure getUnitOfMeasure(){

        System.out.println("Enter unit of measure(LITERS, MILLILITERS, GRAMS)");
        Scanner in = new Scanner(System.in);

        String unitOfMeasure = in.nextLine();

        try {
            if (unitOfMeasure.equals("LITERS") || unitOfMeasure.equals("MILLILITERS") || unitOfMeasure.equals("GRAMS")) {
                return UnitOfMeasure.valueOf(unitOfMeasure);
            } else {
                throw new FieldProductExeption("Unit of measure may be only LITERS, MILLILITERS or GRAMS");
            }

//
//        }catch (IllegalArgumentException e){
//            System.err.println("Unit of measure may be LITERS, MILLILITERS, GRAMS");
//            return getUnitOfMeasure();
//        }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            return getUnitOfMeasure();
        }

    }
    public String getNamePerson(){
        System.out.println("Enter name person");
        Scanner in = new Scanner(System.in);
        String inputCommand=in.nextLine();
        try {
            if(inputCommand.isEmpty()){
                throw new FieldProductExeption("Name person can not be null");
            }else {
                return inputCommand;
            }
        }catch (CommandExeption e){
            System.err.println(e.getMessage());
            return getNamePerson();
        }

    }

    public LocalDateTime getBirthdayPerson(){
        System.out.println("Enter birthday person(\"yyyy-MM-dd HH:mm\")");
        Scanner in = new Scanner(System.in);


        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String inputCommand=in.nextLine();
        try {
            if(inputCommand.isEmpty()){
                return null;
            }else {
                return (LocalDateTime.parse(inputCommand, format));
            }
        }catch (DateTimeParseException e){
            System.err.println("Birthday date must match the format \"yyyy-MM-dd HH:mm\" or be null");
            return getBirthdayPerson();
        }
    }

    public Double getWeightPerson(){
        System.out.println("Enter weight person");
        Scanner in = new Scanner(System.in);
        String inputCommandLine=in.nextLine();
        try {
            Double inputCommand=Double.parseDouble(inputCommandLine);
            if(inputCommandLine.isEmpty()) {
                throw new FieldProductExeption("Weight person can not be null");
            }else if(inputCommand<=0){
                throw new FieldProductExeption("Weight person must be grate then 0");
            }else {
                return inputCommand;
            }
        }catch (NumberFormatException e){
            System.err.println("Weight person must be a number");
            return getWeightPerson();
        }catch (CommandExeption ex){
            System.err.println(ex.getMessage());
            return getWeightPerson();
        }

    }
    public Product getProduct() {

        return new Product(getUniqueId(), getName(), new Coordinates(getCoordinateX(), getCoordinateY()), getDate(), getPrice(), getPartNumber(), getManufactureCost(), getUnitOfMeasure(), new Person(getNamePerson(), getBirthdayPerson(), getWeightPerson()));


    }


    public Integer getUpdateId(){
        try {
            return Integer.valueOf(map.get("update"));
        }catch(NumberFormatException e){
            System.err.println("Id for update must be number");
            setExeptionInfo(true);
            return null;
        }

    }


    public Integer getRemoveId(){
        try {
            return Integer.valueOf(map.get("remove_by_id"));
        }catch(NumberFormatException e){
            System.err.println("Id for remove must be number");
            setExeptionInfo(true);
            return null;
        }

    }

    public Float getRemoveManufactureCost(){
        try {
            return Float.valueOf(map.get("remove_all_by_manufacture_cost"));
        }catch(NumberFormatException e){
            System.err.println("Remove manufacture cost must be number");
            setExeptionInfo(true);
            return null;
        }

    }

    public String getСomparisonUnitOfMeasure(){
        return map.get("count_greater_than_unit_of_measure");
    }

    String pathExecuteScript;
    public String getPathScriptFile(){
       // pathExecuteScript=map.get("execute_script");
        return map.get("execute_script");
    }

    public void setEndScriptCommand(String endCommand){
        this.endCommand=endCommand;
    }
    public String getEndScriptCommand(){
        return endCommand;
    }

    public void closeScan(){
        Scanner in = new Scanner(System.in);
        in.close();
    }



}
