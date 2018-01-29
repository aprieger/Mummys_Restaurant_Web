/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.CreditCardDAOImpl;
import domain.CreditCard;
import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 */
//@Controller
//@RequestMapping("/CreditCardAdminUI")
public class CreditCardAdminController1 extends SimpleFormController {

    public CreditCardAdminController1() {
        
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        //userManager.add(user);
        ArrayList<CreditCard> listOfCards = new ArrayList<>();
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (ArrayList) cc.getAllRecords();
        
                return new ModelAndView("CreditCardAdminUI11","listOfCards",listOfCards);
    }    
}