package Controller;
import DAO.CreditCardDAOImpl;
import domain.CreditCard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class CreditCardUserController1 extends SimpleFormController {

    public CreditCardUserController1() {
              
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }

    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
      
        CreditCard card = (CreditCard) command;
        System.out.println(card.toString());
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        cc.addRecord(card); 
        return new ModelAndView("CreditCardUserUI","success",1);
    }
    
}