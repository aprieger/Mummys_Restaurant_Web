package DAO;

import domain.Worker;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 * RowMapper class to set a Worker object
 * 
 */
public class WorkerRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
       	Worker w = new Worker();
        w.setEmployeeId(rs.getInt(1));
	w.setFirstName(rs.getString(2));
        w.setLastName(rs.getString(3));
        w.setGender(rs.getString(4));
        w.setPhoneNumber(rs.getString(5));
        w.setLoginId(rs.getString(6));
        w.setIsAdmin(rs.getInt(7));
        w.setIsActive(rs.getInt(8));
        w.setEmail(rs.getString(9));
	return w;
        }      
}

