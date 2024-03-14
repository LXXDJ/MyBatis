package chap04;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DynamicSqlMapper {
    int modifyMenu(Map<String, String> parameter);

    List<MenuDTO> selectMenuByPrice(int price);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> chooseSubMenu(String category);

//    MenuDTO foreachSubMenu(Set<Integer> code);
List<MenuDTO> foreachSubMenu(Map<String, Set<Integer>> randomCode);
}
