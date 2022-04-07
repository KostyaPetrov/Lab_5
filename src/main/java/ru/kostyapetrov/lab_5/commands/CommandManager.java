package commands;
import collection.CollectionManager;
import console.ConsoleManager;
import file.FileManager;

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
        addCommand("info", new Info());// вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
//        addCommand("show", new Info());//вывести в стандартный поток вывода все элементы коллекции в строковом представлении
        addCommand("add", new Add(collectionManager, consoleManager));// добавить новый элемент в коллекцию
//        addCommand("update id {element}", new Info());//обновить значение элемента коллекции, id которого равен заданному
//        addCommand("remove_by_id id", new Info());//     : удалить элемент из коллекции по его id
//        addCommand("clear", new Info());//     : очистить коллекцию
        addCommand("save", new Save(fileManager, collectionManager, consoleManager));//     : сохранить коллекцию в файл
//        addCommand("execute_script file_name", new Info());//     : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
        addCommand("exit", new Exit(consoleManager));// : завершить программу (без сохранения в файл)
//        addCommand("head", new Info());//     : вывести первый элемент коллекции
//        addCommand("add_if_max {element}", new Info());//     : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
//        addCommand("history", new Info());//     : вывести последние 15 команд (без их аргументов)
//        addCommand("remove_all_by_manufacture_cost manufactureCost", new Info());//     : удалить из коллекции все элементы, значение поля manufactureCost которого эквивалентно заданному
//        addCommand("count_greater_than_unit_of_measure unitOfMeasure", new Info());//     : вывести количество элементов, значение поля unitOfMeasure которых больше заданного
//        addCommand("print_field_descending_unit_of_measure", new Info());//    print_field_descending_unit_of_measure

        //addallcommands

    }
}