
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/*

    This controller class will retrive and display a worker
    with the matching employee id

*/
public class AdminEditWorkerClass extends SimpleFormController {
    private WorkerDAO workerDAO;
    
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
       try{ 
        worker = workerDAO.findById(w.getEmployeeId());
        return new ModelAndView("redirect:adminEditWorkerView.htm","worker",worker.get(0));
       }catch(NullPointerException e){
           return new ModelAndView(new RedirectView("adminEditWorker"));
       }
    }
}
