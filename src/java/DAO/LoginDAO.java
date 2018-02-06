package DAO;

import domain.Login;
import domain.Worker;
import java.util.List;
/**
 * DAO interface specifying the login methods
 * 
 */
public interface LoginDAO {
    
    public Login validateUser(Login login);
    public Worker assignUser(Login login);
    public List<Login> getSystemUsers();
    public List<Login> changePassword(Login login);
    public String getUserId(Login login);
}
