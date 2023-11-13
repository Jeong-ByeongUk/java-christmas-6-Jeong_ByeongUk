package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        OutputView output = new OutputView();
        Order customerOrder = new Order();

        output.opening();
        input.readDate(customerOrder);
    }
}
