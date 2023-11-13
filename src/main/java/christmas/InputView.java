package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void readDate(Order customerOrder) {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while(true) {
            try {
                customerOrder.inputDate(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }
}
