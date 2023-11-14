package christmas;

public class Promotion {
    boolean applyPromotion = true;
    boolean freebie = false;
    int dDayDiscount = 0;
    int weekDiscount = 0;
    int specialDiscount = 0;
    int totalDiscountPrice = 0;
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
        dDayDiscount = -(900 + date * 100);
    }

    void weekCheck(Order customerOrder){
        Week dateOfWeek = customerOrder.orderWeek;

        if(dateOfWeek.getWeekly().equals("주말")){
            weekDiscount = -(customerOrder.numOfCourse[Course.메인.ordinal()] * 2023);
        }
        if(dateOfWeek.getWeekly().equals("평일")){
            weekDiscount = -(customerOrder.numOfCourse[Course.디저트.ordinal()] * 2023);
        }
    }

    void specialCheck(Order customerOrder){
        Week dateOfWeek = customerOrder.orderWeek;

        if(dateOfWeek.getKor().equals("일") || customerOrder.date == 25){
            specialDiscount = -1000;
        }
    }

    void sumPromotionPrice(){
        int freebiePrice = 0;

        if(freebie){
            freebiePrice = -(Menu.샴페인.getNumPrice());
        }
        totalDiscountPrice = dDayDiscount + weekDiscount + specialDiscount;
        totalPromotionPrice = totalDiscountPrice + freebiePrice;
    }

    Badge badgeCheck(){
        if(totalPromotionPrice < Badge.SANTA.getPrice()){
            return Badge.SANTA;
        }
        else if(totalPromotionPrice < Badge.TREE.getPrice()){
            return Badge.TREE;
        }
        else if(totalPromotionPrice < Badge.STAR.getPrice()){
            return Badge.STAR;
        }
        return null;
    }
}
