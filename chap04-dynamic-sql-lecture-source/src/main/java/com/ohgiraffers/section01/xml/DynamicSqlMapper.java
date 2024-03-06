package com.ohgiraffers.section01.xml;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySuperCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenubyRandomMenuCode(Map<String, List<Integer>> criteria);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

    int modifyMenu(Map<String, Object> criteria);
}
