package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.collection.CollectionManager;
import ru.kostyapetrov.lab_5.console.ConsoleManager;
import ru.kostyapetrov.lab_5.file.FileManager;

import java.util.HashMap;
import java.util.Map;


public class CommandManager{
    protected Map<String,Commandable> map = new HashMap<>();
    public void addCommand(String key,Commandable cmd){

        map.put(key, cmd);

    }
    public void execCommand(String key){

        map.get(key).execute();

    }

    public CommandManager(CollectionManager collectionManager, ConsoleManager consoleManager, FileManager fileManager){

        addCommand("help", new Help(consoleManager));//вывести справку по доступным командам
        addCommand("info", new Info(collectionManager,fileManager, consoleManager));// вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
        addCommand("show", new Show(collectionManager, consoleManager));//вывести в стандартный поток вывода все элементы коллекции в строковом представлении
        addCommand("add", new Add(collectionManager, consoleManager));// добавить новый элемент в коллекцию
        addCommand("update", new UpdateId(collectionManager,consoleManager));//обновить значение элемента коллекции, id которого равен заданному
        addCommand("remove_by_id", new RemoveId(consoleManager, collectionManager));//     : удалить элемент из коллекции по его id
        addCommand("clear", new Clear(consoleManager,collectionManager));//     : очистить коллекцию
        addCommand("save", new Save(fileManager, collectionManager, consoleManager));//     : сохранить коллекцию в файл
//        addCommand("execute_script file_name", new Info());//     : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
        addCommand("exit", new Exit(consoleManager));// : завершить программу (без сохранения в файл)
        addCommand("head", new Head(consoleManager, collectionManager));//     : вывести первый элемент коллекции
        addCommand("add_if_max", new AddIfMax(consoleManager,collectionManager));//     : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
        addCommand("history", new History(consoleManager,collectionManager));//     : вывести последние 15 команд (без их аргументов)
        addCommand("remove_all_by_manufacture_cost", new RemoveWithManufactureCost(consoleManager, collectionManager));//     : удалить из коллекции все элементы, значение поля manufactureCost которого эквивалентно заданному
        addCommand("count_greater_than_unit_of_measure", new CountGreaterThanUnitMeasure(consoleManager, collectionManager));//     : вывести количество элементов, значение поля unitOfMeasure которых больше заданного
//        addCommand("print_field_descending_unit_of_measure", new Info());//    print_field_descending_unit_of_measure

        //addallcommands

    }
}