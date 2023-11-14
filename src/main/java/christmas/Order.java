package christmas;

import java.util.Arrays;

public class Order {
    Exce exce = new Exce();
    int date;
    int numOfMenu[] = new int[Menu.values().length];
    int numOfCourse[] = new int[Course.values().length];
    int totalPrice = 0;

    void inputDate(String input){
        date = Integer.parseInt(input);
        exce.dateException(date);
    }

    void inputMenu(String input){
        String[] menus;

        exce.menuException(input);

        menus = input.split(",|-");

        Arrays.fill(numOfMenu, 0);
        Arrays.fill(numOfCourse, 0);
        for(int i = 0; i < menus.length; i = i + 2) {
            stareNumOfMenu(menus[i], menus[i+1]);
            stareNumOfCourse(menus[i], menus[i+1]);
        }

        exce.drinkException(numOfCourse);
        exce.placeException(numOfCourse);

        sumPrice();
    }

    void stareNumOfMenu(String name, String num){
        int index = Menu.valueOf(name).ordinal();
        numOfMenu[index] = Integer.parseInt(num);
    }

    void stareNumOfCourse(String name, String num){
        String courseName = Menu.valueOf(name).getCourse();
        int index = Course.valueOf(courseName).ordinal();
        numOfCourse[index] += Integer.parseInt(num);
    }

    void sumPrice(){
        Menu[] checkPrice = Menu.values();

        for(int i = 0; i < numOfMenu.length; i++){
            totalPrice += checkPrice[i].getNumPrice() * numOfMenu[i];
        }
    }
}

