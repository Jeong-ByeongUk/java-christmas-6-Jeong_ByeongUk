package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class UnitTest {
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
                Arguments.arguments("양송이수프-1,레드와인-1", new int[]{1,0,0,1}),
                Arguments.arguments("초코케이크-1,레드와인-1,샴페인-2", new int[]{0,0,1,3})
        );
    }

    @ParameterizedTest
    @MethodSource("testPrice")
    void 총_금액_합산_테스트(String input, int output){
        testOrder.inputMenu(input);

        assertThat(testOrder.totalPrice).isEqualTo(output);
    }

    static Stream<Arguments> testPrice(){
        return Stream.of(
                Arguments.arguments("해산물파스타-1", 35000),
                Arguments.arguments("해산물파스타-2", 70000),
                Arguments.arguments("해산물파스타-1,레드와인-1", 95000),
                Arguments.arguments("해산물파스타-1,레드와인-1,샴페인-2", 145000),
                Arguments.arguments("크리스마스파스타-1,초코케이크-1,제로콜라-2", 46000)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"레드와인-1", "샴페인-1", "제로콜라-1", "제로콜라-1,레드와인-3"})
    void 음료만_주문_시_예외처리_테스트(String input){

        assertThatThrownBy(()->testOrder.inputMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-21", "티본스테이크-10,바비큐립-10,샴페인-1"})
    void 메뉴_스무개_초과_주문_시_예외처리_테스트(String input){

        assertThatThrownBy(()->testOrder.inputMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"})
    void 주말_확인_테스트(String input){
        Week testWeek = Week.valueOf(input);

        assertThat(testWeek.getWeekly()).isEqualTo("주말");
    }

    @ParameterizedTest
    @MethodSource("testWeekDiscount")
    void 평일_주말_할인_이벤트_테스트(String menu, int date, int output){
        Promotion testPro = new Promotion();

        testOrder.inputMenu(menu);
        testOrder.date = date;

        testPro.weekCheck(testOrder);

        assertThat(testPro.weekDiscount).isEqualTo(output);
    }

    static Stream<Arguments> testWeekDiscount(){
        return Stream.of(
                Arguments.arguments("해산물파스타-1", 1, 2023),
                Arguments.arguments("해산물파스타-2", 1, 4046),
                Arguments.arguments("초코케이크-1", 1, 0),
                Arguments.arguments("초코케이크-1", 3, 2023),
                Arguments.arguments("해산물파스타-1,초코케이크-1", 1, 2023),
                Arguments.arguments("해산물파스타-1,초코케이크-1", 3, 2023)
        );
    }
}
