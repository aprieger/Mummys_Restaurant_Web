/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Orders;
import java.util.List;
/**
 *
 * @author syntel
 */
public interface OrdersDAO {
    public List getAllOrders();
    public void insertNewOrder(Orders ordersObject);
    public void updateOrderRow(Orders ordersObject);
    public void deleteOrder(int orderID);
    public List idOrdersGenerator();
    public List getOrdersByOrderID(int orderID);
}

