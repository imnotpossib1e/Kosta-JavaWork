package kosta.db.util;

/**
 * Db 설정 정보를 상수로 관리
 * 인터페이스의 모든 멤버필드는 상수이다.
 */
public interface DbProperties {

    String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    String URL = "jdbc:mysql://localhost:3306/mytest";
    String USER_ID = "jhyun";
    String USER_PASS = "admin";
}
