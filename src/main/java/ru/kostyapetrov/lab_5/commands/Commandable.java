package commands;

public interface Commandable {

    void execute(String arg);
    public default void execute(){
        execute(null);
    }
}
