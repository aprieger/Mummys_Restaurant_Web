/*
This class is the controller for CreditCardAdmin2.jsp
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


public class CreditCardAdminController2 extends SimpleFormController {

    public CreditCardAdminController2() {
              
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }

    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        CreditCard card = (CreditCard) command;
        
        ArrayList<CreditCard> listOfCards = new ArrayList<>();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (ArrayList) cc.getAllRecordsByUserId(card.getCUSTOMER_ID());
        return new ModelAndView("CreditCardAdminUI11","listOfCards",listOfCards);
    }
}