package Service;

import Model.Package;
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

public class PackageDAOImplTest {
    private DriverManagerDataSource dataSource;
    private Package testPkg;
    private PackageDAOImpl testDAO;
    private final double DELTA = 1e-15;
    private Connection conn;
    private Statement stmt;
    private int packageId;
    
    public PackageDAOImplTest() {
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
        
        testPkg = new Package(-1,"testPkg1","testDesc1","mCat1","img1",1.99,"spec1","mType1");

        //create the DAO and add the package
        testDAO = new PackageDAOImpl();
        testDAO.setDataSource(dataSource);
        
        testDAO.addPackage(testPkg);
        
        try {
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","hr","hr");
            ResultSet rs = stmt.executeQuery("SELECT Package_Id FROM Packages WHERE "
                    + "Name='testPkg1' AND "
                    + "Description='testDesc1' AND "
                    + "Meal_Category='mCat1' AND "
                    + "Image_Source='img1' AND "
                    + "Price=1.99 AND "
                    + "Is_Special='spec1' AND "
                    + "Meal_Type='mType1'");
            rs.next();
            packageId=rs.getInt(1);
        } catch (SQLException e) {System.out.println("Exception during setup: "+e);}
    }
    
    @After
    public void tearDown() {
        try {
            stmt.execute("DELETE FROM Packages WHERE Package_Id="+packageId);
        } catch (SQLException e) {System.out.println("Exception during tear down: "+e);}

    }

    @Test
    public void testAddPackage() {
        try {
            System.out.println("testAddPackage");
           
            //package added in the setup, now will assert it exists in the table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);
            
            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);
            
            //Test the resultant Package contents
            assertEquals("testPkg1", pkg.getName());
            assertEquals("testDesc1", pkg.getDescription());
            assertEquals("mCat1", pkg.getMealCategory());
            assertEquals("img1", pkg.getImageSource());
            assertEquals(1.99, pkg.getPrice(), DELTA);
            assertEquals("spec1", pkg.getIsSpecial());
            assertEquals("mType1", pkg.getMealType());
            
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testGetNextPackageId() {
        System.out.println("testGetNextPackageId");
        testDAO.setDataSource(dataSource);
        int result = testDAO.getNextPackageId();
        assert(result>0);
    }

    @Test
    public void testEditName() {
        try {
            System.out.println("testEditName");

            //create the DAO and add the package
            testDAO.editName(packageId, "testPkg2");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals("testPkg2", pkg.getName());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testEditDescription() {
        try {
            System.out.println("testEditDescription");

            //create the DAO and add the package
            testDAO.editDescription(packageId, "testDesc2");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals("testDesc2", pkg.getDescription());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testEditMealCategory() {
        try {
            System.out.println("testEditMealCategory");

            //create the DAO and add the package
            testDAO.editMealCategory(packageId, "mCat2");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals("mCat2", pkg.getMealCategory());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testEditImageSource() {
        try {
            System.out.println("testEditImageSource");

            //create the DAO and add the package
            testDAO.editImageSource(packageId, "img2");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals("img2", pkg.getImageSource());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testEditPrice() {
        try {
            System.out.println("testEditPrice");

            //create the DAO and add the package
            testDAO.editPrice(packageId, 2.99);
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals(2.99, pkg.getPrice(), DELTA);
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testEditIsSpecial() {
        try {
            System.out.println("testEditIsSpecial");

            //create the DAO and add the package
            testDAO.editIsSpecial(packageId, "spec2");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals("spec2", pkg.getIsSpecial());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }
    
    @Test
    public void testEditMealType() {
        try {
            System.out.println("testEditMealType");

            //create the DAO and add the package
            testDAO.editMealType(packageId, "mType2");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);

            //Test the resultant Package contents
            assertEquals("mType2", pkg.getMealType());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testDeletePackage() {
        try {
            System.out.println("testDeletePackage");

            //create the DAO and add the package
            testDAO.deletePackage(packageId);
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);

            //Use the method to test and store the contents into a Package object
            PackageRowMapper testMapper = new PackageRowMapper();
            
            //Test the resultant Package contents
            assertFalse(rs.next());
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }

    @Test
    public void testGetSinglePackageData() {      
        try {
            System.out.println("testGetSinglePackageData");
            
            //call the method to get the single package data
            Package result = testDAO.getSinglePackageData(packageId);
            
            //Use the method to test and store the contents into a Package object
            ResultSet rs = stmt.executeQuery("SELECT * FROM Packages WHERE Package_Id="+packageId);
            PackageRowMapper testMapper = new PackageRowMapper();
            rs.next();
            Package pkg = (Package)testMapper.mapRow(rs, 0);
            
            //Test the resultant Package contents
            assertEquals(pkg.getName(), pkg.getName());
            assertEquals(pkg.getDescription(), pkg.getDescription());
            assertEquals(pkg.getMealCategory(), pkg.getMealCategory());
            assertEquals(pkg.getImageSource(), pkg.getImageSource());
            assertEquals(pkg.getPrice(), pkg.getPrice(), DELTA);
            assertEquals(pkg.getIsSpecial(), pkg.getIsSpecial());
            assertEquals(pkg.getMealType(), pkg.getMealType());
            
        } catch (SQLException e) {System.out.println("Exception: "+e);}
    }
}
