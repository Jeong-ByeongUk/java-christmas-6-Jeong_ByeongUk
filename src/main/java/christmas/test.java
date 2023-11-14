package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
    @ValueSource(strings = {"1", "해산물파스타-0", "해산물파스타2", "해산물파스타-a", "해산물파스타-ㄱ", "해산물파스타-1,", "해산물파스타-1a", "해산물파스타-2, 레드와인-1", "해산물파스타-2,해산물파스타-1"})
    void 메뉴_입력_시_형식_예외처리_테스트(String input){

        assertThatThrownBy(()->testOrder.inputMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("testMenu")
    void 메뉴_개수_저장_테스트(String input, int[] output){
        testOrder.inputMenu(input);

        assertThat(testOrder.numOfMenu).isEqualTo(output);
    }

    static Stream<Arguments> testMenu(){
        return Stream.of(
                Arguments.arguments("해산물파스타-1", new int[]{0,0,0,0,0,1,0,0,0,0,0,0}),
                Arguments.arguments("해산물파스타-2", new int[]{0,0,0,0,0,2,0,0,0,0,0,0}),
                Arguments.arguments("해산물파스타-1,레드와인-1", new int[]{0,0,0,0,0,1,0,0,0,0,1,0}),
                Arguments.arguments("해산물파스타-1,레드와인-1,샴페인-1", new int[]{0,0,0,0,0,1,0,0,0,0,1,1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCourse")
    void 코스_개수_저장_테스트(String input, int[] output){
        testOrder.inputMenu(input);

        assertThat(testOrder.numOfCourse).isEqualTo(output);
    }

    static Stream<Arguments> testCourse(){
        return Stream.of(
                Arguments.arguments("해산물파스타-1", new int[]{0,1,0,0}),
                Arguments.arguments("해산물파스타-2", new int[]{0,2,0,0}),
                Arguments.arguments("해산물파스타-1,레드와인-1", new int[]{0,1,0,1}),
                Arguments.arguments("해산물파스타-1,레드와인-1,샴페인-2", new int[]{0,1,0,3})
        );
    }
}
