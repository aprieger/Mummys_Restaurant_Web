/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.NewOrderID;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author syntel
 */
public class NewOrderIDRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        NewOrderID newOrderID = new NewOrderID();
        
        newOrderID.setOrderID(rs.getInt(1));
        
        return newOrderID;
    }
    
}
