
package Controller;

import DAO.WorkerDAO;
import DAO.WorkerDAOImpl;
import domain.Worker;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/*
    This controller will add a worker record to the database


*/
public class AddWorkerClass extends SimpleFormController {
    
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
        this.workerDAO = workerDAO;
    }
    
    public AddWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        Worker worker=(Worker)command;
        
        workerDAO.save(worker);
        
        return new ModelAndView("registrationSuccess","worker",worker);
    }
    
    
}
