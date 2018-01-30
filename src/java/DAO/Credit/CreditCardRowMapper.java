package DAO.Credit;

import domain.Credit.CreditCard;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

 class CreditCardRowMapper implements RowMapper {
     
      public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
       	CreditCard e = new CreditCard();
        
        e.setCREDIT_ID(rs.getInt("CREDIT_ID"));
        e.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID")); 
        e.setCARD_NUMBER(rs.getInt("CARD_NUMBER"));
        e.setBRAND(rs.getString("BRAND")); 
        e.setSECURITY_NUMBER(rs.getString("SECURITY_NUMBER"));
        //e.setEXPERATION_DATE(rs.getString("EXPERATION_DATE"));
        e.setNAME_ON_CARD(rs.getString("NAME_ON_CARD")); 
        e.setSTREET(rs.getString("STREET")); 
        e.setCITY(rs.getString("CITY")); 
        e.setAREA_CODE(rs.getInt("AREA_CODE"));
        e.setEX_MONTH(rs.getInt("EX_MONTH"));
        e.setEX_YEAR(rs.getInt("EX_YEAR"));
	return e;
        }      
}