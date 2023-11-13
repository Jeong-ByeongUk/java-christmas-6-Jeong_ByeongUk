package christmas;

public class Order {
    String menus[];
    String menuName[];
    String menuNum[];
    int totalPrice;

    Order(String input){
        menus = input.split(",|-");
        menuName = nameExtraction(menus);
        menuNum = numExtraction(menus);
    }

    String[] nameExtraction(String[] menus){
        String[] names = new String[menus.length / 2];

        for(int i = 0; i < menus.length; i = i + 2) {
            names[i / 2] = menus[i];
        }

        return names;
    }

    String[] numExtraction(String[] menus){
        String[] nums = new String[menus.length / 2];

        for(int i = 1; i < menus.length; i = i + 2) {
            nums[i / 2] = menus[i];
        }

        return nums;
    }

}
