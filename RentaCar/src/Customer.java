import java.time.LocalDate;

public class Customer extends Person {


    //Müşteri Adı
    //Müşteri Soyadı
    //Müşteri Şifre
    //e-Posta
    //Telefon Numarası
    private boolean rentalStatus;                   //Kiralama Durumu (Aktif bir kiralamada mı? sorusu için)
    private String Address;                         //Müşteri Ev Adresi
    private LocalDate registrationDate;         //Kayıt Tarihi
    private int history;                            //Kiralama Geçmişi


    public Customer(int ID, String customerName, String customerSurname, String email, String password, String phoneNumber, boolean rentalStatus, String Address, LocalDate registrationDate, int history) {
        super(ID, customerName, customerSurname, email, password, phoneNumber);
        this.rentalStatus = rentalStatus;
        this.Address = Address;
        this.registrationDate = registrationDate;
        this.history = history;

    }

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

    public boolean getRentalStatus() {
        return rentalStatus;
    }
    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public LocalDate getRegistratioDate() {
        return registrationDate;
    }
    public void setRegistratioDate(LocalDate registratioDate) {
        this.registrationDate = registratioDate;
    }

    public int getHistory() {
        return history;
    }
    public void setHistory(int history) {
        this.history = history;
    }

}
