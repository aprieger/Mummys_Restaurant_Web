/*
This class is the controller for CreditCardAdmin1.jsp
it has one mthod that reurns a ModelAndView object and an ArrayList of CreditCard objects. 
only the last 4 digits are returned
*/
package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
import domain.Credit.CreditCard;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class CreditCardAdminController1 extends SimpleFormController {

    public CreditCardAdminController1() {
        
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        //userManager.add(user);
        ArrayList<CreditCard> listOfCards;
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (ArrayList) cc.getAllRecords();
        
       
        
        
        return new ModelAndView("CreditCardAdminUI11","listOfCards",listOfCards);
    }    
}