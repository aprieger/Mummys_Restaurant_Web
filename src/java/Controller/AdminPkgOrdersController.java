package Controller;

import Service.PkgOrderDAO;
import Model.PkgOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

//Controller class that maps the get and post methods for the adminpkgorders.jsp page
@Controller
@RequestMapping("/adminpkgorders")
public class AdminPkgOrdersController{
    //create the DAO and its initializer method
    private PkgOrderDAO pkgOrderDAO;
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
   
    //View auto calls this method when the page loads (GET)
    @RequestMapping(value="/adminpkgorders", method=RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
	PkgOrder pkg = new PkgOrder();
       	model.addAttribute("pkgOrderDeleteForm", pkg);
        return new ModelAndView("adminpkgorders", "adminPkgOrderList", pkgOrderDAO.getAllClosedPkgOrders());
    }
}
