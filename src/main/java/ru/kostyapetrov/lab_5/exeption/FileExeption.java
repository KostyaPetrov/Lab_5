package ru.kostyapetrov.lab_5.exeption;



import java.io.IOException;

public class FileExeption extends IOException {
    public FileExeption(String s){
        super(s);
    }
}
