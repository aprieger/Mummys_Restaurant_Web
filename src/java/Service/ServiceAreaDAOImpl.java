package Service;

import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import Model.ServiceArea;

//ServiceAreaDAO implementation class that impelments the ServiceAreaDAO class
//creates functions to be used by various controllers to communicated between the database
public class ServiceAreaDAOImpl implements ServiceAreaDAO{
    //creates and initializes the jdbcTemplate object, that allows communication to the data base
    private static JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addServiceArea(ServiceArea svc) {           
        String updateStr = ("INSERT INTO ServiceAreas (Area_Id, Name, Area_Code, Package_Id, Tax_Rate)"
                + " VALUES (?,?,?,?,?)");
        jdbcTemplate.update(updateStr, new Object[]{
                this.getNextAreaId(), svc.getName(), svc.getAreaCode(), svc.getPackageId(), svc.getTaxRate()});
    }
    @Override
    public int getNextAreaId(){
        return jdbcTemplate.queryForObject("SELECT MAX(Area_Id)FROM ServiceAreas",Integer.class)+1;
    }
    @Override
    public void editServiceArea(ServiceArea svcEdit){
        this.editName(svcEdit.getAreaId(),svcEdit.getName());
        this.editAreaCode(svcEdit.getAreaId(),svcEdit.getAreaCode());
        this.editPackageId(svcEdit.getAreaId(), svcEdit.getPackageId());
        this.editTaxRate(svcEdit.getAreaId(), svcEdit.getTaxRate());
    }
    
    @Override
    public void editName(int editServiceAreaId, String newName) {
        String updateStr = ("UPDATE ServiceAreas SET Name='"+newName+"' WHERE Area_Id="+editServiceAreaId);
        jdbcTemplate.execute(updateStr);
    }
    @Override
    public void editAreaCode(int editServiceAreaId, int newAreaCode) {
        String updateStr = ("UPDATE ServiceAreas SET Area_Code="+newAreaCode+" WHERE Area_Id="+editServiceAreaId);
        jdbcTemplate.execute(updateStr);
    }
    @Override
    public void editPackageId(int editServiceAreaId, int packageId) {
        String updateStr = ("UPDATE ServiceAreas SET Package_Id="+packageId+" WHERE Area_Id="+editServiceAreaId);
        jdbcTemplate.execute(updateStr);
    }
    @Override
    public void editTaxRate(int editServiceAreaId, double newTaxRate) {
        String updateStr = ("UPDATE ServiceAreas SET Tax_Rate="+newTaxRate+" WHERE Area_Id="+editServiceAreaId);
        jdbcTemplate.execute(updateStr);
    }
    @Override
    public void deleteServiceArea(int deleteServiceAreaId) {
        String updateStr = ("DELETE FROM ServiceAreas WHERE Area_Id="+deleteServiceAreaId);
        jdbcTemplate.execute(updateStr);
    }
    @Override
    public ServiceArea getSingleServiceAreaData(int inputAreaId) {
        List l = jdbcTemplate.query("SELECT * FROM ServiceAreas WHERE Area_Id="+inputAreaId, new ServiceAreaRowMapper());
        Iterator it=l.iterator();
        Model.ServiceArea p=(Model.ServiceArea)it.next();
        return p;
    }
    @Override
    public List getAllServiceAreasByPackageID(int inputPackageId) {
        return jdbcTemplate.query("SELECT * FROM ServiceAreas WHERE Package_Id="+inputPackageId, new ServiceAreaRowMapper());
    }
    @Override
    public List getAllServiceAreaData() {
        return jdbcTemplate.query("SELECT * FROM ServiceAreas", new ServiceAreaRowMapper());
    }
}