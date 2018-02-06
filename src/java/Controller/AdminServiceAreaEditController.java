package Controller;

import Service.PackageDAO;
import Model.*;
import Service.ServiceAreaDAO;
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
@RequestMapping("/adminserviceareaedit")
public class AdminServiceAreaEditController{
    //create the DAO and its initializer method
    private ServiceAreaDAO serviceAreaDAO;
    public void setServiceAreaDAO(ServiceAreaDAO serviceAreaDAO) {
        this.serviceAreaDAO = serviceAreaDAO;
    }
    
    //View auto calls this method when the page loads (GET)
    @RequestMapping(value = "/adminserviceareaedit", method = RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
        ServiceArea svcArea = new ServiceArea();
       	model.addAttribute("svcAreaEditForm", svcArea);
        return new ModelAndView("adminserviceareaedit", "adminServiceAreaDetails", serviceAreaDAO.getSingleServiceAreaData(Integer.parseInt(request.getParameter("areaId"))));
    }
    
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value = "/adminserviceareaedit", method = RequestMethod.POST)
    public String editPackage(@ModelAttribute("svcAreaEditForm") ServiceArea svcArea, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/adminserviceareas.htm";
        }
        else {
        serviceAreaDAO.editServiceArea(svcArea);
        return "redirect:/adminserviceareas.htm";
        }
    }
}
