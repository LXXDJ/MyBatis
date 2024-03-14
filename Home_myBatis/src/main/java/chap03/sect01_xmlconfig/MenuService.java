package chap03.sect01_xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static chap03.sect01_xmlconfig.Template.getSqlSession;

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
        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, index);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.registMenu(sqlSession, parameter);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.modifyMenu(sqlSession, menuDTO);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteMenu(int index) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.deleteMenu(sqlSession, index);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }
}
