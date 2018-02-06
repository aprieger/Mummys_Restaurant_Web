package domain;

/**
 *  Login class
 *  Class fields loginId, password, userType all have getter and setter methods
 */
public class Login {

    private String loginId;
    private String password;
    private int userType;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
