package chap05.xmlmapper;

import chap05.common.CategoryDTO;
import chap05.common.MenuAndCategoryDTO;

import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static TestService testService = new TestService();

    public static void main(String[] args) {
        do{
            System.out.println("==== Mapper Element 테스트 메뉴 ====");
            System.out.println("1. <cache> 테스트\n2. <resultMap> 서브메뉴 ▼\n3. <sql> 테스트\n4. <insert> 서브메뉴");
            System.out.print("메뉴 번호 입력 : ");
            int num = Integer.parseInt(sc.nextLine());

            switch (num){
                case 1 : testService.selectCacheTest(); break;
                case 2 : resultMapSubMenu(); break;
                case 3 : testService.selectSqlTest(); break;
                case 4 : testService.insertCategoryAndMenuTest(inputMenuAndCategory()); break;
            }
        }while(true);
    }

    private static void resultMapSubMenu() {
        do{
            System.out.println("==== <resultMap> 서브메뉴 ====");
            System.out.println("1. <resultMap> 테스트\n2. <constructor> 테스트\n3. <association> 테스트\n4. <collection> 테스트");
            System.out.print("메뉴 번호 입력 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : testService.selectResultMapTest(); break;
                case 2 : testService.selectResultMapConstructorTest(); break;
                case 3 : testService.selectResultMapAssociationTest(); break;
                case 4 : testService.selectResultMapCollectionTest(); break;
            }
        }while(true);
    }

    private static MenuAndCategoryDTO inputMenuAndCategory() {
        System.out.print("신규 카테고리명 입력 : ");
        String categoryName = sc.nextLine();
        System.out.print("등록할 메뉴명 입력 : ");
        String menuName = sc.nextLine();
        System.out.print("등록할 메뉴가격 입력 : ");
        int menuPrice = Integer.parseInt(sc.nextLine());
        System.out.print("판매여부 입력(Y/N) : ");
        String orderableStatus = sc.nextLine();

        CategoryDTO category = new CategoryDTO();
        category.setCategory_name(categoryName);

        MenuAndCategoryDTO menuAndCategory = new MenuAndCategoryDTO();
        menuAndCategory.setName(menuName);
        menuAndCategory.setPrice(menuPrice);
        menuAndCategory.setOrderableStatus(orderableStatus);
        menuAndCategory.setCategory(category);

        return menuAndCategory;
    }
}
