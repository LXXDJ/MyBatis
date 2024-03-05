package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

public class MenuService {
    private DynamicSqlMapper mapper;
    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if(menuList != null && menuList.size() > 0){
            for (MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0){
            for (MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenuBySuperCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySuperCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0){
            for (MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenubyRandomMenuCode(List<Integer> randomMenuCodeList) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        criteria.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenubyRandomMenuCode(criteria);

        if(menuList != null && menuList.size() > 0){
            for (MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }
}
