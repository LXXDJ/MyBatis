package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{
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
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static Map<String, String> inputMenuCode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴코드 입력 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("메뉴가격 입력 : ");
        String price = sc.nextLine();
        System.out.print("카테고리코드 입력 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴코드 입력 : ");
        String code = sc.nextLine();
        System.out.print("수정할 메뉴이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("수정할 메뉴가격 입력 : ");
        String price = sc.nextLine();
        System.out.print("수정할 카테고리코드 입력 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }
}
