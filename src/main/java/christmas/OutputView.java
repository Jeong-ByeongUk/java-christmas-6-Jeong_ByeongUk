package christmas;

import java.text.DecimalFormat;

public class OutputView {
    DecimalFormat df = new DecimalFormat("###,###");

    public void opening(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("주문 시 아래의 주의사항을 확인해 주세요!");
        System.out.println("< 주의사항 >");
        System.out.println("1. 총 주문 금액이 10,000원 이상부터 이벤트가 적용됩니다.");
        System.out.println("2. 음료만 주문시, 주문할 수 없습니다.");
        System.out.println("3. 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n");
    }

    public void result(Order customerOrder, Promotion reastaurantPromotion){
        System.out.println("12월" + customerOrder.date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("");
        System.out.println("<주문 메뉴>");
        printMenu(customerOrder.numOfMenu);
        System.out.println("");
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(df.format(customerOrder.totalPrice) + "원");
        System.out.println("");
        System.out.println("<증정 메뉴>");
        printFreebie(reastaurantPromotion.freebie);
        System.out.println("");
        System.out.println("<혜택 내역>");
        printPromotion(customerOrder,reastaurantPromotion);
        System.out.println("");
        System.out.println("<총혜택 금액>");
        System.out.println(df.format(reastaurantPromotion.totalPromotionPrice) + "원");
        System.out.println("");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(df.format(customerOrder.totalPrice + reastaurantPromotion.totalDiscountPrice) + "원");
        System.out.println("");
        System.out.println("<12월 이벤트 배지>");
        printBadge(reastaurantPromotion);
    }

    private void printMenu(int[] numOfMenu){
        Menu[] menus = Menu.values();
        for(int i = 0; i < menus.length; i++){
            menucheck(numOfMenu, menus, i);
        }
    }

    private void menucheck(int[] numOfMenu, Menu[] menus, int index){
        if(numOfMenu[menus[index].ordinal()] != 0) {
            System.out.println(menus[index] + " " + numOfMenu[menus[index].ordinal()] + "개");
        }
    }

    private void printFreebie(boolean freebie){
        if(freebie){
            System.out.println("샴페인 1개");
        }
        if(!freebie){
            System.out.println("없음");
        }
    }

    private void printPromotion(Order customerOrder, Promotion restaurantPromotion){
        if(restaurantPromotion.dDayDiscount != 0){
            System.out.println("크리스마스 디데이 할인: " + df.format(restaurantPromotion.dDayDiscount) + "원");
        }
        if(restaurantPromotion.weekDiscount != 0){
            System.out.println(customerOrder.orderWeek.getWeekly() + " 할인: " + df.format(restaurantPromotion.weekDiscount) + "원");
        }
        if(restaurantPromotion.specialDiscount != 0){
            System.out.println("특별 할인: " + df.format(restaurantPromotion.specialDiscount) + "원");
        }
        if(restaurantPromotion.freebie){
            System.out.println("증정 이벤트: -25,000원");
        }
        else if(restaurantPromotion.totalPromotionPrice == 0){
            System.out.println("없음");
        }
    }

    private void printBadge(Promotion restaurantPromotion){
        if(restaurantPromotion.badgeCheck() == null){
            System.out.println("없음");
        }
        if(restaurantPromotion.badgeCheck() != null){
            System.out.println(restaurantPromotion.badgeCheck().getKorName());
        }
    }
}