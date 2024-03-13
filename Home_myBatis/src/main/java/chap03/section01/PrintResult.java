package chap03.section01;

import java.util.List;

public class PrintResult {
    public void selectAllMenu(List<MenuDTO> menuList) {
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
    }

    public void selectMenuByCode(MenuDTO menu) {
        System.out.println(menu);
    }

    public void printErrorMessage(String errorCode) {
        String error = "";
        switch (errorCode){
            case "selectAllMenu" : error = "메뉴 목록 조회 실패"; break;
        }
        System.out.println(error);
    }
}
