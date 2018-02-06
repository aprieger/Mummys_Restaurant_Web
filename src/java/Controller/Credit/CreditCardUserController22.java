/*
This controller should allow the user to select an exisiting card from a lsit of displayed
cards that belong to the user. Then it should redirect to the next step in the order process. 
*/

package Controller.Credit;
import DAO.Credit.CreditCardDAOImpl;
import domain.Credit.CreditCard;
import java.util.ArrayList;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class CreditCardUserController22 extends SimpleFormController {

    
    public CreditCardUserController22() {
        
        System.out.println("Entered constructor");
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        System.out.println("Exit Constructor");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        CreditCard card = (CreditCard) command;
        
        System.out.println("Enter onsubmit method");
        
        
        ArrayList<CreditCard> listOfCards = new ArrayList<>();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (ArrayList) cc.getAllRecordsByCreditId(card.getCREDIT_ID());
        System.out.println("Exit onsubmit method");
        return new ModelAndView("CreditCardUserUI","listOfCards",listOfCards);
    }
    
    
    
    
    
    
    /*
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
       /* System.out.println("Before session getSession");
        HttpSession session = request.getSession();
        System.out.println("After get session");
        System.out.println(session.toString());
        System.out.println(session.getAttribute("customerId"));
        int Id = Integer.parseInt(session.getAttribute("customerId").toString());
        System.out.println("Value of int Id is:");
        System.out.println(Id);
        
        System.out.println("Before Statment");
        //System.out.println(request.getParameter("customerId"));
        System.out.println("After- before");
        int Id = Integer.parseInt(request.getSession().getValue("customerId").toString());
        System.out.println("After statment");
        
        

        ArrayList<CreditCard> listOfCards;
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (ArrayList) cc.getAllRecordsByUserId(Id);
        System.out.println("before loop");
        for (int x = 0; x<listOfCards.size(); x++) 
        {
            int card_num = listOfCards.get(x).getCARD_NUMBER();
            String card_string = Integer.toString(card_num);
            card_string = card_string.substring(card_string.length()-5, card_string.length()-1);
            listOfCards.get(x).setCARD_NUMBER(Integer.parseInt(card_string));
        }
        System.out.println("After loop");
        return new ModelAndView("CreditCardUserUI","listOfCards",listOfCards);
    }    
*/
}