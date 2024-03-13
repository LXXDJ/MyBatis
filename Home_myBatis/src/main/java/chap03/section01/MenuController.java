package chap03.section01;

import java.awt.*;
import java.util.List;

public class MenuController {
    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController(){
        menuService = new MenuService();
        printResult = new PrintResult();
    }
    public void selectAllMenu() {
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null){
            printResult.selectAllMenu(menuList);
        }else{
            printResult.printErrorMessage("selectAllMenu");
        }
    }

    public void selectMenuByCode(int index) {
        MenuDTO menu = menuService.selectMenuByCode(index);

        if(menu != null){
            printResult.selectMenuByCode(menu);
        }else{
            printResult.printErrorMessage("selectMenuByCode");
        }
    }
}
