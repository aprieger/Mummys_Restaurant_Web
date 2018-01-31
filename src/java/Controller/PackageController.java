package Controller;

import Model.PkgOrder;
import Model.Package;
import Service.PackageDAO;
import Service.PkgOrderDAO;
import Validator.PackageValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

//Controller class that maps the get and post methods for the packages.jsp page
@Controller
@RequestMapping("/packages")
public class PackageController{
    int customerId;
    
    private PackageDAO packageDAO;
    private PkgOrderDAO pkgOrderDAO;
    @Autowired
    private PackageValidator packageValidator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
		binder.setValidator(packageValidator);
	}
    
    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    public void setPkgOrderDAO(PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }

    //View auto calls this method when the page loads (GET)
    @RequestMapping(value = "/package", method = RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
        customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
	PkgOrder pkgOrder = new PkgOrder();
	model.addAttribute("formPkgOrder", pkgOrder);
        return new ModelAndView("package", "packageItemDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("packageId"))));
    }
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value = "/package", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("formPkgOrder") @Validated PkgOrder formPkgOrder, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/cart.htm";
        }
        else {
            PkgOrder newPkgOrder = new PkgOrder();
            Package pkg = packageDAO.getSinglePackageData(formPkgOrder.getPackageIdKey());

            newPkgOrder.setPkgOrderId(pkgOrderDAO.getNextPkgOrderId());
            newPkgOrder.setOrderId(0);
            newPkgOrder.setPackageIdKey(formPkgOrder.getPackageIdKey());
            newPkgOrder.setCustomerId(customerId);
            newPkgOrder.setPricePerPkg(pkg.getPrice());
            newPkgOrder.setQuantity(formPkgOrder.getQuantity());
            newPkgOrder.setIsOpen(1);
            pkgOrderDAO.addOpenPkgOrder(newPkgOrder);

            return "redirect:/cart.htm";
        }
    }
}
