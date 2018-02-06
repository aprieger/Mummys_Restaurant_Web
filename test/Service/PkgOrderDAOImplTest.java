package Service;

import Model.PkgOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class PkgOrderDAOImplTest {
    private DriverManagerDataSource dataSource;
    private PkgOrder testPkgOrder;
    private PkgOrderDAOImpl testDAO;
    private final double DELTA = 1e-15;
    private Connection conn;
    private Statement stmt;
    private int pkgOrderId;
    
    public PkgOrderDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            stmt = conn.createStatement();
        } catch (SQLException e) {System.out.println("Exception during setup: "+e);}
            
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("hr");
        dataSource.setPassword("hr");
        
        testPkgOrder = new PkgOrder(-1,1,1,1,1.99,1,1);

        //create the DAO and add the package
        testDAO = new PkgOrderDAOImpl();
        testDAO.setDataSource(dataSource);
        
        testDAO.addOpenPkgOrder(testPkgOrder);
        
        try {
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            ResultSet rs = stmt.executeQuery("SELECT Pkg_Order_Id FROM PkgOrders WHERE "
                    + "Order_Id=1 AND "
                    + "Package_Id=1 AND "
                    + "Customer_Id=1 AND "
                    + "Price_Per_Pkg=1.99 AND "
                    + "Quantity=1 AND "
                    + "Is_Open=1");
            rs.next();
            pkgOrderId=rs.getInt(1);
        } catch (SQLException e) {System.out.println("Exception during setup: "+e);}
    }
    
    @After
    public void tearDown() {
        try {
            stmt.execute("DELETE FROM PkgOrders WHERE Pkg_Order_Id="+pkgOrderId);
        } catch (SQLException e) {System.out.println("Exception during tear down: "+e);}

    }

    @Test
    public void testAddOpenPkgOrder() {
        try {
            System.out.println("testAddPackage");
           
            //package added in the setup, now will assert it exists in the table
            ResultSet rs = stmt.executeQuery("SELECT * FROM PkgOrders WHERE Pkg_Order_Id="+pkgOrderId);
            
            //Use the method to test and store the contents into a Package object
            PkgOrderRowMapper testMapper = new PkgOrderRowMapper();
            rs.next();
            PkgOrder pkgOrder = (PkgOrder)testMapper.mapRow(rs, 0);
            
            assertEquals(1, pkgOrder.getOrderId());
            assertEquals(1, pkgOrder.getPackageIdKey());
            assertEquals(1, pkgOrder.getCustomerId());
            assertEquals(1.99, pkgOrder.getPricePerPkg(), DELTA);
            assertEquals(1, pkgOrder.getQuantity());
            assertEquals(1, pkgOrder.getIsOpen());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }
    
    @Test
    public void testEditOrderId() {
    
    }
    
    @Test
    public void testEditPackageId(){
    
    }
    
    @Test
    public void testEditCustomerId(){
        
    }
    
    @Test
    public void testEditQuantity(){
        
    }
    
    @Test
    public void testEditIsOpen(){
        
    }
    
    @Test
    public void testClosePkgOrder (){
        
    }
    
    @Test
    public void testDeletePkgOrder(){
        
    }
    
    @Test
    public void testGetNextPkgOrderId(){
        
    }
    
    @Test
    public void testGetSinglePkgOrder(){
        
    }
    
    @Test
    public void testGetOpenPkgOrdersByCustomer(){
        
    }
    
    @Test
    public void testGetAllPkgOrdersByOrder(){
        
    }
    
    @Test
    public void testGetAllClosedPkgOrders(){
        
    }
    
    @Test
    public void testGetFinalPrice(){
        
    }
    
    @Test
    public void testGetOpenPkgOrdersByCustomerAll(){
        
    }
}