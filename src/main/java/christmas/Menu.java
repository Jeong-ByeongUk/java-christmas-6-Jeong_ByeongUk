package christmas;

public enum Menu {
    양송이수프("(6,000)", 6000, "에피타이저"),
    타파스("(5,500)", 5500, "에피타이저"),
    시저샐러드("(8,000)", 8000, "에피타이저"),
    티본스테이크("(55,000)", 55000, "메인"),
    바비큐립( "(54,000)", 54000, "메인"),
    해산물파스타("(35,000)", 35000, "메인"),
    크리스마스파스타("(25,000)", 25000, "메인"),
    초코케이크("(15,000)", 15000, "디저트"),
    아이스크림("(5,000)", 5000, "디저트"),
    제로콜라("(3,000)", 3000, "음료"),
    레드와인("(60,000)", 60000, "음료"),
    샴페인("(25,000)", 25000, "음료");

    private String price;
    private int numPrice;
    private String course;

    Menu(String price, int numPrice, String course){
        this.price = price;
        this.numPrice = numPrice;
        this.course = course;
    }

    String getPrice(){
        return price;
    }

    int getNumPrice(){
        return numPrice;
    }

    String getCourse(){
        return course;
    }
}
