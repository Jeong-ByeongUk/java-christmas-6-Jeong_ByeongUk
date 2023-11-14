package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        OutputView output = new OutputView();
        Order customerOrder = new Order();
        Promotion restaurantPromotion = new Promotion();

        output.opening();
        input.readDate(customerOrder);
        input.readMenu(customerOrder);
        restaurantPromotion.promotionCheck(customerOrder.totalPrice);
        if(restaurantPromotion.applyPromotion) {
            restaurantPromotion.freebieCheck(customerOrder.totalPrice);
            restaurantPromotion.dDayCheck(customerOrder.date);
            restaurantPromotion.weekCheck(customerOrder);
            restaurantPromotion.specialCheck(customerOrder);
            restaurantPromotion.sumPromotionPrice();
            restaurantPromotion.badgeCheck();
        }
        output.result(customerOrder, restaurantPromotion);
    }
}
