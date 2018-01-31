package Model;

public class ServiceArea {
    private int areaId;
    private String name;
    private int areaCode;
    private int packageId;
    private double taxRate;

    public ServiceArea() {
        this.areaId=0;
        this.name=null;
        this.areaCode=0;
        this.packageId=0;
        this.taxRate=0.0;
    }

    public ServiceArea(int areaId, String name, int areaCode, int packageId, double taxRate) {
        this.areaId = areaId;
        this.name = name;
        this.areaCode = areaCode;
        this.packageId = packageId;
        this.taxRate = taxRate;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
