package chap03.section01;

import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static chap03.section01.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;
    public MenuService(){
        menuDAO = new MenuDAO();
    }
    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByCode(int index) {
        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByCode(index);

        sqlSession.close();

        return menu;
    }
}
