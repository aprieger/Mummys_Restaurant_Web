
package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
import domain.Credit.CreditCard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CreditCardAdminController extends SimpleFormController {

    public CreditCardAdminController() {
        
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        CreditCard CreditCard=(CreditCard)command;
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        
        System.out.println(cc.getAllRecords());
        System.out.println("test consol");
        
        return new ModelAndView("CreditCardAdminUI1","CreditCard",CreditCard);
    }    
}