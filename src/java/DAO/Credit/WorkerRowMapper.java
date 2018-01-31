/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Worker;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author syntel
 */
public class WorkerRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
       	Worker w = new Worker();
        w.setEmployeeId(rs.getInt(1));
	//w.setEmployeeId(new WorkerDAOImpl().getNextPrimaryKey());
	w.setFirstName(rs.getString(2));
        w.setLastName(rs.getString(3));
        w.setGender(rs.getString(4));
        w.setPhoneNumber(rs.getString(5));
        w.setLoginId(rs.getString(6));
        //w.setLoginId(rs.getString(1).charAt(0)+rs.getString(2).charAt(0)+Integer.toString(w.getEmployeeId()));
        w.setIsAdmin(rs.getInt(7));
        w.setIsActive(rs.getInt(8));
        w.setEmail(rs.getString(9));
	return w;
        }      
}

