package DAO;

import domain.CreditCard;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreditCardDAOImpl implements CreditCardDAO {
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource)
    {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    public List getAllRecords() 
    {        
        return jdbcTemplate.query ( "select * from CREDIT_CARDS where not is_deleted = 1", new CreditCardRowMapper());
    }
    
    public List getAllRecordsByUserId(int User_Id) 
    {   
        System.out.println(User_Id);
        return jdbcTemplate.query ( "select * from CREDIT_CARDS where CUSTOMER_ID = "+User_Id+" And not IS_DELETED = 1", new CreditCardRowMapper());
    }
    
    public List getAllRecordsByCreditId(int Credit_Id) 
    {   
        System.out.println(Credit_Id);
        return jdbcTemplate.query ( "select * from CREDIT_CARDS where CUSTOMER_ID = "+Credit_Id+" And not IS_DELETED = 1", new CreditCardRowMapper());
    }
    
    public void deleteAllRecordsByUserId(int User_Id) 
    {   
        System.out.println(User_Id);
        
        jdbcTemplate.execute ("UPDATE CREDIT_CARDS SET IS_DELETED=1 where CUSTOMER_ID = "+User_Id+"");    
    } 
    
    public void deleteAllRecordsByCreditId(int Credit_Id) 
    {   
        System.out.println(Credit_Id);
        
        jdbcTemplate.execute ("UPDATE CREDIT_CARDS SET IS_DELETED=1 where CUSTOMER_ID = "+Credit_Id+"");    
    }
    
    public void addRecord(CreditCard c)
    {
        c.setCUSTOMER_ID(1); //NEEDS to be passed a real value
        c.setCREDIT_ID(jdbcTemplate.queryForInt("Select MAX (CREDIT_ID) from Credit_cards")+1);
        
        jdbcTemplate.execute("insert into credit_cards values ( "
                + c.getCREDIT_ID()+" ,"
                + c.getCUSTOMER_ID()+" ,"
                + c.getCARD_NUMBER()+" ,'"
                + c.getBRAND()+"' ,"
                + c.getSECURITY_NUMBER()+" ,'"
                + c.getEXPERATION_DATE()+"' ,'"
                + c.getNAME_ON_CARD()+"' ,'"
                + c.getSTREET()+"' ,'"
                + c.getCITY()+"' ,"
                + c.getAREA_CODE()+" ,"
                + 0 +")");
    }
}
