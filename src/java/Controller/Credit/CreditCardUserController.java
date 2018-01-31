
package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
import domain.Credit.CreditCard;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CreditCardUserController extends SimpleFormController {
    
    public String printHello(ModelMap model)
    {
        model.addAttribute("message", "Hello spring MVC");
        return "hello";
                
    }
    
    public CreditCardUserController() {
        
        setCommandClass(CreditCard.class);
       setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
       ArrayList<CreditCard> listOfCards;
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (ArrayList) cc.getAllRecords();
        
        //Place holder value
        int Customer_Id = 0;
        Customer_Id = Integer.parseInt(request.getSession().getAttribute("Customer_Id").toString());
        
        
        return new ModelAndView("CreditCardAdminUI11","listOfCards",listOfCards);
    }
    
    
}
