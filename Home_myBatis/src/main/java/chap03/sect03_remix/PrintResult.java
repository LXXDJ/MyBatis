package chap03.sect03_remix;

import java.util.List;

public class PrintResult {
    public void selectAllMenu(List<MenuDTO> menuList) {
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
    }

    public void selectMenuByCode(MenuDTO menuDTO) {
        System.out.println(menuDTO);
    }

    public void printError(String message) {
        String error = "";
        switch (message){
            case "selectAllMenu" : error = "전체 메뉴 조회 실패"; break;
            case "selectMenuByCode" : error = "메뉴 조회 실패"; break;
            case "registMenu" : error = "메뉴 추가 실패"; break;
            case "modifyMenu" : error = "메뉴 수정 실패"; break;
            case "deleteMenu" : error = "메뉴 삭제 실패"; break;
        }
        System.out.println(error);
    }

    public void printSuccess(String message) {
        String success = "";
        switch (message){
            case "registMenu" : success = "메뉴 추가 성공"; break;
            case "modifyMenu" : success = "메뉴 수정 성공"; break;
            case "deleteMenu" : success = "메뉴 삭제 성공"; break;
        }
        System.out.println(success);
    }
}
