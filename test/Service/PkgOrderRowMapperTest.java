package Service;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

//JUnit test suite that tests the PkgOrderRowMapper which is used to map the 
//results from a SQL query into a PkgOrder object
public class PkgOrderRowMapperTest {
    public PkgOrderRowMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    //create new entries to query using negative keys to test
    @Before
    public void setUp() {
        try {
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO PkgOrders (Pkg_Order_Id, Order_Id, Package_Id, Customer_Id, Price_Per_Pkg, Quantity, Is_Open) "
                + " VALUES (-1,-1,-1,-1,1.99,1,0)");
            stmt.execute("INSERT INTO PkgOrders (Pkg_Order_Id, Order_Id, Package_Id, Customer_Id, Price_Per_Pkg, Quantity, Is_Open) "
                + " VALUES (-2,-2,-2,-2,2.99,2,0)");
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    
    //delete the entries in the ta le that were created for testing
    @After
    public void tearDown() {
        try {
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM Packages WHERE Pkg_Order_Id=-1");
            stmt.execute("DELETE FROM Packages WHERE Pkg_Order_Id=-2");
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    @Test
    public void testMapRowOneEntry() throws Exception {
        try {
            //use to assert doubles
            final double DELTA = 1e-15;
            //establish connection, create and exectute statement, and store results
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PkgOrders WHERE Pkg_Order_Id=-1");
            
            //Use the method to test and store the contents into a PkgOrder object
            PkgOrderRowMapper testMapper = new PkgOrderRowMapper();
            rs.next();
            PkgOrder pkgOrder = (PkgOrder)testMapper.mapRow(rs, 0);
            
            //Test the resultant PkgOrder contents
            assertEquals(-1, pkgOrder.getPkgOrderId());
            assertEquals(-1, pkgOrder.getOrderId());
            assertEquals(-1, pkgOrder.getPackageIdKey());
            assertEquals(-1, pkgOrder.getCustomerId());
            assertEquals(1.99, pkgOrder.getPricePerPkg(), DELTA);
            assertEquals(1, pkgOrder.getQuantity());
            assertEquals(0, pkgOrder.getIsOpen());
       } catch (Exception e) {System.out.println(e.getMessage());}
    }
    
    @Test
    public void testMapRowManyEntries() throws Exception {
        try {
            //use to assert doubles
            final double DELTA = 1e-15;
            //establish connection, create and exectute statement, and store results
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PkgOrders WHERE Pkg_Order_Id=-1 OR Pkg_Order_Id=-2 ORDERBY Pkg_Order_Id");
            
            //Use the method to test and store the contents into a PkgOrder object
            PkgOrderRowMapper testMapper = new PkgOrderRowMapper();
            ArrayList<PkgOrder> pkgOrderList = new ArrayList();
            while (rs.next())
                pkgOrderList.add((PkgOrder)testMapper.mapRow(rs, 0));
            
            //Test the resultant PkgOrder contents
            PkgOrder pkgOrder = pkgOrderList.get(0);
            assertEquals(-1, pkgOrder.getPkgOrderId());
            assertEquals(-1, pkgOrder.getOrderId());
            assertEquals(-1, pkgOrder.getPackageIdKey());
            assertEquals(-1, pkgOrder.getCustomerId());
            assertEquals(1.99, pkgOrder.getPricePerPkg(), DELTA);
            assertEquals(1, pkgOrder.getQuantity());
            assertEquals(0, pkgOrder.getIsOpen());
            
            pkgOrder = pkgOrderList.get(1);
            assertEquals(-1, pkgOrder.getPkgOrderId());
            assertEquals(-1, pkgOrder.getOrderId());
            assertEquals(-1, pkgOrder.getPackageIdKey());
            assertEquals(-1, pkgOrder.getCustomerId());
            assertEquals(1.99, pkgOrder.getPricePerPkg(), DELTA);
            assertEquals(1, pkgOrder.getQuantity());
            assertEquals(0, pkgOrder.getIsOpen());
       } catch (Exception e) {System.out.println(e.getMessage());}
    }
}
