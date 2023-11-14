package christmas;

import java.util.Arrays;

public class Exce {

    void dateException(int input){
        if(input < 1 || input > 31){
            throw new IllegalArgumentException();
        }
    }

    void menuException(String input){
        String[] checkInput = input.split(",|-");

        lastCharException(input);
        dupliException(checkInput);
        for(int i = 0; i < checkInput.length; i = i + 2) {
            nameException(checkInput[i]);
            numException(checkInput[i+1]);
        }
    }

    void lastCharException(String input){
        try{
            Integer.parseInt(input.substring(input.length()-1));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    void dupliException(String[] input){
        int dupli[] = new int[Menu.values().length];
        int index;

        Arrays.fill(dupli, 0);

        for(int i = 0; i < input.length; i = i + 2){
            index = Menu.valueOf(input[i]).ordinal();

            dupli[index] = dupliCheck(dupli, index);
        }
    }

    int dupliCheck(int[] dupli, int index){
        if(dupli[index] != 0){
            throw new IllegalArgumentException();
        }

        return 1;
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

    void drinkException(int[] numOfCourse){
        if(numOfCourse[Course.메인.ordinal()] == 0 && numOfCourse[Course.에피타이저.ordinal()] == 0 && numOfCourse[Course.디저트.ordinal()] == 0){
            throw new IllegalArgumentException();
        }
    }

    void placeException(int[] numOfCourse){
        int sum = Arrays.stream(numOfCourse).sum();

        if(sum > 20){
            throw new IllegalArgumentException();
        }
    }
}
