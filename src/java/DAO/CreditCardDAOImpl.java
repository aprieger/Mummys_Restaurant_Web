/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author syntel
 */
public class CreditCardDAOImpl implements CreditCardDAO {
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource)
    {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    public List getAllRecords() 
    {        
        return jdbcTemplate.query ( "select * from CREDIT_CARDS Where Credit_ID = 1", new CreditCardRowMapper());
    }
}
