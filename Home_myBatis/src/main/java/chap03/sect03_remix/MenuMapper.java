package chap03.sect03_remix;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    List<MenuDTO> selectAllMenu();
    MenuDTO menuMapper(int code);

    int registMenu(Map<String, String> parameter);

    int modifyMenu(MenuDTO menuDTO);

    int deleteMenu(int code);
}
