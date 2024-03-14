package chap04.sect01;

import java.util.Scanner;

public class Application {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MenuService menuService = new MenuService();

        do{
            System.out.println("==== trim 서브메뉴 ====");
            System.out.println("1. 검색조건이 있는 경우 메뉴코드로 조회, 없으면 전체 조회");
            System.out.println("2. 메뉴명 혹은 카테고리 코드로 검색, 메뉴와 카테고리가 일치하는 경우도 검색, 검색조건이 없는 경우 전체검색");
            System.out.println("3. 원하는 메뉴 정보만 수정");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
//                case 1 : menuService.searchMenuByCodeOrSearchAll(inputAllOrOne()); break;
//                case 2 : menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 3 : menuService.modifyMenu(inputChangeInfo()); break;
                case 9 : return;
            }

        } while(true);
    }

    private static MenuDTO inputChangeInfo() {
        System.out.print("변경할 메뉴 코드 입력 : ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("변경할 메뉴 이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("변경할 메뉴 가격 입력 : ");
        int price = sc.nextInt();
        sc.nextLine();
//        System.out.print("변경할 카테고리 코드 입력 : ");
//        int categoryCode = Integer.parseInt(sc.nextLine());
        System.out.print("판매여부 입력(Y/N) : ");
        String order = sc.nextLine();

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCode(code);
        menuDTO.setName(name);
        menuDTO.setPrice(price);
//        menuDTO.setCategoryCode(categoryCode);
        menuDTO.setOrderableStatus(order);

        return menuDTO;
    }


}
