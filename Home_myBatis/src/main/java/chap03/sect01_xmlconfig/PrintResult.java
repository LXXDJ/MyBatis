package chap03.sect01_xmlconfig;

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
            case "modifyMenu" : error = "메뉴 수정 실패"; break;
            case "deleteMenu" : error = "메뉴 삭제 실패"; break;
        }
        System.out.println(error);
    }

    public void printSuccessMessage(String successCode) {
        String success = "";
        switch (successCode){
            case "registMenu" : success = "메뉴 등록 성공"; break;
            case "modifyMenu" : success = "메뉴 수정 성공"; break;
            case "deleteMenu" : success = "메뉴 삭제 성공"; break;
        }
        System.out.println(success);
    }
}
