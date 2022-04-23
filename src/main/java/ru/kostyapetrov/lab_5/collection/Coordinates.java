package ru.kostyapetrov.lab_5.collection;


public class Coordinates {
    private long x; //Максимальное значение поля: 485
    private float y;


    public Coordinates(long x, float y) {
        this.x=x;
        this.y=y;

    }
    @Override
    public String toString(){
        return String.format("%s,%s",x,y);
    }
}