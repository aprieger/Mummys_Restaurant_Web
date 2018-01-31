/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Worker;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 *
 * @author syntel
 */
@Repository
public class WorkerDAOImpl implements WorkerDAO {
    
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    
    @Override
    public List<Worker> findAll() 
    {    
        List<Worker> result = jdbcTemplate.query ( "select * from Workers", new WorkerRowMapper());
        return result;
    }
    
    @Override
    public void save(Worker e) { 
        //  Inserting using prepared Statement
        System.out.println(e.toString());
        e.setEmployeeId(new WorkerDAOImpl().getNextPrimaryKey());
        e.setLoginId(e.getFirstName().substring(0, 1)+e.getLastName().substring(0, 1)+Integer.toString(e.getEmployeeId()));
        e.setEmail(e.getFirstName()+"_"+e.getLastName()+"@mummys.com");
        
        String p_query="insert into Workers values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(p_query, new Object[]{
                    e.getEmployeeId(), e.getFirstName(), e.getLastName(),
                    e.getGender(), e.getPhoneNumber(),
                    e.getLoginId(), e.getIsAdmin(), e.getIsActive(),
                    e.getEmail()});
        
        String d_query="insert into login values(?,?,?)";
        jdbcTemplate.update(d_query, new Object[]{
                    e.getLoginId(), "mummy1000", e.getIsAdmin() });
    }
    
    @Override
    public int getNextPrimaryKey(){ 
        int max;
        max = jdbcTemplate.queryForInt("SELECT MAX(EMPLOYEE_ID) FROM WORKERS");
        return max+1;
    }
    
    @Override
    public String getLoginId() {
      
        return "skdjf";
    }

    @Override
	public Worker findById(Integer id) {

	    Object o[]={id};
            int argsTypes[]={Types.VARCHAR};
            RowMapper mapper=new WorkerRowMapper();
            try {
            List l= jdbcTemplate.query ( "select * from Workers where first_name = ?",o,argsTypes,mapper);
            Iterator it=l.iterator();
            Worker e=(Worker)it.next();
            return e;	
	
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
                        return null;
		}
	}

	@Override
	public void update(Worker worker) {

		String p_query="update Workers set values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(p_query, new Object[]{
                    worker.getEmployeeId(),worker.getFirstName(),worker.getLastName(),
                    worker.getGender(), worker.getPhoneNumber(),
                    worker.getLoginId(), worker.getIsAdmin(),worker.getIsActive()});
	}

	@Override
	public void delete(Integer id) {
            
		String sql = "DELETE FROM WORKERS WHERE id= "+id;
		jdbcTemplate.execute(sql);
	}

    
}
