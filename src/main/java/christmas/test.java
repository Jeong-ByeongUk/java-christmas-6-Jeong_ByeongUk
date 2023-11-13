package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class test {
    Order testOrder;

    @Test
    void 메뉴_이름_분리_테스트(){
        String testinput = "가-1,나-2,다-3,라-4";
        String[] testname;
        testOrder = new Order(testinput);

        testname = testOrder.nameExtraction(testOrder.menus);

        assertThat(testname).contains("가", "나", "다", "라");
    }

    @Test
    void 메뉴_개수_분리_테스트(){
        String testinput = "가-1,나-2,다-3,라-4";
        int[] testnum;
        testOrder = new Order(testinput);

        testnum = testOrder.numExtraction(testOrder.menus);

        assertThat(testnum).contains(1, 2, 3, 4);
    }

    @ParameterizedTest
    @MethodSource("menuAndCourse")
    void 메뉴_코스_분리_테스트(String input, int[] output){
       String[] testname;
        testOrder = new Order(input);

        testname = testOrder.nameExtraction(testOrder.menus);

        testOrder.courseExtraction();

        assertThat(testOrder.courseNum).isEqualTo(output);
    }

    static Stream<Arguments> menuAndCourse(){
        return Stream.of(
            Arguments.arguments("양송이수프-1,티본스테이크-2,아이스크림-3,샴페인-4", new int[] {1, 2, 3, 4}),
            Arguments.arguments("양송이수프-1,티본스테이크-2,아이스크림-3,초코케이크-4", new int[]{1, 2, 7, 0}),
            Arguments.arguments("양송이수프-1,타파스-2", new int[]{3, 0, 0, 0})
        );
    }
}
