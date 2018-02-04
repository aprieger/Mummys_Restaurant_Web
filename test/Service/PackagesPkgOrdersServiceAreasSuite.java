package Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author syntel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Service.ServiceAreaRowMapperTest.class, Service.CartPkgRowMapperTest.class, Service.PackageRowMapperTest.class, Service.PackageDAOImplTest.class, Service.PkgOrderDAOImplTest.class, Service.PkgOrderRowMapperTest.class, Service.ServiceAreaDAOImplTest.class})
public class PackagesPkgOrdersServiceAreasSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
