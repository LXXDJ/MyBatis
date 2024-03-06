package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;

    public CategoryController(){
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {
        List<CategoryDTO> category = categoryService.selectCategoryList(parameter);

        if(category != null){
            categoryPrint.printTeamList(category, parameter);
        }else{
            categoryPrint.printErrorMessage("selectList");
        }

        // 2. 제품분류 목록을 조회하는 메소드
        //    (조건 1) Service 객체를 호출하여 조건에 따라 List<CategoryDTO> 타입으로 제품분류 목록을 조회하세요.
        //    (조건 2) 목록이 비어있지 않은 경우, Print 객체를 통해 제품분류 목록을 출력하세요.
        //    (조건 3) 제품분류 목록이 없는 경우, Print 객체를 통해 조회 결과가 없다는 오류 메세지를 출력하세요.

    }

    public void registNewCategory(CategoryDTO category) {
        if(categoryService.registNewCategory(category)){
            categoryPrint.printSuccessMessage("insert");
        }else{
            categoryPrint.printErrorMessage("insert");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {
         if(categoryService.modifyCategoryName(category)){
             categoryPrint.printSuccessMessage("update");
         }else{
             categoryPrint.printErrorMessage("update");
         }
    }

    public void deleteCategory(Map<String, String> parameter) {
        if(categoryService.deleteCategory(parameter)){
            categoryPrint.printSuccessMessage("delete");
        }else{
            categoryPrint.printErrorMessage("delete");
        }
    }
}
