/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *This class will allow workers to be searched by all or employee id
 * 
 */
public class AdminViewWorkerClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       AdminViewWorkerClass.workerDAO = workerDAO;
    }
    
   public AdminViewWorkerClass() {
       System.out.println("In constructor");
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    /**
     * @param request
     * @param errors
     * @param response
     * @param command
     * @return 
     * 
     * The method checks which on the two buttons displayed on the screen was
     * clicked and calls the appropriate method
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors){
        
        Worker worker=(Worker)command;
          System.out.println(worker.getEmployeeId());
        if (request.getParameter("first") != null) {
        // Invoke first button
            ArrayList<Worker> workers = (ArrayList<Worker>)(workerDAO.findById(worker.getEmployeeId()));
            return new ModelAndView("adminViewWorkerResults","listOfWorkers",workers);
        } else if (request.getParameter("second") != null) {
        // Invoke second button
            ArrayList<Worker> workers = (ArrayList<Worker>) workerDAO.findAll();
            return new ModelAndView("adminViewWorkerResults","listOfWorkers",workers);
        } 
        return null;
    }
}
