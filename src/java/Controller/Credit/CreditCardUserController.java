/*
This is the controller for CreditCardUser.jsp
It returns a model and view to a static page. 
*/
package Controller.Credit;
import domain.Credit.CreditCard;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CreditCardUserController extends SimpleFormController {
    
    /*public String printHello(ModelMap model)
    {
        model.addAttribute("message", "Hello spring MVC");
        return "hello";
                
    }*/
    
    public CreditCardUserController() {
        
        setCommandClass(CreditCard.class);
       setCommandName("CreditCard");
        
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws Exception{
        CreditCard user=(CreditCard)command;
        return new ModelAndView("userSuccess","user",user);
    }
    
    
}
