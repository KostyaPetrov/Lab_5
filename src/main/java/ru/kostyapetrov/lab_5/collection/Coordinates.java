package collection;

public class Coordinates {
    private long x; //Максимальное значение поля: 485
    private float y;


    public Coordinates(long x, float y) {
        this.x=x;
        this.y=y;

    }
    public Long getX(){
        return x;
    }
    public Float getY(){
        return y;
    }

}