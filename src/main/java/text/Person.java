package text;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Person {

    public Person(String name, double weight, double height) throws Exception {
        this.name = name;

        if (weight < 0) throw new Exception("Weight must be more than zero!");
        if (height < 0) throw new Exception("Height must be more than zero!");

        this.weight = weight;
        this.height = height;
    }

    private String name;
    private double weight;
    private double height;
}
