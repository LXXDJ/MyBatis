package chap05.xmlmapper;

import chap05.common.CategoryAndMenuDTO;
import chap05.common.MenuAndCategoryDTO;
import chap05.common.MenuDTO;

import java.util.List;

public interface TestMapper {
    List<String> selectCacheTest();
    List<MenuDTO> selectResultMapTest();
    List<MenuDTO> selectResultMapConstructorTest();
    List<MenuAndCategoryDTO> selectResultMapAssociationTest();
    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
    List<MenuDTO> selectSqlTest();
    int insertCategory(MenuAndCategoryDTO menuAndCategory);
    int insertMenu(MenuAndCategoryDTO menuAndCategory);
}
