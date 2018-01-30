package Controller;
import DAO.CreditCardDAOImpl;
import domain.CreditCard;
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