package Controller;

import Service.PackageDAO;
import Model.Package;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

//Controller class that maps the get and post methods for the adminpackages.jsp page
@Controller
@RequestMapping("/adminpackages")
public class AdminPackagesController{
    //create the DAO and its initializer method
    private PackageDAO packageDAO;
    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
   
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value="/adminpackages", method=RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
	Package pkg = new Package();
       	model.addAttribute("pkgDeleteForm", pkg);
        return new ModelAndView("adminpackages", "adminPackageList", packageDAO.getAllPackageData());
    }
    
    //View auto calls this method when a form submits with the pkgForm attribute (POST)
    @RequestMapping(value = "/adminpackages", method = RequestMethod.POST)
    public String deleteAdminPackage(@ModelAttribute("pkgDeleteForm") Package pkg, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/adminpackages.htm";
        }
        else {
        packageDAO.deletePackage(pkg.getPackageId());
        return "redirect:/adminpackages.htm";
        }
    }
}
