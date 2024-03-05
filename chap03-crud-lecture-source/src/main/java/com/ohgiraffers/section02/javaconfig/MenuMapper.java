package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.awt.*;
import java.util.List;

public interface MenuMapper {
    @Results(id="menuResultMap", value={
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })
    @Select("SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS\n" +
            "FROM TBL_MENU WHERE ORDERABLE_STATUS = 'Y' ORDER BY MENU_CODE")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS\n" +
            "FROM TBL_MENU WHERE ORDERABLE_STATUS = 'Y' AND MENU_CODE = #{code}")
    @ResultMap("menuResultMap")             // 위에 작성된 Results의 id를 이용해 재사용
    MenuDTO selectMenuByCode(int code);

    @Insert("INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS)\n" +
            "VALUES (#{name}, #{price}, #{categoryCode}, 'Y')")
    int insertMenu(MenuDTO menu);

    @Update("UPDATE TBL_MENU\n" +
            "SET MENU_NAME = #{name}, MENU_PRICE = #{price}, CATEGORY_CODE = #{categoryCode}\n" +
            "WHERE MENU_CODE = #{code}")
    int updateMenu(MenuDTO menu);

    @Delete("DELETE FROM TBL_MENU WHERE MENU_CODE = #{code}")
    int deleteMenu(int code);
}
