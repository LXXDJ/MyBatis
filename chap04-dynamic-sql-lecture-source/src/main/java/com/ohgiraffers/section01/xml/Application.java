package com.ohgiraffers.section01.xml;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("==== MyBatis 동적 SQL ====");
            System.out.println("1.if 확인하기\n2.choose(when, otherwise) 확인하기\n3.foreach 확인하기\n4.trim(where,set)확인하기\n9.종료");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : ifSubMenu(); break;
                case 2 : chooseSubMenu(); break;
                case 3 : foreachSubMenu(); break;
                case 4 : break;
                case 9 :
                    System.out.println("프로그램 종료"); return;
            }
        } while(true);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("==== if 서브메뉴 ====");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : menuService.selectMenuByPrice(inputPrice()); break;
                case 2 : menuService.searchMenu(inputSearchCriteria()); break;
                case 9 : return;
            }
        }while (true);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 최대금액 입력 : ");
        int price = sc.nextInt();
        sc.nextLine();

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색기준 입력(name or category) : ");
        String condition = sc.nextLine();
        System.out.print("검색어 입력 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("==== choose 서브메뉴 ====");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : menuService.searchMenuBySuperCategory(inputSuperCategory()); break;
                case 9 : return;
            }

        } while(true);
    }

    private static SearchCriteria inputSuperCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위분류 입력 : ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void foreachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("==== foreach 서브메뉴 ====");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1 : menuService.searchMenubyRandomMenuCode(createRandomMenuCodeList()); break;
                case 9 : return;
            }

        } while(true);
    }

    private static List<Integer> createRandomMenuCodeList() {
        Set<Integer> set = new HashSet<>();
        while(set.size() < 5){
            int temp = ((int)(Math.random() * 23)) + 1;
            set.add(temp);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }
}
