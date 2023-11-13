package christmas;

public class Order {
    String menus[];
    String menuName[];
    int menuNum[];
    int courseNum[];

    Order(String input){
        menus = input.split(",|-");
        menuName = nameExtraction(menus);
        menuNum = numExtraction(menus);
        courseExtraction();
    }

    String[] nameExtraction(String[] menus){
        String[] names = new String[menus.length / 2];

        for(int i = 0; i < menus.length; i = i + 2) {
            names[i / 2] = menus[i];
        }

        return names;
    }

    int[] numExtraction(String[] menus){
        int[] nums = new int[menus.length / 2];

        for(int i = 1; i < menus.length; i = i + 2) {
            nums[i / 2] = Integer.parseInt(menus[i]);
        }

        return nums;
    }

    void courseExtraction(){
        Menu nameOfMenu;
        Course nameOfCourse;
        int index;

        initMenuCourse();

        for(int i = 0; i < menuName.length; i++) {
            nameOfMenu = Menu.valueOf(menuName[i]);
            nameOfCourse = Course.valueOf(nameOfMenu.getCourse());
            index = nameOfCourse.ordinal();
            courseNum[index] = courseNum[index] + menuNum[i];
        }
    }

    void initMenuCourse(){
        courseNum = new int[Course.values().length];

        for(int i = 0; i < courseNum.length; i++){
            courseNum[i] = 0;
        }
    }
}
