package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Package;
import Model.ServiceArea;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Service.ServiceAreaDAO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

//Controller class that maps the get and post methods for the adminserviceareaaddcontroller.jsp page
@Controller
@RequestMapping("/adminserviceareaadd")
public class AdminServiceAreaAddController{
    //create the DAO and its initializer method
    private ServiceAreaDAO serviceAreaDAO;
    public void setServiceAreaDAO(ServiceAreaDAO serviceAreaDAO) {
        this.serviceAreaDAO = serviceAreaDAO;
    }
       
    //View auto calls this method when the page loads (GET)

    @RequestMapping(value = "/adminserviceareaadd", method = RequestMethod.GET)
    public ModelAndView onPageLoad(Model model, HttpServletRequest request, HttpServletResponse response) {
        ServiceArea svcArea = new ServiceArea();
       	model.addAttribute("svcAreaAddForm", svcArea);
        return new ModelAndView("adminserviceareaadd");
    }
    //Form submission calls this method to handle the form using the model attribute  and performs its function
    @RequestMapping(value = "/adminserviceareaadd", method = RequestMethod.POST)
    public String addPackage(@ModelAttribute("svcAreaAddForm") ServiceArea svcArea, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("----There was an error");
            return "redirect:/adminserviceareas.htm";
        }
        else {
            serviceAreaDAO.addServiceArea(svcArea);
            return "redirect:/adminserviceareas.htm";
        }
    }
}
