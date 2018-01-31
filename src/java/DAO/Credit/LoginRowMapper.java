/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author syntel
 */
public class LoginRowMapper implements RowMapper {
    
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        Login l = new Login();
        
        l.setLoginId(rs.getString(1));
        l.setPassword(rs.getString(2));
        l.setUserType(rs.getInt(3));
        return l;
    }   
}
