package chap04.sect01;

import org.apache.ibatis.session.SqlSession;

import static chap04.sect01.Template.getSqlSession;

public class MenuService {
    private static DynamicSqlMapper dynamicSqlMapper;

    public void modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int result = dynamicSqlMapper.modifyMenu(menuDTO);

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
