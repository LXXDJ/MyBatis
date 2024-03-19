package chap03.sect02_javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    @Results(id="menuResultMap", value={
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS"),
    })

    @Select("SELECT * FROM TBL_MENU")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT * FROM TBL_MENU WHERE MENU_CODE = #{code}")
    @ResultMap("menuResultMap")
    MenuDTO selectMenuByCode(int index);

    @Insert("INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS)\n" +
            "VALUES (#{menuName}, #{menuPrice}, #{categoryCode}, 'Y')")
    int registMenu(Map<String, String> parameter);

    @Update("UPDATE TBL_MENU\n" +
            "SET MENU_NAME = #{name}, MENU_PRICE = #{price},\n" +
            "CATEGORY_CODE = #{categoryCode}, ORDERABLE_STATUS = #{orderableStatus}\n" +
            "WHERE MENU_CODE = #{code}")
    int modifyMenu(MenuDTO menuDTO);

    @Delete("DELETE FROM TBL_MENU WHERE MENU_CODE = #{code}")
    int deleteMenu(int index);
}
