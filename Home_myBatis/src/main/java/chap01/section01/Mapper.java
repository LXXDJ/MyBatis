package chap01.section01;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("SELECT CURDATE() FROM DUAL")
    java.util.Date selectSysdate();
}
