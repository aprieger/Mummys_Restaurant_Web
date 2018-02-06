package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Package;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Service.PackageDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

//Controller class that maps the get and post methods for the adminpackageaddcontroller.jsp page
@Controller
@RequestMapping("/adminpackageadd")
public class AdminPackageAddController{
    //create the DAO and its initializer method
    private PackageDAO packageDAO;
    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
       //View auto calls this method when the page loads (GET)

    @RequestMapping(value = "/adminpackageadd", method = RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
	Package pkg = new Package();
       	model.addAttribute("pkgAddForm", pkg);
        
        //set up the categories drop down list
        ArrayList<String> cats = new ArrayList();
        cats.add("Breakfast");
        cats.add("Lunch");
        cats.add("Dinner");
        
        //set up the special drop down list
        ArrayList<String> specs = new ArrayList();
        specs.add("Special");
        specs.add("Regular");
        
        //set up the type drop down list
        ArrayList<String> types = new ArrayList();
        types.add("Vegetarian");
        types.add("Vegetarian Spicy");
        types.add("Non-Vegetarian");
        types.add("Non-Vegetarian Spicy");
        
        model.addAttribute("catList", cats);
        model.addAttribute("specList", specs);
        model.addAttribute("typeList", types);
        return new ModelAndView("adminpackageadd");
    }
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value = "/adminpackageadd", method = RequestMethod.POST)
    public String addPackage(@ModelAttribute("pkgAddForm") Package pkg, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
        return "redirect:/adminpackages.htm";
        }
        else {
        packageDAO.addPackage(pkg);
        return "redirect:/adminpackages.htm";
        }
    }
}
