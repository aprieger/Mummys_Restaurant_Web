package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import domain.Credit.CreditCard;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
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
        HttpSession session;
        //session = request.getSession(true);
        //session.setAttribute("MySessionVariable", param);
        //session.setAttribute("card", card);
        return new ModelAndView("CreditCardUserUI","card",card);
    }
    
}