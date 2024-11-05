import java.time.LocalDate;


public class Rental {
    private int rentalID;
    private int customer ;                          //Kiralayan Müşteri (FK)
    private int user ;                              //Kiralayan Personel ise (FK)
    private int car;                                //Kiralanan Araç (FK)
    private java.time.LocalDate  rentalStartDate;        //Araç Kiralama Başlangıç Tarihi
    private java.time.LocalDate rentalEndDate;           //Araç Kiralama Bitiş Tarihi
    private Double totalPrice ;                     //Toplam Fiyat

    public Rental(int rentalID, int customer, int user, int car, LocalDate rentalStartDate, LocalDate rentalEndDate, double totalPrice) {
        this.rentalID = rentalID;
        this.customer = customer;
        this.user = user;
        this.car = car;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.totalPrice = totalPrice;
    }
    public int getRentalID() {
        return rentalID;
    }
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }
    public int getCustomer() {
        return customer;
    }
    public void setCustomer(int customer) {
        this.customer = customer;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public int getCar() {
        return car;
    }
    public void setCar(int car) {
        this.car = car;
    }
    public java.time.LocalDate getRentalStartDate() {
        return rentalStartDate;
    }
    public void setRentalStartDate(java.time.LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }
    public java.time.LocalDate getRentalEndDate() {
        return rentalEndDate;
    }
    public void setRentalEndDate(java.time.LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
