package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/*
    


*/
public class AdminDeleteWorkerClass extends SimpleFormController {
    private static WorkerDAO workerDAO;
    
    public void setWorkerDAO(WorkerDAO workerDAO){
        AdminDeleteWorkerClass.workerDAO = workerDAO;
    }
    
    public AdminDeleteWorkerClass() {
        setCommandClass(Worker.class);
        setCommandName("worker");
    }
    
    
    @Override
    @RequestMapping(value = "/worker" ,method = RequestMethod.POST)
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors) {
       Worker worker = (Worker) command;
       List<Worker> workers = new ArrayList<>();
            
       try{
            workers = workerDAO.findById(worker.getEmployeeId());
            return new ModelAndView("adminDeleteWorkerView","listOfWorkers",workers);
       } catch(NullPointerException e) {
            return new ModelAndView("adminDeleteWorker","worker", worker);
       }
      
    }
}
