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
        return jdbcTemplate.query ( "select * from CREDIT_CARDS", new CreditCardRowMapper());
    }
    
    public List getAllRecordsByUserId(int User_Id) 
    {   
        System.out.println(User_Id);
        return jdbcTemplate.query ( "select * from CREDIT_CARDS where CUSTOMER_ID = "+User_Id+"", new CreditCardRowMapper());
    }
    
    public List getAllRecordsByCreditId(int Credit_Id) 
    {   
        System.out.println(Credit_Id);
        return jdbcTemplate.query ( "select * from CREDIT_CARDS where CUSTOMER_ID = "+Credit_Id+"", new CreditCardRowMapper());
    }
}
