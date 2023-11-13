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

    void inputMenu(String input){
        String[] menus = input.split(",|-");

        lastCharException(input);
        for(int i = 0; i < menus.length; i = i + 2) {
            nameException(menus[i]);
            numException(menus[i+1]);
        }
    }

    void lastCharException(String input){
        try{
            Integer.parseInt(input.substring(input.length()-1));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    void nameException(String input){
        Menu.valueOf(input);
    }

    void numException(String input){
        int check;
        try {
            check = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if(check < 1) {
            throw new IllegalArgumentException();
        }
    }
}

