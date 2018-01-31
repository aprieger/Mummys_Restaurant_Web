/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Login;
import domain.Worker;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author syntel
 */
public class LoginDAOImpl implements LoginDAO {
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        LoginDAOImpl.jdbcTemplate=new JdbcTemplate(dataSource);
    }
  
    @Override
    public Login validateUser(Login login) {
       
        String sql = "select * from Login where login_id = '" + login.getLoginId() + "' and password = '" + login.getPassword()
        + "'";
        List<Login> l = jdbcTemplate.query(sql, new LoginRowMapper());
        
        if( l.size() > 0){ 
           return l.get(0); 
        } else {
            System.out.println("NULL");
            return null;
        }
    }
    
    @Override
    public boolean validateLoginId(String s){
        return true;
    }
    
    @Override
    public Worker assignUser(Login login) {
         String s = "select * from workers where login_id = '" + login.getLoginId() + "'";
         List<Worker> u = jdbcTemplate.query(s, new WorkerRowMapper()); 
         return u.get(0); 
    }
    
    @Override
    public List<Login> getSystemUsers() {
        String sql = "select Login_id User_type from Login ";
        List<Login> l = jdbcTemplate.query(sql, new LoginRowMapper());
        return l;
    }
    
    @Override
    public Login changePassword(Worker worker) {
        String sql = "select * from workers where login_id = '"+ worker.getLoginId()
                +"' and phone_number = '"+worker.getPhoneNumber()+"'";
        List<Worker> w = jdbcTemplate.query(sql, new WorkerRowMapper());
        System.out.println(w.get(0));
        if(w.size() > 0){
            Login l = new Login();
            l.setLoginId(w.get(0).getLoginId());
            return l;
        } else {
            return null;
        }
        
    }
}
