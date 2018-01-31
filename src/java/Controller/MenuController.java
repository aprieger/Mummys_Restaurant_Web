package Controller;

import Service.PackageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Controller class that maps the get and post methods for the menu.jsp page
@Controller
public class MenuController{
    private PackageDAO packageDAO;

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }
    
    //View auto calls this method when the page loads (GET)
    @RequestMapping(value="/menu", method=RequestMethod.GET)
    public ModelAndView onPageLoad(ModelMap map, HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        return new ModelAndView("menu", "packageList", packageDAO.getAllPackageData());
    }
}
