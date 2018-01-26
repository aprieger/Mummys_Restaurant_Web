/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import domain.CreditCard;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 */
//@Controller
//@RequestMapping("/CreditCardAdminUI")
public class CreditCardUserController extends SimpleFormController {
    
    
    //@RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model)
    {
        model.addAttribute("message", "Hello spring MVC");
        return "hello";
                
    }
    
    public CreditCardUserController() {
        
        setCommandClass(CreditCard.class);
       setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        CreditCard user=(CreditCard)command;
        //userManager.add(user);
        return new ModelAndView("userSuccess","user",user);
    }
    
    
}
