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
public class WorkerTest {
    
    public WorkerTest() {
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
     * Test of getFirstName method, of class Worker.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Worker instance = new Worker();
        String expResult = "Bill";
        instance.setFirstName(expResult);
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Worker.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Tom";
        Worker instance = new Worker();
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class Worker.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Worker instance = new Worker();
        String expResult = "Smith";
        instance.setLastName(expResult);
        String result = instance.getLastName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setLastName method, of class Worker.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Jones";
        Worker instance = new Worker();
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of getLoginId method, of class Worker.
     */
    @Test
    public void testGetLoginId() {
        System.out.println("getLoginId");
        Worker instance = new Worker();
        String expResult = "JK109485";
        instance.setLoginId(expResult);
        String result = instance.getLoginId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLoginId method, of class Worker.
     */
    @Test
    public void testSetLoginId() {
        System.out.println("setLoginId");
        String loginId = "HW109749";
        Worker instance = new Worker();
        instance.setLoginId(loginId);
        assertEquals(loginId, instance.getLoginId());
    }

    /**
     * Test of getGender method, of class Worker.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Worker instance = new Worker();
        String expResult = "Female";
        instance.setGender(expResult);
        String result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGender method, of class Worker.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "Male";
        Worker instance = new Worker();
        instance.setGender(gender);
        assertEquals(gender, instance.getGender());
    }

    /**
     * Test of getPhoneNumber method, of class Worker.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Worker instance = new Worker();
        String expResult = "6023139876";
        instance.setPhoneNumber(expResult);
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class Worker.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "4809871234";
        Worker instance = new Worker();
        instance.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, instance.getPhoneNumber());
    }

    /**
     * Test of getEmployeeId method, of class Worker.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        Worker instance = new Worker();
        int expResult = 100374;
        instance.setEmployeeId(expResult);
        int result = instance.getEmployeeId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmployeeId method, of class Worker.
     */
    @Test
    public void testSetEmployeeId() {
        System.out.println("setEmployeeId");
        int employeeId = 100039;
        Worker instance = new Worker();
        instance.setEmployeeId(employeeId);
        assertEquals(employeeId, instance.getEmployeeId());
    }

    /**
     * Test of getIsAdmin method, of class Worker.
     */
    @Test
    public void testGetIsAdmin() {
        System.out.println("getIsAdmin");
        Worker instance = new Worker();
        int expResult = 0;
        instance.setIsActive(expResult);
        int result = instance.getIsAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsAdmin method, of class Worker.
     */
    @Test
    public void testSetIsAdmin() {
        System.out.println("setIsAdmin");
        int isAdmin = 1;
        Worker instance = new Worker();
        instance.setIsAdmin(isAdmin);
        assertEquals(isAdmin, instance.getIsAdmin());
    }

    /**
     * Test of getIsActive method, of class Worker.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        Worker instance = new Worker();
        int expResult = 1;
        instance.setIsActive(expResult);
        int result = instance.getIsActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsActive method, of class Worker.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        int isActive = 0;
        Worker instance = new Worker();
        instance.setIsActive(isActive);
        assertEquals(isActive, instance.getIsActive());
    }

    /**
     * Test of getEmail method, of class Worker.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Worker instance = new Worker();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Worker.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "you@yahoo.com";
        Worker instance = new Worker();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }
    
}
