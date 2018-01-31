/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAOImpl;
import domain.Worker;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 */
public class ChangePasswordClass extends SimpleFormController {
    
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
   
    public ChangePasswordClass() {
        setCommandClass(Worker.class);
        setCommandName("changePassword");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        Worker worker=(Worker)command;
        try {
        new LoginDAOImpl().changePassword(worker);
        return new ModelAndView("changePasswordSuccess","email",worker);
        }catch(NullPointerException e){
         return new ModelAndView("changePassword","changePassword",worker);   
        }
    }
}
    

