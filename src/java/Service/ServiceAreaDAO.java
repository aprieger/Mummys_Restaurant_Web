package Service;

import java.util.List;
import Model.ServiceArea;

public interface ServiceAreaDAO {
    public void addServiceArea(ServiceArea svc);
    public int getNextAreaId();
    public void editName(int editServiceAreaId, String newName);
    public void editAreaCode(int editServiceAreaId, int newAreaCode);
    public void editTaxRate(int editServiceAreaId, double newTaxRate);
    public void deleteServiceArea(int deleteServiceAreaId);
    public ServiceArea getSingleServiceAreaData(int inputAreaId);
    public List getAllServiceAreasByPackageID(int inputPackageId);
    public List getAllServiceAreaData();
}
