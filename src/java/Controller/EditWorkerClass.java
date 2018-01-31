
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/*

    This controller class will retrive and display a worker
    with the matching employee id

*/
public class EditWorkerClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       this.workerDAO = workerDAO;
    }
    
    public EditWorkerClass() {
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
