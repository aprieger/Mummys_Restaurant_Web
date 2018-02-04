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
 *
 * @author syntel
 */
public class AdminEditWorkerViewClass extends SimpleFormController {
    
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
        AdminEditWorkerViewClass.workerDAO = workerDAO;
    }
    
    public AdminEditWorkerViewClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    // Method deletes worker record
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors){
        Worker worker=(Worker)command;
        workerDAO.edit(worker);
        return new ModelAndView("adminDeleteWorkerSuccess","worker",worker);
    }
}