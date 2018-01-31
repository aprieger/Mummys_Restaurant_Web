package Service;

import java.util.List;
import Model.Package;

//Package DAO Abstract class that PackageDAOImpl implements
//Declares functions to be used by various controllers to communicated between the database
public interface PackageDAO {
    public void addPackage(Package pkg);
    public int getNextPackageId();
    public void editPackage(int editPackageId, String name, String description, String mealCategory, String imageSource, double price, String isSpecial, String mealType);
    public void editName(int editPackageId, String newName);
    public void editDescription(int editPackageId, String newDescription);
    public void editMealCategory(int editPackageId, String newMealCategory);
    public void editImageSource(int editPackageId, String newImageSource);
    public void editPrice(int editPackageId, double newPrice);
    public void editIsSpecial(int editPackageId, String newIsSpecial);
    public void editMealType(int editPackageId, String newMealType);
    public void deletePackage(int deletePackageId);
    public List getAllPackageData();
    public Package getSinglePackageData(int packageId);
}
