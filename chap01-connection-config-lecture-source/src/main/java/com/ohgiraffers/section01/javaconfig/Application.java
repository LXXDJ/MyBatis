package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {
        /* DB 접속에 관한 환경설정
        *  JdbcTransactionFactory : 수동 커밋
        *  ManagedTransactionFactory : 자동 커밋
        *  PooledDataSource : ConnectionPool 사용
        *  UnpooledDataSource : ConnectionPool 미사용 */

        // Environment environment = new Environment(환경정보이름, 커밋종류, ConnectionPool 사용유무);
        Environment environment = new Environment("dev", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USER, PASSWORD));

        Configuration configuration = new Configuration(environment);

        /* 설정 객체에 Mapper 등록 (어디에 쿼리를 작성했다를 등록 Mapper에 대한 메타정보 전달) */
        configuration.addMapper(Mapper.class);

        /* SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        *  SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *  build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정파일과 연결된 Stream을 매개변수로 전달하면 SqlSessionFatory 인터페이스 타입의 객체를 반환하는 메소드 */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /* openSession() : Sqlsession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달 */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);  // autocommit을 false로 설정

        /* getMapper() : Configuration에 등록된 Mapper를 동일 타입에 대해 반환하는 메소드 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        /* Mapper 인터페이스에 작성된 메소드를 호출하여 쿼리 실행 */
        java.util.Date date = mapper.selectSysdate();

        System.out.println(date);

        sqlSession.close();
    }
}
