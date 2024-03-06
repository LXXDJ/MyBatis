package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        // 1. 조회한 목록 출력하는 메소드
        //    (조건 1) HashMap 타입의 매개변수로 받아온 값을 기준으로 전체 목록 조회인지, 순위별 제품분류 조회인지 구분하여 출력하세요.
        //    (조건 2) List<CategoryDTO>로 받아온 데이터 목록을 전체 출력하세요.
        for(CategoryDTO category : categoryList){
            System.out.println(category);
        }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode){
            case "insert" : successMessage = "제품분류 코드 신설 성공"; break;
            case "update" : successMessage = "제품분류 코드 변경 성공"; break;
            case "delete" : successMessage = "제품분류 코드 삭제 성공"; break;
        }

        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode){
            case "selectList" : errorMessage = "제품분류 코드 조회 실패"; break;
            case "insert" : errorMessage = "제품분류 코드 신설 실패"; break;
            case "update" : errorMessage = "제품분류 코드 변경 실패"; break;
            case "delete" : errorMessage = "제품분류 코드 삭제 실패"; break;
        }

        System.out.println(errorMessage);
    }

}
