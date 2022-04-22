package ru.kostyapetrov.lab_5.exeption;

public class CommandExeption extends RuntimeException{
    public CommandExeption(String s){
        super(s);
    }
}
