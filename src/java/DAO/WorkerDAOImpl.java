package DAO;

import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *  Implementation of WorkerDAO methods to perform multiple worker 
 *  requests to the Workers and Login databases 
 */
public class WorkerDAOImpl implements WorkerDAO {
    
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    // Method to call and return a list of workers on the Workers database
    @Override
    public List<Worker> findAll() {   
        return jdbcTemplate.query("select * from Workers order by employee_id", new WorkerRowMapper());
    }
    
    // Method to save a worker and login record into the Workers and Login databases
    @Override
    public void save(Worker e) { 
        // employeeId, loginId, and email are automatically generated
        e.setEmployeeId(new WorkerDAOImpl().getNextPrimaryKey());
        e.setLoginId(e.getFirstName().substring(0, 1)+e.getLastName().substring(0, 1)+Integer.toString(e.getEmployeeId()));
        e.setEmail(e.getFirstName()+"_"+e.getLastName()+"@mummys.com");
        
        //  Insert worker record into Workers database
        String p_query="insert into Workers values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(p_query, new Object[]{
                    e.getEmployeeId(), e.getFirstName(), e.getLastName(),
                    e.getGender(), e.getPhoneNumber(),
                    e.getLoginId(), e.getIsAdmin(), e.getIsActive(),
                    e.getEmail()});
        
        //  Also insert record into the Login database
        String d_query="insert into login values(?,?,?)";
        jdbcTemplate.update(d_query, new Object[]{
                    e.getLoginId(), "mummy1000", e.getIsAdmin() });
    }
    
    // Method queries the Workers database and generates an employeeId
    @Override
    public int getNextPrimaryKey(){ 
        int max;
        max = jdbcTemplate.queryForInt("SELECT MAX(EMPLOYEE_ID) FROM WORKERS");
        return max+1;
    }
    
    // Method to query the Workers database by employeeId and return result
    @Override
    public List<Worker> findById(Integer id) {
        try {
            List<Worker> worker = new ArrayList<>();
            return jdbcTemplate.query("SELECT * FROM WORKERS WHERE EMPLOYEE_ID = "+id, new WorkerRowMapper()); 
        } catch (NullPointerException e) {
            return null;
	}
    }

    // Method to query the Workers database and Update a worker record
    @Override
    public void edit(Worker worker) {
        String p_query="update Workers set first_name='"+worker.getFirstName()+
                 "', last_name='"+worker.getLastName()+"', gender='"+worker.getGender()+
                 "', phone_number='"+worker.getPhoneNumber()+"', is_admin="+worker.getIsAdmin()+
                 ", is_active="+worker.getIsActive()+" where employee_id="+worker.getEmployeeId();
        jdbcTemplate.update(p_query);
    }
    // Method to delete a worker and login record from the Workers and Login databases
    @Override
    public void delete(Worker worker) throws NullPointerException{
        // Delete login record
        String sq = "DELETE FROM LOGIN WHERE LOGIN_ID = '"+worker.getLoginId()+"'";
        jdbcTemplate.execute(sq);
        // Delete worker record
        String sql = "DELETE FROM WORKERS WHERE EMPLOYEE_ID = "+worker.getEmployeeId();
        jdbcTemplate.execute(sql);
    } 
}
