package chap04;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static chap04.Template.getSqlSession;

public class MenuService {
    private static DynamicSqlMapper dynamicSqlMapper;

    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = dynamicSqlMapper.selectMenuByPrice(price);

        if(menuList != null && !menuList.isEmpty()){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenu(searchCriteria);

        if(menuList != null && !menuList.isEmpty()){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void chooseSubMenu(String category) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = dynamicSqlMapper.chooseSubMenu(category);

        if(menuList != null && !menuList.isEmpty()){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();

    }

    public void foreachSubMenu(Set<Integer> code) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

//        List<MenuDTO> menuList = dynamicSqlMapper.foreachSubMenu(code);

        Map<String, Set<Integer>> randomCode = new HashMap<>();
        randomCode.put("randomCodeList", code);
        List<MenuDTO> menuList = dynamicSqlMapper.foreachSubMenu(randomCode);

        if(menuList != null && !menuList.isEmpty()){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && !menuList.isEmpty()){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> search) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByNameOrCategory(search);

        if(menuList != null && !menuList.isEmpty()){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과 없음");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int result = dynamicSqlMapper.modifyMenu(parameter);

        if(result > 0){
            System.out.println("메뉴 수정 성공");
            sqlSession.commit();
        }else{
            System.out.println("메뉴 수정 실패");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
