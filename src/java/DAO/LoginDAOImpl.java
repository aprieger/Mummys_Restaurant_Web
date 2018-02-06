package DAO;

import domain.Login;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *  Implementation of LoginDAO methods to perform multiple login 
 *  requests to the Login database
 */
public class LoginDAOImpl implements LoginDAO {
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        LoginDAOImpl.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    // Method to validate if user and password are in database
    @Override
    public Login validateUser(Login login) {
        String sql = "select * from Login where login_id = '" + login.getLoginId() + "' and password = '" + login.getPassword()
        + "'";
        List<Login> l = jdbcTemplate.query(sql, new LoginRowMapper());
        
        if( l.size() > 0){ 
           return l.get(0); 
        }else {
           return null;
        }
    }
    
    // Method to select a Login user from the Login database
    @Override
    public Worker assignUser(Login login) {
         String s = "select * from Login where login_id = '" + login.getLoginId() + "'";
         List<Worker> u = jdbcTemplate.query(s, new WorkerRowMapper()); 
         return u.get(0); 
    }
    
    // Method to retrieve all system users from the Login database
    @Override
    public List<Login> getSystemUsers() {
        String sql = "select Login_id User_type from Login ";
        List<Login> l = jdbcTemplate.query(sql, new LoginRowMapper());
        return l;
    }
    
    // Method to verify user email exists on Login database
    @Override
    public List<Login> changePassword(Login login){
        String sql = "select Login_id User_type from Login ";
        List<Login> l = jdbcTemplate.query(sql, new LoginRowMapper());
        return l;
    } 
    
    public String getUserId(Login login) {
        String s = "";
        //  BEN CREATE a query to Get Customer id        
        return s;
    }
}
