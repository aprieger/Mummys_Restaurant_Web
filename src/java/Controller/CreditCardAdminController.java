/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.CreditCardDAOImpl;
import domain.CreditCard;
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
public class CreditCardAdminController extends SimpleFormController {

    public CreditCardAdminController() {
        
        setCommandClass(CreditCard.class);
        setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        CreditCard CreditCard=(CreditCard)command;
        //userManager.add(user);
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        CreditCardDAOImpl cc=(CreditCardDAOImpl)ctx.getBean("CreditCardDAOImpl");
        
        System.out.println(cc.getAllRecords());
        System.out.println("test consol");
        
        return new ModelAndView("CreditCardAdminUI1","CreditCard",CreditCard);
    }    
}