package chap03.sect02_javaconfig;

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
            printResult.printError("selectAllMenu");
        }
    }

    public void selectMenuByCode(int index) {
        MenuDTO menuDTO = menuService.selectMenuByCode(index);

        if(menuDTO != null){
            printResult.selectMenuByCode(menuDTO);
        }else{
            printResult.printError("selectMenuByCode");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        if(menuService.registMenu(parameter)){
            printResult.printSuccess("registMenu");
        }else{
            printResult.printError("registMenu");
        }
    }

    public void modifyMenu(MenuDTO menuDTO) {
        if(menuService.modifyMenu(menuDTO)){
            printResult.printSuccess("modifyMenu");
        }else{
            printResult.printError("modifyMenu");
        }
    }

    public void deleteMenu(int index) {
        if(menuService.deleteMenu(index)){
            printResult.printSuccess("deleteMenu");
        }else{
            printResult.printError("deleteMenu");
        }
    }
}
