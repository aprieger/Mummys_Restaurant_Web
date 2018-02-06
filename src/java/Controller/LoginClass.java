/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import domain.Login;
import domain.Worker;
import domain.newUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author LS5002117
 */
public class LoginClass extends SimpleFormController {
    
    private LoginDAO loginDAO;
    
    public void setLoginDAO(LoginDAO loginDAO){
       this.loginDAO=loginDAO;
    }
    
    public LoginClass() {
        setCommandClass(Login.class);
        setCommandName("login");
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
     HttpServletResponse response, Object command, BindException errors)
    throws Exception {
        Login login=(Login)command;
        HttpSession session;
        session = request.getSession(true);
     
        try{       
          Login l = loginDAO.validateUser(login);
            switch (l.getUserType()) {
                case 0:
                    return new ModelAndView(new RedirectView("worker.htm"));
                case 1:
                    return new ModelAndView(new RedirectView("admin.htm"));
                default:
                    long customer = new UserDOAImpl().getId(login.getLoginId());
                    session.setAttribute("customerId", customer);
                    return new ModelAndView(new RedirectView("worker.htm"));
            }
        }catch (NullPointerException e) {
            
          return new ModelAndView(new RedirectView("login.htm"));
        }
    }
}
