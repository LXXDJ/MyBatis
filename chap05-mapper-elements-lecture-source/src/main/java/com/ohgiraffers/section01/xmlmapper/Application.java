package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do{
            System.out.println("==== Mapper Element 테스트 메뉴 ====");
            System.out.println("1. <cache> 테스트\n2. <resultMap> 서브메뉴\n3. <sql> 테스트\n4. <insert> 서브메뉴");
            System.out.print("메뉴 번호 입력 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : elementTestService.selectCacheTest(); break;
                case 2 : resultMapSubMenu(); break;
                case 3 : elementTestService.selectSqlTest(); break;
                case 4 : elementTestService.insertCategoryAndMenuTest(inputMenuAndCategory()); break;
            }
        }while(true);
    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do{
            System.out.println("==== <resultMap> 서브메뉴 ====");
            System.out.println("1. <resultMap> 테스트\n2. <constructor> 테스트\n3. <association> 테스트\n4. <collection> 테스트");
            System.out.print("메뉴 번호 입력 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : elementTestService.selectResultMapTest(); break;
                case 2 : elementTestService.selectResultMapConstructorTest(); break;
                case 3 : elementTestService.selectResultMapAssociationTest(); break;
                case 4 : elementTestService.selectResultMapCollectionTest(); break;
            }
        }while(true);
    }

    private static MenuAndCategoryDTO inputMenuAndCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 카테고리명 입력 : ");
        String categoryName = sc.nextLine();
        System.out.print("등록할 메뉴명 입력 : ");
        String menuName = sc.nextLine();
        System.out.print("등록할 메뉴가격 입력 : ");
        int menuPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("판매여부 입력(Y/N) : ");
        String orderableStatus = sc.nextLine();

        MenuAndCategoryDTO menuAndCategory = new MenuAndCategoryDTO();
        CategoryDTO category = new CategoryDTO();

        category.setName(categoryName);

        menuAndCategory.setCategory(category);
        menuAndCategory.setPrice(menuPrice);
        menuAndCategory.setName(menuName);
        menuAndCategory.setOrderableStatus(orderableStatus);

        return menuAndCategory;
    }
}
