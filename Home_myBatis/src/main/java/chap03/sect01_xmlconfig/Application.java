package chap03.sect01_xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MenuController menuController = new MenuController();

        do {
            System.out.println("==== 메뉴관리 ====");
            System.out.println("1.메뉴전체조회\n2.메뉴코드로 메뉴조회\n3.신규메뉴추가\n4.메뉴수정\n5.메뉴삭제");
            System.out.print("메뉴관리번호 입력 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : menuController.selectAllMenu(); break;
                case 2 : menuController.selectMenuByCode(inputMenuCode()); break;
                case 3 : menuController.registMenu(inputMenu()); break;
                case 4 : menuController.modifyMenu(inputModifyMenu()); break;
                case 5 : menuController.deleteMenu(inputMenuCode()); break;
                default :
                    System.out.println("잘못된 메뉴 선택");
                    break;
            }

        }while (true);
    }

    private static int inputMenuCode() {
        System.out.print("메뉴코드 입력 : ");
        int code = sc.nextInt();
        sc.nextLine();

        return code;
    }

    private static Map<String, String> inputMenu() {
        System.out.print("메뉴이름 입력 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴가격 입력 : ");
        String menuPrice = sc.nextLine();
        System.out.print("카테고리코드 입력 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static MenuDTO inputModifyMenu() {
        System.out.print("수정할 메뉴코드 입력 : ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 메뉴이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("수정할 메뉴가격 입력 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 카테고리코드 입력 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 메뉴 주문상태 입력 : ");
        String order = sc.nextLine();

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCode(code);
        menuDTO.setName(name);
        menuDTO.setPrice(price);
        menuDTO.setCategoryCode(categoryCode);
        menuDTO.setOrderableStatus(order);

        return menuDTO;
    }
}
