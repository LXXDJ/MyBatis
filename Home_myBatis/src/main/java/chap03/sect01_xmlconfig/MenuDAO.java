package chap03.sect01_xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int index) {
        return  sqlSession.selectOne("MenuMapper.selectMenuByCode", index);
    }

    public int registMenu(SqlSession sqlSession, Map<String, String> parameter) {
        return sqlSession.insert("MenuMapper.registMenu", parameter);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.update("MenuMapper.modifyMenu", menuDTO);
    }

    public int deleteMenu(SqlSession sqlSession, int index) {
        return  sqlSession.delete("MenuMapper.deleteMenu", index);
    }
}
