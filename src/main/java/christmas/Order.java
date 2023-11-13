package christmas;

import java.util.Arrays;

public class Order {
    int date;

    void inputDate(String input){
        date = Integer.parseInt(input);
        dateException(date);
    }

    void dateException(int input){
        if(input < 1 || input > 31){
            throw new IllegalArgumentException();
        }
    }
}

