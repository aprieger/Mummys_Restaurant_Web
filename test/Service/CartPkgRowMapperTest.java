package Service;

import Model.CartPkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

//JUnit test suite that tests teh CartPkgRowMapper which is used to map the 
//results from a SQL query into a cartPkg object
public class CartPkgRowMapperTest {
    
    public CartPkgRowMapperTest() {
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
            stmt.execute("INSERT INTO Packages (Package_Id, Name, Description, Meal_Category, Image_Source, Price, Is_Special, Meal_Type)"
                + " VALUES (-1,'testPkg1','testDesc1','mCat1','img1',1.99,'spec1','mType1')");
            stmt.execute("INSERT INTO PkgOrders (Pkg_Order_Id, Order_Id, Package_Id, Customer_Id, Price_Per_Pkg, Quantity, Is_Open) "
                + " VALUES (-1,-1,-1,-1,1.99,1,0)");
            stmt.execute("INSERT INTO Packages (Package_Id, Name, Description, Meal_Category, Image_Source, Price, Is_Special, Meal_Type)"
                + " VALUES (-2,'testPkg2','testDesc2','mCat2','img2',2.99,'spec2','mType2')");
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
            stmt.execute("DELETE FROM Packages WHERE Package_Id=-1");
            stmt.execute("DELETE FROM Packages WHERE Package_Id=-2");
            stmt.execute("DELETE FROM PkgOrders WHERE Pkg_Order_Id=-1");
            stmt.execute("DELETE FROM PkgOrders WHERE Pkg_Order_Id=-2");
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM PkgOrders O, Packages P WHERE O.Pkg_Order_Id=888 AND O.Package_Id=P.Package_Id");
            
            //Use the method to test and store the contents into a cartPkgObject
            CartPkgRowMapper testMapper = new CartPkgRowMapper();
            rs.next();
            CartPkg cartPkg = (CartPkg)testMapper.mapRow(rs, 0);
            
            //Test the resultant cartPkg contents
            assertEquals(-1, cartPkg.getoPkgOrderId());
            assertEquals(-1, cartPkg.getoOrderId());
            assertEquals(-1, cartPkg.getoPackageId());
            assertEquals(-1, cartPkg.getoCustomerId());
            assertEquals(1.99, cartPkg.getoPricePerPkg(), DELTA);
            assertEquals(1, cartPkg.getoQuantity());
            assertEquals(0, cartPkg.getoIsOpen());
            assertEquals(-1, cartPkg.getpPackageId());
            assertEquals("testPkg1", cartPkg.getpName());
            assertEquals("testDesc1", cartPkg.getpDescription());
            assertEquals("mCat1", cartPkg.getpMealCategory());
            assertEquals("img1", cartPkg.getpImageSource());
            assertEquals(1.99, cartPkg.getpPrice(), DELTA);
            assertEquals("spec1", cartPkg.getpIsSpecial());
            assertEquals("mType1", cartPkg.getpMealType());
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
            ResultSet rs = stmt.executeQuery(""
                    + "SELECT * FROM PkgOrders O, Packages P "
                    + "WHERE O.Package_Id=P.Package_Id AND O.Pkg_Order_Id=888 "
                    + "OR O.Package_Id=P.Package_Id AND O.Pkg_Order_Id=999");
            
            //Use the method to test and store the contents into a cartPkgObject
            CartPkgRowMapper testMapper = new CartPkgRowMapper();
            ArrayList<CartPkg> cartPkgList = new ArrayList();
            while (rs.next())
                cartPkgList.add((CartPkg)testMapper.mapRow(rs, 0));
            
            //Test the cartPkg contents at List index 0
            CartPkg cartPkg = cartPkgList.get(0);
            assertEquals(-1, cartPkg.getoPkgOrderId());
            assertEquals(-1, cartPkg.getoOrderId());
            assertEquals(-1, cartPkg.getoPackageId());
            assertEquals(-1, cartPkg.getoCustomerId());
            assertEquals(1.99, cartPkg.getoPricePerPkg(), DELTA);
            assertEquals(1, cartPkg.getoQuantity());
            assertEquals(0, cartPkg.getoIsOpen());
            assertEquals(-1, cartPkg.getpPackageId());
            assertEquals("testPkg1", cartPkg.getpName());
            assertEquals("testDesc1", cartPkg.getpDescription());
            assertEquals("mCat1", cartPkg.getpMealCategory());
            assertEquals("img1", cartPkg.getpImageSource());
            assertEquals(1.99, cartPkg.getpPrice(), DELTA);
            assertEquals("spec1", cartPkg.getpIsSpecial());
            assertEquals("mType1", cartPkg.getpMealType());
            
            //Test the cartPkg contents at List index 1
            cartPkg = cartPkgList.get(1);
            assertEquals(-2, cartPkg.getoPkgOrderId());
            assertEquals(-2, cartPkg.getoOrderId());
            assertEquals(-2, cartPkg.getoPackageId());
            assertEquals(-2, cartPkg.getoCustomerId());
            assertEquals(2.99, cartPkg.getoPricePerPkg(), DELTA);
            assertEquals(1, cartPkg.getoQuantity());
            assertEquals(0, cartPkg.getoIsOpen());
            assertEquals(-2, cartPkg.getpPackageId());
            assertEquals("testPkg2", cartPkg.getpName());
            assertEquals("testDesc2", cartPkg.getpDescription());
            assertEquals("mCat2", cartPkg.getpMealCategory());
            assertEquals("img2", cartPkg.getpImageSource());
            assertEquals(2.99, cartPkg.getpPrice(), DELTA);
            assertEquals("spec2", cartPkg.getpIsSpecial());
            assertEquals("mType2", cartPkg.getpMealType());
       } catch (Exception e) {System.out.println(e.getMessage());}
    }
}
