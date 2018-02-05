/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.WorkerDAO;
import domain.Worker;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * The controller class for adminWorkerMain
 * This class determines which button was select and redirects to the selected
 * page
 */
public class AdminWorkerMainClass extends SimpleFormController {
    
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       AdminWorkerMainClass.workerDAO = workerDAO;
    }
    
    
    public AdminWorkerMainClass() {
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
        // Invoke first button 
            return new ModelAndView("redirect:adminAddWorker.htm");
        } else if (request.getParameter("second") != null) {
        // Invoke second button 
            return new ModelAndView("redirect:adminDeleteWorker.htm");
        } else if (request.getParameter("third") != null) {
        // Invoke third button 
            return new ModelAndView("redirect:adminEditWorker.htm");
        } else if (request.getParameter("fourth") != null) {
        // Invoke fourth button 
            return new ModelAndView("redirect:adminViewWorker.htm");
        } else if (request.getParameter("back") != null) {
        // Invoke fourth button 
            return new ModelAndView("redirect:admin.htm");
        }
        return null;
    }
}

