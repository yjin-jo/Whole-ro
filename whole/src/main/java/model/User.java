package model;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */

public class User {
    private long userId;
    private String email;
    private String password;
    private String nickname;
    private int gender;
    private String introdution;
    private String interest;
    private String address;
    private int reportCount;

    public User() { }       // 기본 생성자
    
    public User(String nickname, String introdution, String interest) { 
        this.nickname = nickname;
        this.introdution = introdution;
        this.interest = interest; 
    }  
    
    public User(long userId, String email, String password, String nickname, int gender, String introdution,
            String interest, String address, int reportCount) {
        super();
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.introdution = introdution;
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

    public void setUserId(int userId) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIntrodution() {
        return introdution;
    }

    public void setIntrodution(String introdution) {
        this.introdution = introdution;
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
                ", introdution=" + introdution + ", interest=" + interest + ", address=" + address 
                + ", reportCount=" + reportCount + "]";
    }   
}

