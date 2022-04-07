package ru.kostyapetrov.lab_5.commands;


import ru.kostyapetrov.lab_5.console.ConsoleManager;

public class RemoveById implements Commandable {
    private ConsoleManager consoleManager;
    private Integer removeId;
    public RemoveById(ConsoleManager consoleManager){
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){
        removeId=consoleManager.getRemoveId();


        consoleManager.getCommand();
    }

}
