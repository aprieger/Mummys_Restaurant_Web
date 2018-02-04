package Controller;

import Service.ServiceAreaDAO;
import Model.*;
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
@RequestMapping("/adminserviceareas")
public class AdminServiceAreasController{
    //create the DAO and its initializer method
    private ServiceAreaDAO serviceAreaDAO;
    public void setServiceAreaDAO(ServiceAreaDAO serviceAreaDAO) {
        this.serviceAreaDAO = serviceAreaDAO;
    }
   
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value="/adminserviceareas", method=RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
	ServiceArea svcArea = new ServiceArea();
       	model.addAttribute("svcAreaDeleteForm", svcArea);
        return new ModelAndView("adminserviceareas", "adminServiceAreaList", serviceAreaDAO.getAllServiceAreaData());
    }
    
    //View auto calls this method when a form submits with the pkgForm attribute (POST)
    @RequestMapping(value = "/adminserviceareas", method = RequestMethod.POST)
    public String deleteAdminPackage(@ModelAttribute("svcAreaDeleteForm") ServiceArea svcArea, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/adminserviceareas.htm";
        }
        else {
            serviceAreaDAO.deleteServiceArea(svcArea.getAreaId());
            return "redirect:/adminserviceareas.htm";
        }
    }
}
