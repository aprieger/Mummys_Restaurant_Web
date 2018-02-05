/*
This class is the controller for CreditCardController1.jsp
This controller allows the User to add a new credit card to the site
The controller then redirects to the next page in the order process. 
*/


package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import domain.Credit.CreditCard;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
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
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
      
        HttpSession session;
        session = request.getSession(true);
        
        CreditCard card = (CreditCard) command;
        card.setCUSTOMER_ID(Integer.parseInt(session.getAttribute("customerID").toString()));
        System.out.println(card.toString());
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        cc.addRecord(card); 
        
        
        
        session.setAttribute("creditID", card.getCREDIT_ID());
        session.setAttribute("paymentType", 1);
        return new ModelAndView("confirmationPage","card",card);
    }
    
}