package collection;

import java.time.LocalDateTime;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле может быть null
    private Double weight; //Поле не может быть null, Значение поля должно быть больше 0

    public Person(String name, LocalDateTime birthday, Double weight) {
        this.name=name;
        this.birthday=birthday;
        this.weight=weight;
    }
    public String getNamePerson(){
        return name;
    }
    public LocalDateTime getBirthday(){
        return birthday;
    }
    public Double getWeight(){
        return weight;
    }
}
