package chap04;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DynamicSqlMapper {

    List<MenuDTO> selectMenuByPrice(int price);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> chooseSubMenu(String category);

//    List<MenuDTO> foreachSubMenu(Set<Integer> code);
    List<MenuDTO> foreachSubMenu(Map<String, Set<Integer>> randomCode);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> search);
    int modifyMenu(Map<String, String> parameter);
}
