package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void opening(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("주문 시 아래의 주의사항을 확인해 주세요!");
        System.out.println("< 주의사항 >");
        System.out.println("1. 총 주문 금액이 10,000원 이상부터 이벤트가 적용됩니다.");
        System.out.println("2. 음료만 주문시, 주문할 수 없습니다.");
        System.out.println("3. 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n");
    }

    public int readDate() {
        int input;

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        while(true) {
            try {
                input = Integer.parseInt(Console.readLine());
                dateExpt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return input;
    }

    void dateExpt(int date){
        if(date < 1 || date > 31){
            throw new IllegalArgumentException();
        }
    }

    public Order resdMenu(){
        String input;
        Order check;

        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while(true) {
            try {
                input = Console.readLine();
                check = new Order(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }

        return check;
    }
}
