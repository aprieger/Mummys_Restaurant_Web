package Controller;

import DAO.WorkerDAO;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/*
    


*/
@Controller
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
    @RequestMapping("/adminDeleteWorkerView")
    protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException errors) {
       
            
       try{
           if (request.getParameter("find") != null) {
        // Invoke first button, Admin worker records
            Worker worker = (Worker) command;
             List<Worker> workers = new ArrayList<>();
            workers = workerDAO.findById(worker.getEmployeeId());
            return new ModelAndView("adminDeleteWorkerView","listOfWorkers",workers);
        } else if (request.getParameter("delete") != null) {
        // Invoke second button, Admin customer records 
            System.out.println("IN DELETE");
            Worker worker = (Worker) command; 
            System.out.println(worker.toString());
            workerDAO.delete(worker);
            return new ModelAndView("adminDeleteWorkerSuccess","worker",worker);
       }} catch(NullPointerException e) {
            return new ModelAndView(new RedirectView("adminDeleteWorker"));
       }
       return null;
    }
}

