package chap02.section01;

import static chap02.section01.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
    }
}
