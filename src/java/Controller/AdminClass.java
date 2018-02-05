package Controller;

import domain.Worker;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *  Controller to direct user to correct system module
 *  view: admin.htm
 * 
 */
public class AdminClass extends SimpleFormController {
    
    public AdminClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
     /**
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return 
     * 
     * This method accepts the button name from adminWorkerMain and determines
     * which button was selected
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors){
        Worker worker =(Worker)command;
        
        if (request.getParameter("first") != null) {
        // Invoke first button, Admin worker records
            return new ModelAndView("redirect:adminWorkerMain.htm");
        } else if (request.getParameter("second") != null) {
        // Invoke second button, Admin customer records 
            return new ModelAndView("redirect:adminWorkerMain.htm");
        } else if (request.getParameter("third") != null) {
        // Invoke third button, Admin credit card records
            return new ModelAndView("redirect:adminWorkerMain.htm");
        } else if (request.getParameter("fourth") != null) {
        // Invoke fourth button, Admin product records 
            return new ModelAndView("redirect:adminWorkerMain.htm");
        } else if (request.getParameter("fifth") != null) {
        // Invoke fifth button, Admin order records 
            return new ModelAndView("redirect:adminWorkerMain.htm");
        } else if (request.getParameter("back") != null) {
        // Invoke back button, to go back a page
            return new ModelAndView("redirect:Login.htm");
        }
        return null;
    }
}

