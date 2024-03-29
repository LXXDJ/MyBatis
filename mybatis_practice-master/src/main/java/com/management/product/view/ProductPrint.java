package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.sql.SQLOutput;
import java.util.List;

public class ProductPrint {
    public void printAllProductList(List<ProductDTO> allProductList) {
        for(ProductDTO product : allProductList){
            System.out.println(product);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {
        System.out.println(searchCondition);

        for(ProductDTO product : productList){
            System.out.println(product);
        }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode){
            case "insert" : successMessage = "신규제품 등록 성공"; break;
            case "update" : successMessage = "제품 수정 성공"; break;
            case "delete" : successMessage = "제품 삭제 성공"; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode){
            case "selectList" : errorMessage = "전체 제품 목록 조회 실패"; break;
            case "selectOne" : errorMessage = "제품 조회 실패"; break;
            case "insert" : errorMessage = "신규제품 등록 실패"; break;
            case "update" : errorMessage = "제품 수정 실패"; break;
            case "delete" : errorMessage = "제품 삭제 실패"; break;
        }

        System.out.println(errorMessage);
    }

}
