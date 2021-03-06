/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Service.*;
import domain.Login;
import domain.Worker;
import Model.newUser;
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
    private UserDAO userDAO;
    
    public void setLoginDAO(LoginDAO loginDAO){
       this.loginDAO=loginDAO;
    }
    public void setUserDAO(UserDAO userDAO){
       this.userDAO=userDAO;
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
        int paymentType = 2, creditId = 1, orderId = 0;
        try{       
          Login l = loginDAO.validateUser(login);
            switch (l.getUserType()) {
                case 0:
                    return new ModelAndView(new RedirectView("worker.htm"));
                case 1:
                    return new ModelAndView(new RedirectView("admin.htm"));
                default:
                    long customerId = userDAO.getId(login.getLoginId());
                    session.setAttribute("orderId", orderId);
                    session.setAttribute("paymentType", paymentType);
                    session.setAttribute("creditId", creditId);
                    session.setAttribute("customerId", customerId);
                    
                    return new ModelAndView(new RedirectView("customerhome.htm"));
            }
        }catch (NullPointerException e) {
            
          return new ModelAndView(new RedirectView("login.htm"));
        }
    }
}
