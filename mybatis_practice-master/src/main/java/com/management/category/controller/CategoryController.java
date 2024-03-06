package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;

import java.util.Map;

public class CategoryController {

    // * 주석을 지우고 Controller 역할에 해당하는 내용을 작성하세요.

    // 1. 자주 사용할 Service와 Print 객체를 선언하고, Controller 객체 생성 시 생성되도록 작성하세요.

    public void selectCategoryList(Map<String, String> parameter) {

        // 2. 제품분류 목록을 조회하는 메소드
        //    (조건 1) Service 객체를 호출하여 조건에 따라 List<CategoryDTO> 타입으로 제품분류 목록을 조회하세요.
        //    (조건 2) 목록이 비어있지 않은 경우, Print 객체를 통해 제품분류 목록을 출력하세요.
        //    (조건 3) 제품분류 목록이 없는 경우, Print 객체를 통해 조회 결과가 없다는 오류 메세지를 출력하세요.

    }

    public void registNewCategory(CategoryDTO category) {

        // 3. 제품분류 정보를 등록하는 메소드
        //    (조건 1) Service 객체를 호출하여 등록을 수행하고, 결과를 boolean 값으로 return 받으세요.
        //    (조건 2) insert가 정상적으로 수행된 경우, Print 객체를 통해 등록 성공했다는 성공 메세지를 출력하세요.
        //    (조건 3) insert가 정상적으로 수행되지 않은 경우, Print 객체를 통해 등록 실패했다는 오류 메세지를 출력하세요.

    }

    public void modifyCategoryName(CategoryDTO category) {

        // 4. 제품분류 정보를 수정하는 메소드
        //    (조건 1) Service 객체를 호출하여 수정을 수행하고, 결과를 boolean 값으로 return 받으세요.
        //    (조건 2) update가 정상적으로 수행된 경우, Print 객체를 통해 수정 성공했다는 성공 메세지를 출력하세요.
        //    (조건 3) update가 정상적으로 수행되지 않은 경우, Print 객체를 통해 수정 실패했다는 오류 메세지를 출력하세요.

    }

    public void deleteCategory(Map<String, String> parameter) {

        // 5. 제품분류 정보를 삭제하는 메소드
        //    (조건 1) Service 객체를 호출하여 수정을 수행하고, 결과를 boolean 값으로 return 받으세요.
        //    (조건 2) delete가 정상적으로 수행된 경우, Print 객체를 통해 삭제 성공했다는 성공 메세지를 출력하세요.
        //    (조건 3) delete가 정상적으로 수행되지 않은 경우, Print 객체를 통해 삭제 실패했다는 오류 메세지를 출력하세요.

    }
}
