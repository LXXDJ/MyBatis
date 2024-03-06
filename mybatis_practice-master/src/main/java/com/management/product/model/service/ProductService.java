package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    // * 주석을 지우고 Service 역할에 해당하는 메소드를 작성하세요.

    // 1. 자주 사용할 DAO 객체를 선언s하세요.
    private ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> productList = productDAO.selectAllProductList();

        sqlSession.close();

        return productList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> product = productDAO.selectProductByCondition(searchCondition);

        sqlSession.close();

        return product;

    }

    public boolean registNewProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);
        int result = productDAO.insertProduct(product);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0 ? true : false;

    }

    public boolean modifyProductInfo(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);
        int result = productDAO.modifyProductInfo(product);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0 ? true : false;

    }

    public boolean deleteProduct(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);
        int result = productDAO.deleteProduct(parameter);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0 ? true : false;

    }
}
