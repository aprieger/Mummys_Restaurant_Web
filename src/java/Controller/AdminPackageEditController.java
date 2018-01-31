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

//Controller class that maps the get and post methods for the adminpackageedit.jsp page
@Controller
@RequestMapping("/adminpackageedit")
public class AdminPackageEditController{
    //create the DAO and its initializer method
    private PackageDAO packageDAO;
    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    
    //View auto calls this method when the page loads (GET)
    @RequestMapping(value = "/adminpackageedit", method = RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
	Package pkg = new Package();
       	model.addAttribute("pkgEditForm", pkg);
        return new ModelAndView("adminpackageedit", "adminEditPackageDetails", packageDAO.getSinglePackageData(Integer.parseInt(request.getParameter("packageId"))));
    }
    
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value = "/adminpackageedit", method = RequestMethod.POST)
    public String editPackage(@ModelAttribute("pkgEditForm") Package pkg, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/adminpackages.htm";
        }
        else {
        packageDAO.editPackage(pkg.getPackageId(), pkg.getName(), pkg.getDescription(), pkg.getMealCategory(), pkg.getImageSource(), pkg.getPrice(), pkg.getIsSpecial(), pkg.getMealType());
        return "redirect:/adminpackages.htm";
        }
    }
}
