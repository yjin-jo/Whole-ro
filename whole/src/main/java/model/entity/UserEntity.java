package model.entity;

import model.enums.GenderEnum;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */

public class UserEntity {
    private long userId;
    private String email;
    private String password;
    private String nickname;
    private GenderEnum gender;
    private String introduction;
    private String interest;
    private String address;
    private int reportCount;

    public UserEntity() { }       // 기본 생성자
    
    public UserEntity(String nickname, String introduction, String interest) { 
        this.nickname = nickname;
        this.introduction = introduction;
        this.interest = interest; 
    }  
    
    public UserEntity(String password, String name, String introduction, String interest, String address, String email) {
        this.password = password;
        this.nickname = name;
        this.introduction = introduction;
        this.interest = interest;
        this.address = address;
        this.email = email;
    }
    
    public UserEntity(String email, String password, String nickname, GenderEnum gender, String introduction,
            String interest, String address, int reportCount) {
        super();
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.introduction = introduction;
        this.interest = interest;
        this.address = address;
        this.reportCount = reportCount;
    }


    /*public void update(User updateUser) {
        this.password = updateUser.password;
        this.name = updateUser.name;
        this.email = updateUser.email;
        this.phone = updateUser.phone;
    }*/
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    
    /* 비밀번호 검사 */
    public boolean matchPassword(String password) {
        if (password == null) {
            return false;
        }
        return this.password.equals(password);
    }
    

    public boolean isSameUser(int userid) {
        return this.userId == userid;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", nickname=" + nickname + ", gender=" + gender + 
                ", introdution=" + introduction + ", interest=" + interest + ", address=" + address 
                + ", reportCount=" + reportCount + "]";
    }   
}