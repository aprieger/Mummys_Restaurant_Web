package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *  Controller to add a worker to Worker database
 *  view: adminAddWorker.htm
 *  validation WorkerValidator
 */
@Controller
public class AdminAddWorkerClass extends SimpleFormController {
    
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
        AdminAddWorkerClass.workerDAO = workerDAO;
    }
    
    public AdminAddWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    // Method takes form input and calls WorkerDOAImpl method save()
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors){
        
            Worker worker=(Worker)command;
            workerDAO.save(worker);
            return new ModelAndView("registrationSuccess","worker",worker);
    }
}

