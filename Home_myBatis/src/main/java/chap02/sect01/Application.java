package chap02.sect01;

import static chap02.sect01.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
    }
}
