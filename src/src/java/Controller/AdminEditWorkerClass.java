
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/*

    This controller class will retrive and display a worker
    with the matching employee id

*/
public class AdminEditWorkerClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
       this.workerDAO = workerDAO;
    }
    
    public AdminEditWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
       Worker w =(Worker)command;
        List<Worker> worker = new ArrayList<>();
        
        worker = workerDAO.findById(w.getEmployeeId());
        return new ModelAndView("adminEditWorkerView","worker",worker.get(0));
    }
}
