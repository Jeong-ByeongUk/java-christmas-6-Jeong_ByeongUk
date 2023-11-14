package christmas;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    String korName;
    int price;

    Badge(String korName, int price){
        this.korName = korName;
        this.price = price;
    }
}
