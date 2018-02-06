package Controller;

import Model.PkgOrder;
import Service.PackageDAO;
import Service.PkgOrderDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

//Controller class that maps the get and post methods for the cart.jsp page
@Controller
@RequestMapping("/cart")
public class CartController{
    //create the DAO and the initializer method
    int customerId;
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    //View auto calls this method when the page loads (GET)
    @RequestMapping(value="/cart", method=RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            try {
            customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
            } catch (Exception e) {customerId=1;}
            PkgOrder pkg = new PkgOrder();
            model.addAttribute("pkgForm", pkg);
            model.addAttribute("subtotalPrice", pkgOrderDAO.getFinalPrice(customerId));
            return new ModelAndView("cart", "cartPkgList", pkgOrderDAO.getOpenPkgOrdersByCustomerAll(customerId));
        } catch (Exception e) {System.out.println(e);return new ModelAndView("redirect:/login.htm");}
    }
    
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public String deleteCartItem(@ModelAttribute("pkgForm") PkgOrder pkg, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/cart.htm";
        }
        else {
        pkgOrderDAO.deletePkgOrder(pkg.getPkgOrderId());
        return "redirect:/cart.htm";
        }
    }
}
