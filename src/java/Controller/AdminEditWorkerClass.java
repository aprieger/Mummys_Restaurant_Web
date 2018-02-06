
package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.validation.BindException;
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
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors){
       try{ 
        
        if (request.getParameter("find") != null) {
        // Invoke first button, Admin worker records
            Worker worker = (Worker) command;
            List<Worker> workers = new ArrayList<>();
            workers = workerDAO.findById(worker.getEmployeeId());
            return new ModelAndView("adminEditWorkerView","worker",workers.get(0));
        } else if (request.getParameter("edit") != null) {
        // Invoke second button, Admin customer records 
            Worker worker = (Worker) command; 
            System.out.println(worker.toString());
            workerDAO.edit(worker);
            return new ModelAndView("adminEditWorkerSuccess","worker",worker);
        } else {
            return null;
       }} catch(NullPointerException e) {
            return new ModelAndView(new RedirectView("adminDeleteWorker"));
       }
    }
}
