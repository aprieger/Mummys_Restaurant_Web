package Service;

import Model.Package;
import Model.ServiceArea;
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

//JUnit test suite that tests the ServiceAreaRowMapper which is used to map the 
//results from a SQL query into a ServiceArea object
public class ServiceAreaRowMapperTest {
    public ServiceAreaRowMapperTest() {
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
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO ServiceAreas (Area_Id, Name, Area_Code, Package_Id, Tax_Rate)"
                + " VALUES (-1,'testName1',-1,-1,.1)");
            stmt.execute("INSERT INTO ServiceAreas (Area_Id, Name, Area_Code, Package_Id, Tax_Rate)"
                + " VALUES (-2,'testName2',-2,-2,.2)");
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    
    @After
    public void tearDown() {
        try {
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM ServiceAreas WHERE Area_Id=-1");
            stmt.execute("DELETE FROM ServiceAreas WHERE Area_Id=-2");
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM ServiceAreas WHERE Area_Id=-1");
            
            //Use the method to test and store the contents into a ServiceArea object
            ServiceAreaRowMapper testMapper = new ServiceAreaRowMapper();
            rs.next();
            ServiceArea svcArea = (ServiceArea)testMapper.mapRow(rs, 0);
            
            //Test the resultant ServiceArea contents
            assertEquals(-1, svcArea.getAreaId());
            assertEquals("testName1", svcArea.getName());
            assertEquals(-1, svcArea.getAreaCode());
            assertEquals(-1, svcArea.getPackageId());
            assertEquals(.1, svcArea.getTaxRate(), DELTA);
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM ServiceAreas WHERE Area_Id=-1 OR Area_Id=-2 ORDERBY Area_Id");
            
            //Use the method to test and store the contents into a ServiceArea Object
            ServiceAreaRowMapper testMapper = new ServiceAreaRowMapper();
            ArrayList<ServiceArea> serviceAreaList = new ArrayList();
            while (rs.next())
                serviceAreaList.add((ServiceArea)testMapper.mapRow(rs, 0));
            
            //Test the ServiceArea contents at List index 0
            ServiceArea svcArea = serviceAreaList.get(0);
            assertEquals(-2, svcArea.getAreaId());
            assertEquals("testName2", svcArea.getName());
            assertEquals(-2, svcArea.getAreaCode());
            assertEquals(-2, svcArea.getPackageId());
            assertEquals(.2, svcArea.getTaxRate(), DELTA);

            //Test the ServiceArea contents at List index 1
            svcArea = serviceAreaList.get(1);
            assertEquals(-1, svcArea.getAreaId());
            assertEquals("testName1", svcArea.getName());
            assertEquals(-1, svcArea.getAreaCode());
            assertEquals(-1, svcArea.getPackageId());
            assertEquals(.1, svcArea.getTaxRate(), DELTA); 
       } catch (Exception e) {System.out.println(e.getMessage());}
    }
}
