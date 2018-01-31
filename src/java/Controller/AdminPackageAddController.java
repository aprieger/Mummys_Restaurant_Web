package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PkgOrder;
import Model.Package;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Service.PackageDAO;
import Service.PkgOrderDAO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/adminpackageadd")
public class AdminPackageAddController{
    //create the DAO and its initializer method
    private PackageDAO packageDAO;
    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
   
    @RequestMapping(value = "/adminpackageadd", method = RequestMethod.GET)
    public ModelAndView showAdminPackageAdd(Model model, HttpServletRequest request, HttpServletResponse response) {
	Package pkg = new Package();
       	model.addAttribute("pkgAddForm", pkg);
        return new ModelAndView("adminpackageadd");
    }
    
    @RequestMapping(value = "/adminpackageadd", method = RequestMethod.POST)
    public String addPackage(@ModelAttribute("pkgAddForm") Package pkg, BindingResult result, Model model) {
        packageDAO.addPackage(pkg);
        return "redirect:/adminpackages.htm";
    }
}
