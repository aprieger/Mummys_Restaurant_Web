package Service;

import java.util.List;
import Model.ServiceArea;

//Service Area DAO Abstract class that ServiceAreaDAOImpl implements
//Declares functions to be used by various controllers to communicated between the database
public interface ServiceAreaDAO {
    public void addServiceArea(ServiceArea svc);
    public int getNextAreaId();
    public void editServiceArea(ServiceArea svcEdit);
    public void editName(int editServiceAreaId, String newName);
    public void editAreaCode(int editServiceAreaId, int newAreaCode);
    public void editPackageId(int editServiceAreaId, int packageId);
    public void editTaxRate(int editServiceAreaId, double newTaxRate);
    public void deleteServiceArea(int deleteServiceAreaId);
    public ServiceArea getSingleServiceAreaData(int inputAreaId);
    public List getAllServiceAreasByPackageID(int inputPackageId);
    public List getAllServiceAreaData();
}
