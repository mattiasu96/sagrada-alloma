package Logic;

import java.util.Random;

public class Dice {

    private Integer value;
    private char color;


    public Integer getValue() {
        return value;
    }

    public char getColor() {
        return color;
    }

    public void shuffle(){
        Random r = new Random();
         value = r.nextInt(6);
    }
}
