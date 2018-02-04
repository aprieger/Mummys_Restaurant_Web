/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import domain.Login;
import domain.Worker;
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
    protected ModelAndView onSubmit(Object command )
    throws Exception {
        Login login=(Login)command;
        /*
         *** can put your SQL queries here in this method ***
       */
     
        try{       
          Login l = loginDAO.validateUser(login);
            switch (l.getUserType()) {
                case 0:
//                    HttpSession session = request.getSession();
                    return new ModelAndView(new RedirectView("worker.htm"));
                case 1:
//                    Worker admin = loginDAO.assignUser(login);
                    return new ModelAndView(new RedirectView("admin.htm"));
                default:
//                    Worker work = (Worker) loginfDAO.assignUser(login);
//                    return new ModelAndView("loginSuccess","worker",work);
                    return new ModelAndView(new RedirectView("worker.htm"));
            }
        }catch (NullPointerException e) {
            
          return null;
        }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     * @Override protected ModelAndView onSubmit( HttpServletRequest request,
     * HttpServletResponse response, Object command, BindException errors)
     * throws Exception { ModelAndView mv = new ModelAndView(getSuccessView());
     * //Do something... return mv; }
     */
    }
}