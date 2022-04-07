package console;
import collection.Product;
import commands.CommandManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleManager {

    Scanner in = new Scanner(System.in);

    public void getCommand(){

        System.out.println("Enter command(for list commands enter \"help\")");

        String inputCommand = in.nextLine();


        CommandManager commandManager = new CommandManager();
        commandManager.execCommand(inputCommand);
    }

    public String getNameFile(){
        System.out.println("Enter path to file");


        String fileName = in.nextLine();

        return (fileName);
    }

    public String getName(){
        System.out.println("Enter name product");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        return (name);
    }

    public Long getCoordinateX(){
        System.out.println("Enter coordinates(X less then 486)");
        System.out.print("X=");
        Scanner in = new Scanner(System.in);
        Long coordinateX = Long.valueOf(in.nextInt());

        return (coordinateX);
    }
    public Float getCoordinateY(){
        System.out.print("Y=");
        Float coordinateY = in.nextFloat();
        return (coordinateY);
    }

    public Integer getPrice(){
        System.out.println("Enter price product");
        Scanner in = new Scanner(System.in);
        Integer price = in.nextInt();

        return (price);
    }

    public String getPartNumber(){
        System.out.println("Enter part number");
        Scanner in = new Scanner(System.in);
        String partNumber = in.nextLine();

        return (partNumber);
    }

    public Float getManufactureCost(){
        System.out.println("Enter manufacture cost");
        Scanner in = new Scanner(System.in);
        Float manufactureCost = in.nextFloat();

        return (manufactureCost);
    }

    public String getUnitOfMeasure(){

        System.out.println("Enter unit of measure(LITERS, MILLILITERS, GRAMS)");
        Scanner in = new Scanner(System.in);
        String unitOfMeasure = in.nextLine();
        return (unitOfMeasure);

    }
    public String namePerson(){
        System.out.println("Enter name person");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        return (name);
    }

    public LocalDateTime birthdayPerson(){
        System.out.println("Enter birthday person(\"yyyy-MM-dd HH:mm\")");
        Scanner in = new Scanner(System.in);
        String birthday = in.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateBirthday = LocalDateTime.parse(birthday, format);


        return (dateBirthday);
    }

    public Double weightPerson(){
        System.out.println("Enter weight person");
        Double weight = in.nextDouble();
        return (weight);
    }
    public Product getProduct(){
        return new Product(getName(), getPrice(), getPartNumber(), getManufactureCost(),getUnitOfMeasure());
    }

    public void closeScan(){
        in.close();
    }


}
