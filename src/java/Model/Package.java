package Model;

public class Package { 
    private int packageId;
    private String name;
    private String description; 
    private String mealCategory;
    private String imageSource;
    private double price;
    private String isSpecial;
    private String mealType;

    public Package() {
    }

    public Package(int packageId, String name, String description, String mealCategory, String imageSource, double price, String isSpecial, String mealType) {
        this.packageId = packageId;
        this.name = name;
        this.description = description;
        this.mealCategory = mealCategory;
        this.imageSource = imageSource;
        this.price = price;
        this.isSpecial = isSpecial;
        this.mealType = mealType;
    }
    
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
