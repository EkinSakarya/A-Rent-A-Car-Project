public class Car {

    private int carID;
    private String brand;                           //Araç Markası
    private String model;                           //Aracın Modeli
    private String productionYear;                  //Üretim Yılı
    private double rentalPrice;                     //Günlük Kiralama Ücreti
    private boolean isAvailable;                    //Kiralanabilirlik Durumu
    private int mileage;                            //Kilometre
    private String fuelType;                        //Yakıt Tipi
    private String transmissionType;                //Şanzıman Türü
    private String color;                           //Araç Rengi
    private String category;                        //Aracın Kategorisi (FK Relationship) (Suv, sedan, heçbek)
    private String licensePlate;                    //Plaka

    public Car(int carID, String brand, String model, String productionYear, double rentalPrice, boolean isAvailable,
               int mileage, String fuelType, String transmissionType, String color, String category, String licensePlate) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.color = color;
        this.category = category;
        this.licensePlate = licensePlate;
    }
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}

