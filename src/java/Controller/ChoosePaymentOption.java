/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import Service.PkgOrderDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author syntel
 */
@Controller
@RequestMapping("/choosePaymentOption")
public class ChoosePaymentOption {
    
    private OrdersDAO ordersDAO;
    private PkgOrderDAO pkgOrderDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
    
    public void setPkgOrderDAO (PkgOrderDAO pkgOrderDAO) {
        this.pkgOrderDAO = pkgOrderDAO;
    }
    
    @RequestMapping(value = "/choosePaymentOption", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        //returns DB queried object into seeAllOrders.jsp, variable: "listOfOrders"
        return new ModelAndView("choosePaymentOption","pkgOrderInfo",pkgOrderDAO.getOpenPkgOrdersByCustomer(orderID));
    }
    
    /*@RequestMapping(value = "/seeAllOrders", method = RequestMethod.POST)
    public String deleteOrderRow(@ModelAttribute("orderInfo") Orders order, BindingResult result, Model model){
        ordersDAO.deleteOrder(order.getOrderID());
        return "redirect:/seeAllOrders.htm";
    }*/
    
}
