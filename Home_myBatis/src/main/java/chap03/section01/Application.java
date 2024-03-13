package chap03.section01;

import java.awt.*;
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
}
