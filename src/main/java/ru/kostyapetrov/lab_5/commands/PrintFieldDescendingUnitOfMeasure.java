package ru.kostyapetrov.lab_5.commands;

import ru.kostyapetrov.lab_5.console.ConsoleManager;

public class PrintFieldDescendingUnitOfMeasure implements Commandable{
    private ConsoleManager consoleManager;
    public PrintFieldDescendingUnitOfMeasure(ConsoleManager consoleManager){
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){

        consoleManager.getCommand();
    }
}
