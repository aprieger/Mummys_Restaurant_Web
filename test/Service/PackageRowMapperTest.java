package Service;

import Model.Package;
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

//JUnit test suite that tests the PackageRowMapper which is used to map the 
//results from a SQL query into a Package object
public class PackageRowMapperTest {
    public PackageRowMapperTest() {
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
            stmt.execute("INSERT INTO Packages (Package_Id, Name, Description, Meal_Category, Image_Source, Price, Is_Special, Meal_Type)"
                + " VALUES (-2,'testPkg2','testDesc2','mCat2','img2',2.99,'spec2','mType2')");
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id=-1");
            
            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);
            
            //Test the resultant Package contents
            assertEquals(-1, pkg.getPackageId());
            assertEquals("testPkg1", pkg.getName());
            assertEquals("testDesc1", pkg.getDescription());
            assertEquals("mCat1", pkg.getMealCategory());
            assertEquals("img1", pkg.getImageSource());
            assertEquals(1.99, pkg.getPrice(), DELTA);
            assertEquals("spec1", pkg.getIsSpecial());
            assertEquals("mType1", pkg.getMealType());          
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id=-1 OR Package_Id=-2 ORDERBY Package_Id");
            
            //Use the method to test and store the contents into a Package Object
            PackageRowMapper testMapper = new PackageRowMapper();
            ArrayList<Package> packageList = new ArrayList();
            while (rs.next())
                packageList.add((Package)testMapper.mapRow(rs, 0));
            
            //Test the Package contents at List index 0
            Package pkg = packageList.get(0);
            assertEquals(-2, pkg.getPackageId());
            assertEquals("testPkg2", pkg.getName());
            assertEquals("testDesc2", pkg.getDescription());
            assertEquals("mCat2", pkg.getMealCategory());
            assertEquals("img2", pkg.getImageSource());
            assertEquals(2.99, pkg.getPrice(), DELTA);
            assertEquals("spec2", pkg.getIsSpecial());
            assertEquals("mType2", pkg.getMealType());  
            
            //Test the Package contents at List index 1
            pkg = packageList.get(1);
            assertEquals(-1, pkg.getPackageId());
            assertEquals("testPkg1", pkg.getName());
            assertEquals("testDesc1", pkg.getDescription());
            assertEquals("mCat1", pkg.getMealCategory());
            assertEquals("img1", pkg.getImageSource());
            assertEquals(1.99, pkg.getPrice(), DELTA);
            assertEquals("spec1", pkg.getIsSpecial());
            assertEquals("mType1", pkg.getMealType());  
       } catch (Exception e) {System.out.println(e.getMessage());}
    }
}
