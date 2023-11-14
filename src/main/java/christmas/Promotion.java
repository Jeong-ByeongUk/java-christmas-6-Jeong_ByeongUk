package christmas;

public class Promotion {
    boolean freebie = false;
    int dDayDiscount;
    int weekDiscount;

    void freebieCheck(int totalPrice){
        if(totalPrice >= 120000){
            freebie = true;
        }
    }

    void dDayCheck(int date){
        if(date > 25) {
            return;
        }
        dDayDiscount = 900 + date * 100;
    }

    void weekCheck(Order customerOrder){
        Week[] weeks = Week.values();
        Week dateOfWeek = weeks[customerOrder.date % weeks.length];

        if(dateOfWeek.checkWeekend()){
            weekDiscount = customerOrder.numOfCourse[Course.메인.ordinal()] * 2023;
        }
        else if(!dateOfWeek.checkWeekend()){
            weekDiscount = customerOrder.numOfCourse[Course.디저트.ordinal()] * 2023;
        }
    }
}
