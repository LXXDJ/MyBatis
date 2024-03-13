package chap03.section02;

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
    public void printError(String errorCode) {
        String errorMs = "";
        switch (errorCode){
            case "selectAllMenu" : errorMs = "전체 메뉴 조회 실패"; break;
            case "selectMenuByCode" : errorMs = "메뉴 조회 실패"; break;
            case "registMenu" : errorMs = "메뉴 등록 실패"; break;
            case "modifyMenu" : errorMs = "메뉴 수정 실패"; break;
            case "deleteMenu" : errorMs = "메뉴 삭제 실패"; break;
        }
        System.out.println(errorMs);
    }

    public void printSuccess(String successCode) {
        String successMs = "";
        switch (successCode){
            case "registMenu" : successMs = "메뉴 등록 성공"; break;
            case "modifyMenu" : successMs = "메뉴 수정 성공"; break;
            case "deleteMenu" : successMs = "메뉴 삭제 성공"; break;
        }
        System.out.println(successMs);
    }
}
