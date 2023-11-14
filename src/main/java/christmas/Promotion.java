package christmas;

public class Promotion {
    boolean applyPromotion = true;
    boolean freebie = false;
    int dDayDiscount = 0;
    int weekDiscount = 0;
    int specialDiscount = 0;
    int totalPromotionPrice = 0;

    void promotionCheck(int totalPrice){
        if(totalPrice < 10000) {
            applyPromotion = false;
        }
    }

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

    void specialCheck(int date){
        Week[] weeks = Week.values();
        Week dateOfWeek = weeks[date % weeks.length];

        if(dateOfWeek.equals(Week.SUN) || date == 25){
            specialDiscount = 1000;
        }
    }

    void sumPromotionPrice(){
        int freebiePrice = 0;

        if(freebie){
            freebiePrice = Menu.샴페인.getNumPrice();
        }
        totalPromotionPrice = dDayDiscount + weekDiscount + specialDiscount + freebiePrice;
    }

    Badge badgeCheck(){
        if(totalPromotionPrice > Badge.SANTA.price){
            return Badge.SANTA;
        }
        else if(totalPromotionPrice > Badge.TREE.price){
            return Badge.TREE;
        }
        else if(totalPromotionPrice > Badge.STAR.price){
            return Badge.STAR;
        }
        return null;
    }
}
