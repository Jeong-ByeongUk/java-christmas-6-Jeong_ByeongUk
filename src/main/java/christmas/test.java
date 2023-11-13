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

}
