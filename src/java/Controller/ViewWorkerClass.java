/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author syntel
 */
public class ViewWorkerClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       this.workerDAO = workerDAO;
    }
    
   public ViewWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
       Worker worker=(Worker)command;
        
        worker = workerDAO.findById(worker.getEmployeeId());
        
        return new ModelAndView("adminViewWorker","worker",worker);
    }
}
