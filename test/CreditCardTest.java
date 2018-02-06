/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Credit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author syntel
 */
public class CreditCardTest {
    
    public CreditCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEX_YEAR method, of class CreditCard.
     */
    @Test
    public void testGetEX_YEAR() {
        System.out.println("getEX_YEAR");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getEX_YEAR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEX_YEAR method, of class CreditCard.
     */
    @Test
    public void testSetEX_YEAR() {
        System.out.println("setEX_YEAR");
        int EX_YEAR = 0;
        CreditCard instance = new CreditCard();
        instance.setEX_YEAR(EX_YEAR);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.getEX_YEAR());
    }

    /**
     * Test of getEX_MONTH method, of class CreditCard.
     */
    @Test
    public void testGetEX_MONTH() {
        System.out.println("getEX_MONTH");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getEX_MONTH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEX_MONTH method, of class CreditCard.
     */
    @Test
    public void testSetEX_MONTH() {
        System.out.println("setEX_MONTH");
        int EX_MONTH = 0;
        CreditCard instance = new CreditCard();
        instance.setEX_MONTH(EX_MONTH);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.getEX_MONTH());
    }

    /**
     * Test of toString method, of class CreditCard.
     */
    

    /**
     * Test of getCREDIT_ID method, of class CreditCard.
     */
    @Test
    public void testGetCREDIT_ID() {
        System.out.println("getCREDIT_ID");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getCREDIT_ID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCREDIT_ID method, of class CreditCard.
     */
    @Test
    public void testSetCREDIT_ID() {
        System.out.println("setCREDIT_ID");
        int CREDIT_ID = 0;
        CreditCard instance = new CreditCard();
        instance.setCREDIT_ID(CREDIT_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCUSTOMER_ID method, of class CreditCard.
     */
    @Test
    public void testGetCUSTOMER_ID() {
        System.out.println("getCUSTOMER_ID");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getCUSTOMER_ID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCUSTOMER_ID method, of class CreditCard.
     */
    @Test
    public void testSetCUSTOMER_ID() {
        System.out.println("setCUSTOMER_ID");
        int CUSTOMER_ID = 0;
        CreditCard instance = new CreditCard();
        instance.setCUSTOMER_ID(CUSTOMER_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCARD_NUMBER method, of class CreditCard.
     */
    @Test
    public void testGetCARD_NUMBER() {
        System.out.println("getCARD_NUMBER");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getCARD_NUMBER();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCARD_NUMBER method, of class CreditCard.
     */
    @Test
    public void testSetCARD_NUMBER() {
        System.out.println("setCARD_NUMBER");
        int CARD_NUMBER = 0;
        CreditCard instance = new CreditCard();
        instance.setCARD_NUMBER(CARD_NUMBER);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getBRAND method, of class CreditCard.
     */
    @Test
    public void testGetBRAND() {
        System.out.println("getBRAND");
        CreditCard instance = new CreditCard();
        String expResult = "";
        
        String result = instance.getBRAND();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setBRAND method, of class CreditCard.
     */
    @Test
    public void testSetBRAND() {
        System.out.println("setBRAND");
        String BRAND = "";
        CreditCard instance = new CreditCard();
        instance.setBRAND(BRAND);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSECURITY_NUMBER method, of class CreditCard.
     */
    @Test
    public void testGetSECURITY_NUMBER() {
        System.out.println("getSECURITY_NUMBER");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getSECURITY_NUMBER();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSECURITY_NUMBER method, of class CreditCard.
     */
    @Test
    public void testSetSECURITY_NUMBER() {
        System.out.println("setSECURITY_NUMBER");
        int SECURITY_NUMBER = 0;
        CreditCard instance = new CreditCard();
        instance.setSECURITY_NUMBER(SECURITY_NUMBER);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.getSECURITY_NUMBER());
    }

    /**
     * Test of getEXPERATION_DATE method, of class CreditCard.
     */
    @Test
    public void testGetEXPERATION_DATE() {
        System.out.println("getEXPERATION_DATE");
        CreditCard instance = new CreditCard();
        String expResult = "";
        String result = instance.getEXPERATION_DATE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEXPERATION_DATE method, of class CreditCard.
     */
    @Test
    public void testSetEXPERATION_DATE() {
        System.out.println("setEXPERATION_DATE");
        String EXPERATION_DATE = "";
        CreditCard instance = new CreditCard();
        instance.setEXPERATION_DATE(EXPERATION_DATE);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("",instance.getEXPERATION_DATE());
       
    }

    /**
     * Test of getNAME_ON_CARD method, of class CreditCard.
     */
    @Test
    public void testGetNAME_ON_CARD() {
        System.out.println("getNAME_ON_CARD");
        CreditCard instance = new CreditCard();
        String expResult = "";
        String result = instance.getNAME_ON_CARD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNAME_ON_CARD method, of class CreditCard.
     */
    @Test
    public void testSetNAME_ON_CARD() {
        System.out.println("setNAME_ON_CARD");
        String NAME_ON_CARD = "";
        CreditCard instance = new CreditCard();
        instance.setNAME_ON_CARD(NAME_ON_CARD);
        // TODO review the generated test code and remove the default call to fail.
       assertEquals("",instance.getNAME_ON_CARD());
    }

    /**
     * Test of getSTREET method, of class CreditCard.
     */
    @Test
    public void testGetSTREET() {
        System.out.println("getSTREET");
        CreditCard instance = new CreditCard();
        String expResult = "";
        String result = instance.getSTREET();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSTREET method, of class CreditCard.
     */
    @Test
    public void testSetSTREET() {
        System.out.println("setSTREET");
        String STREET = "";
        CreditCard instance = new CreditCard();
        instance.setSTREET(STREET);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("",instance.getSTREET());
    }

    /**
     * Test of getCITY method, of class CreditCard.
     */
    @Test
    public void testGetCITY() {
        System.out.println("getCITY");
        CreditCard instance = new CreditCard();
        String expResult = "";
        String result = instance.getCITY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setCITY method, of class CreditCard.
     */
    @Test
    public void testSetCITY() {
        System.out.println("setCITY");
        String CITY = "";
        CreditCard instance = new CreditCard();
        instance.setCITY(CITY);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("",instance.getCITY());
    }

    /**
     * Test of getAREA_CODE method, of class CreditCard.
     */
    @Test
    public void testGetAREA_CODE() {
        System.out.println("getAREA_CODE");
        CreditCard instance = new CreditCard();
        int expResult = 0;
        int result = instance.getAREA_CODE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAREA_CODE method, of class CreditCard.
     */
    @Test
    public void testSetAREA_CODE() {
        System.out.println("setAREA_CODE");
        int AREA_CODE = 0;
        CreditCard instance = new CreditCard();
        instance.setAREA_CODE(AREA_CODE);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.getAREA_CODE());
    }
    
}
