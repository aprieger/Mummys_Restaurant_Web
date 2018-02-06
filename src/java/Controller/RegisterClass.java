/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.WorkerDAO;
import DAO.WorkerDAOImpl;
import domain.Worker;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 */
public class RegisterClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       RegisterClass.workerDAO = workerDAO;
    }
    
    public RegisterClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        Worker worker=(Worker)command;
        
        worker.setEmployeeId(new WorkerDAOImpl().getNextPrimaryKey());
        worker.setLoginId(worker.getFirstName().substring(0,1)+worker.getLastName().substring(0,1)+Integer.toString(worker.getEmployeeId()));
        System.out.println(worker.toString());
        
        workerDAO.save(worker);
        
        return new ModelAndView("registrationSuccess","worker",worker);
    }
    
    
  
    
}
