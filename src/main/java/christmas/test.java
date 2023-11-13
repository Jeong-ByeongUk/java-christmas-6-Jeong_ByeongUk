package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class test {
    Order testOrder = new Order();

    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "a", "ㄱ"})
    void 날짜_입력_예외처리_테스트(String input){
        assertThatThrownBy(()-> testOrder.inputDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "해산물파스타-0", "해산물파스타2", "해산물파스타-a", "해산물파스타-ㄱ", "해산물파스타-1,", "해산물파스타-1a", "해산물파스타-2, 레드와인-1"})
    void 메뉴_입력_시_형식_예외처리_테스트(String input){

        assertThatThrownBy(()->testOrder.inputMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
