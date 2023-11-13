package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class test {
    Order testOrder;

    @Test
    void 메뉴_이름_분리(){
        String testinput = "가-1,나-2,다-3,라-4";
        String[] testname;
        testOrder = new Order(testinput);

        testname = testOrder.nameExtraction(testOrder.menus);

        assertThat(testname).contains("가", "나", "다", "라");
    }

    @Test
    void 메뉴_개수_분리(){
        String testinput = "가-1,나-2,다-3,라-4";
        String[] testname;
        testOrder = new Order(testinput);

        testname = testOrder.numExtraction(testOrder.menus);

        assertThat(testname).contains("1", "2", "3", "4");
    }
}
