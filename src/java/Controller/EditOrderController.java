/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.OrdersDAO;
import Model.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author syntel
 */
public class EditOrderController extends SimpleFormController{
    private OrdersDAO ordersDAO;
    
    public void setOrdersDAO(OrdersDAO ordersDAO){
        this.ordersDAO = ordersDAO;
    }
    
    /*public EditOrderController(){
        setCommandClass (Orders.class);
        setCommandName ("editOrders");
    }*/
    
    /*@RequestMapping(value="/seeAllOrders", method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("newOrders", "orderDetail", ordersDAO.getOrdersByOrderID(Integer.parseInt(request.getParameter("orderID"))).get(0));
    }*/
    
    @Override
    protected ModelAndView onSubmit (Object command) throws Exception{
        Orders updatedOrder=(Orders)command;
        ordersDAO.updateOrderRow(updatedOrder);
        return new ModelAndView("Success","orderDetail",updatedOrder);
    }
}
