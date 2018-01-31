package Service;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import Model.Package;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//Package DAO implementation class that impelments the PackageDAO class
//creates functions to be used by various controllers to communicated between the database
public class PackageDAOImpl implements PackageDAO{
    //creates and initializes the jdbcTemplate object, that allows communication to the data base
    private static JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addPackage(Package pkg) {
        String updateStr = ("INSERT INTO Packages (Package_Id, Name, Description, Meal_Category, Image_Source, Price, Is_Special, Meal_Type)"
                + " VALUES (?,?,?,?,?,?,?,?)");
        jdbcTemplate.update(updateStr, new Object[]{
                this.getNextPackageId(), pkg.getName(), pkg.getDescription(), pkg.getMealCategory(), 
                pkg.getImageSource(), pkg.getPrice(), pkg.getIsSpecial(), pkg.getMealType()});
    }
    @Override
    public int getNextPackageId(){
        return jdbcTemplate.queryForObject("SELECT MAX(Package_Id)FROM Packages",Integer.class)+1;
    }
    @Override
    public void editPackage(int editPackageId, String name, String description, String mealCategory, String imageSource, double price, String isSpecial, String mealType) {
        this.editName(editPackageId, name);
        this.editDescription(editPackageId, description);
        this.editMealCategory(editPackageId, mealCategory);
        this.editImageSource(editPackageId, imageSource);
        this.editPrice(editPackageId, price);
        this.editIsSpecial(editPackageId, isSpecial);
        this.editMealType(editPackageId, mealType);
    }
    
    @Override
    public void editName(int editPackageId, String newName) {
        jdbcTemplate.execute("UPDATE Packages SET Name='"+newName+"' WHERE Package_Id="+editPackageId);
    }
    
    @Override
    public void editDescription(int editPackageId, String newDescription) {
        String updateStr = ("UPDATE Packages SET Description=? WHERE Package_Id=?");
        int argsTypes[]={Types.VARCHAR,Types.INTEGER};
        jdbcTemplate.update(updateStr, new Object[]{newDescription, editPackageId}, argsTypes);
    }
    
    @Override
    public void editMealCategory(int editPackageId, String newMealCategory) {
        String updateStr = ("UPDATE Packages SET Meal_Category=? WHERE Package_Id=?");
        int argsTypes[]={Types.VARCHAR,Types.INTEGER};
        jdbcTemplate.update(updateStr, new Object[]{newMealCategory, editPackageId},argsTypes);
    }
    
    @Override
    public void editImageSource(int editPackageId, String newImageSource) {
        String updateStr = ("UPDATE Packages SET Image_Source=? WHERE Package_Id=?");
        int argsTypes[]={Types.VARCHAR,Types.INTEGER};
        jdbcTemplate.update(updateStr, new Object[]{newImageSource, editPackageId},argsTypes);
    }
    
    @Override
    public void editPrice(int editPackageId, double newPrice) {
        String updateStr = ("UPDATE Packages SET Price=? WHERE Package_Id=?");
        int argsTypes[]={Types.DOUBLE,Types.INTEGER};
        jdbcTemplate.update(updateStr, new Object[]{newPrice, editPackageId},argsTypes);
    }
    
    @Override
    public void editIsSpecial(int editPackageId, String newIsSpecial) {
        String updateStr = ("UPDATE Packages SET Is_Special=? WHERE Package_Id=?");
        int argsTypes[]={Types.VARCHAR,Types.INTEGER};
        jdbcTemplate.update(updateStr, new Object[]{newIsSpecial, editPackageId},argsTypes);
    }
    
    @Override
    public void editMealType(int editPackageId, String newMealType) {
        String updateStr = ("UPDATE Packages SET Meal_Type=? WHERE Package_Id=?");
        int argsTypes[]={Types.VARCHAR,Types.INTEGER};
        jdbcTemplate.update(updateStr, new Object[]{newMealType, editPackageId},argsTypes);
    }
    
    @Override
    public void deletePackage(int deletePackageId) {
        String updateStr = ("DELETE FROM Packages WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{deletePackageId});
    }
    
    @Override
    public List getAllPackageData() {
        return jdbcTemplate.query("select * from Packages", new PackageRowMapper());
    }
    
    @Override
    public Package getSinglePackageData(int packageId) {
        Object o[]={packageId};
        int argsTypes[]={Types.INTEGER};
        RowMapper mapper=new PackageRowMapper();
        List l = jdbcTemplate.query("SELECT * FROM Packages WHERE Package_Id=?",o,argsTypes,mapper);
        Iterator it=l.iterator();
        Package p=(Package)it.next();
        return p;
    }
}