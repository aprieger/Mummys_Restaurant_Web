/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author syntel
 */
public class AdminDeleteWorker20 extends SimpleFormController {
    
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
        AdminDeleteWorker20.workerDAO = workerDAO;
    }
    
    public AdminDeleteWorker20() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    // Method deletes worker record
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors) {
       Worker worker = (Worker) command;
       List<Worker> workers = new ArrayList<>();
            
       try{
           if (request.getParameter("find") != null) {
        // Invoke first button, Admin worker records
            workers = workerDAO.findById(worker.getEmployeeId());
            return new ModelAndView("adminDeleteWorkerView","listOfWorkers",workers);
        } else if (request.getParameter("delete") != null) {
        // Invoke second button, Admin customer records 
            System.out.println("IN DELETE");
               
            workerDAO.delete(workers.get(0));
            return new ModelAndView("adminDeleteWorkerSuccess","worker",worker);
       }} catch(NullPointerException e) {
            return new ModelAndView(new RedirectView("adminDeleteWorker"));
       }
       return null;
    }
}
