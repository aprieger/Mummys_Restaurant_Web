/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class LoginTest {
    
    public LoginTest() {
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
     * Test of getLoginId method, of class Login.
     */
    @Test
    public void testGetLoginId() {
        System.out.println("getLoginId");
        Login instance = new Login();
        String expResult = "RL109354";
        instance.setLoginId(expResult);
        String result = instance.getLoginId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setLoginId method, of class Login.
     */
    @Test
    public void testSetLoginId() {
        System.out.println("setLoginId");
        String loginId = "RL109354";
        Login instance = new Login();
        instance.setLoginId(loginId);
        assertEquals(loginId, instance.getLoginId());
    }

    /**
     * Test of getPassword method, of class Login.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Login instance = new Login();
        String expResult = "password";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Login.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        Login instance = new Login();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    /**
     * Test of getUserType method, of class Login.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        Login instance = new Login();
        int expResult = 0;
        instance.setUserType(0);
        int result = instance.getUserType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserType method, of class Login.
     */
    @Test
    public void testSetUserType() {
        System.out.println("setUserType");
        int userType = 2;
        Login instance = new Login();
        instance.setUserType(userType);
        assertEquals(userType, instance.getUserType());
    }
    
}
