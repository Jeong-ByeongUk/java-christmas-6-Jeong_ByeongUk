package christmas;

import java.util.Arrays;

public class Order {
    int date;

    void inputDate(int input){
        dateException(input);
        date = input;
    }

    void dateException(int input){
        if(input < 1 || input > 31){
            throw new IllegalArgumentException();
        }
    }
}

