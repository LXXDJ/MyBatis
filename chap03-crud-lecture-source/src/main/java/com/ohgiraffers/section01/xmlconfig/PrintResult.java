package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList) {
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "selectList" : errorMessage = "메뉴 목록 조회 실패"; break;
            case "selectOne" : errorMessage = "메뉴 조회 실패"; break;
            case "insert" : errorMessage = "신규메뉴 등록 실패"; break;
            case "update" : errorMessage = "메뉴 수정 실패"; break;
            case "delete" : errorMessage = "메뉴 삭제 실패"; break;
        }
        System.out.println(errorMessage);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println(menu);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode){
            case "insert" : successMessage = "신규메뉴 등록 성공"; break;
            case "update" : successMessage = "메뉴 수정 성공"; break;
            case "delete" : successMessage = "메뉴 삭제 성공"; break;
        }
        System.out.println(successMessage);
    }
}
