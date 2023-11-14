package christmas;

public class Promotion {
    boolean freebie = false;

    void freebieCheck(int totalPrice){
        if(totalPrice >= 120000){
            freebie = true;
        }
    }
}
