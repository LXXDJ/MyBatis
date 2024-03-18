package chap05.xmlmapper;

import chap05.common.CategoryAndMenuDTO;
import chap05.common.CategoryDTO;
import chap05.common.MenuAndCategoryDTO;
import chap05.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static chap05.common.Template.getSqlSession;

public class TestService {
    private TestMapper testMapper;
    public void selectCacheTest() {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);

        for(int i=0; i<10; i++){
            Long start = System.currentTimeMillis();

            List<String> menuName = testMapper.selectCacheTest();
            System.out.println(menuName);

            Long end = System.currentTimeMillis();

            Long time = end - start;
            System.out.println("수행시간 : " + time + "(ms)");
        }

        sqlSession.close();
    }

    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);

        List<MenuDTO> menuList = testMapper.selectResultMapTest();
        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectResultMapConstructorTest() {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);

        List<MenuDTO> menuList = testMapper.selectResultMapConstructorTest();
        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);

        List<MenuAndCategoryDTO> menuList = testMapper.selectResultMapAssociationTest();
        for (MenuAndCategoryDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);

        List<CategoryAndMenuDTO> menuList = testMapper.selectResultMapCollectionTest();
        for (CategoryAndMenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectSqlTest() {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);

        List<MenuDTO> menuList = testMapper.selectSqlTest();
        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void insertCategoryAndMenuTest(MenuAndCategoryDTO menuAndCategory) {
        SqlSession sqlSession = getSqlSession();
        testMapper = sqlSession.getMapper(TestMapper.class);
        
        int result1 = testMapper.insertCategory(menuAndCategory);
        int result2 = testMapper.insertMenu(menuAndCategory);
        
        if(result1 > 0 && result2 > 0){
            System.out.println("등록 성공");
            sqlSession.commit();
        }else{
            System.out.println("등록 실패");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
