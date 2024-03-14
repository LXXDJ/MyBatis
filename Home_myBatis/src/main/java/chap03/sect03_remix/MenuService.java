package chap03.sect03_remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static chap03.sect03_remix.Template.getSqlSession;

public class MenuService {

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menuDTO = menuMapper.menuMapper(code);

        sqlSession.close();

        return menuDTO;
    }

    public boolean registMenu(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.registMenu(parameter);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        return  result > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.modifyMenu(menuDTO);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(code);

        if(result > 0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }
}
