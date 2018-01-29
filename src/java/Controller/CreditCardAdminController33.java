/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.CreditCardDAOImpl;
import domain.CreditCard;
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
public class CreditCardAdminController33 extends SimpleFormController {

    //public CreditCardAdminController11() {
        
        //setCommandClass(CreditCard.class);
        //setCommandName("CreditCard");
        
    //}
    /*
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        //userManager.add(user);
        LinkedList<CreditCard> listOfCards = new LinkedList<>();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        listOfCards = (LinkedList) cc.getAllRecords();
        return new ModelAndView("CreditCardAdminUI11","listOfCards",listOfCards);
    } 
*/
}