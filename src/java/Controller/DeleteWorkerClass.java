
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/*
    


*/
public class DeleteWorkerClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       this.workerDAO = workerDAO;
    }
    
    public DeleteWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
       Worker worker=(Worker)command;
        
        workerDAO.delete(worker.getEmployeeId());
        
        return new ModelAndView("workerDeleted","worker",worker);
    }
}
