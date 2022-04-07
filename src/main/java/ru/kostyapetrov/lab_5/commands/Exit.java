package commands;
import console.ConsoleManager;

public class Exit implements Commandable {
    private ConsoleManager consoleManager;
    public Exit(ConsoleManager consoleManager){
        this.consoleManager=consoleManager;
    }
    @Override
    public void execute(String s){

        System.out.println("Have a good day!");
        consoleManager.closeScan();
    }
}
