package com.ws07.dto;

/**
 * 고객의 정보를 관리할 객체
 *
 */
public class UserDto {

    private int userSeq; // 고객 일련번호, PK
    private String name; // 고객 이름
    private String email; // 고객 이메일
    private String phone; // 고객 번호
    private boolean isSleep; // 고객 휴면여부

    public UserDto() {

    }

    public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
        this.userSeq = userSeq;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isSleep = isSleep;
    }


    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        this.isSleep = sleep;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(userSeq);
        sb.append(", ").append(name);
        sb.append(", ").append(email);
        sb.append(", ").append(phone);
        sb.append(", ").append(isSleep);
        return sb.toString();
    }

}
