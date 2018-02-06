/*
This class is the controller for CreditCardAdmin4.jsp
This Controller will delete all the Credit Cards associated with a particular Credit_ID
*/
package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
import domain.Credit.CreditCard;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class CreditCardAdminController5 extends SimpleFormController {

    public CreditCardAdminController5() {
              
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }

    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        
        CreditCard card = (CreditCard) command;
        
        ArrayList<CreditCard> listOfCards = new ArrayList<>();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        //listOfCards = (ArrayList) 
        cc.deleteAllRecordsByCreditId(card.getCREDIT_ID());
        return new ModelAndView("CreditCardAdminUI","listOfCards",listOfCards);
    }
    
}
