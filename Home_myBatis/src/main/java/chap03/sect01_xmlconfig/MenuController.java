package chap03.sect01_xmlconfig;

import java.util.List;
import java.util.Map;

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

    public void registMenu(Map<String, String> parameter) {
        if(menuService.registMenu(parameter)){
            printResult.printSuccessMessage("registMenu");
        }else{
            printResult.printErrorMessage(("registMenu"));
        }
    }

    public void modifyMenu(MenuDTO menuDTO) {
        if(menuService.modifyMenu(menuDTO)){
            printResult.printSuccessMessage("modifyMenu");
        }else{
            printResult.printErrorMessage("modifyMenu");
        }
    }

    public void deleteMenu(int index) {
        if(menuService.deleteMenu(index)){
            printResult.printSuccessMessage("deleteMenu");
        }else{
            printResult.printErrorMessage("deleteMenu");
        }
    }
}
