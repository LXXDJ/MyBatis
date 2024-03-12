package chap01.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.PrimitiveIterator;


public class Application {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USERNAME = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {
        Environment environment = new Environment("dev", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD));
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        java.util.Date date = mapper.selectSysdate();
        System.out.println(date);

        sqlSession.close();
    }
}
