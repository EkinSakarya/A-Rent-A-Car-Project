import java.time.LocalDate;

public class Invoice {
    private int invoiceID;
    private int rental;                      //Kiralama İşlemi (FK)
    private int customer;                    //Müşteri (FK)
    private int user;                        //Personel (FK)
    private Double price;                       //Toplam Tutar
    private Double taxAmount;                   //Vergi Miktarı
    private java.time.LocalDate issueDate;           //Oluşturma Tarihi
    private String invoiceStatus;               //Fatura Durumu
    private java.time.LocalDate paymentDate;         //Ödeme Tarihi

    public Invoice(int invoiceID, int rental, int customer, int user, double price, double taxAmount, LocalDate issueDate, String invoiceStatus, LocalDate paymentDate) {
        this.invoiceID = invoiceID;
        this.rental = rental;
        this.customer = customer;
        this.user = user;
        this.price = price;
        this.taxAmount = taxAmount;
        this.issueDate = issueDate;
        this.invoiceStatus = invoiceStatus;
        this.paymentDate = paymentDate;
    }
    public int getInvoiceID() {
        return invoiceID;
    }
    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    public int getRental() {
        return rental;
    }
    public void setRental(int rental) {
        this.rental = rental;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getTaxAmount() {
        return taxAmount;
    }
    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }
    public java.time.LocalDate getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(java.time.LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    public String getInvoiceStatus() {
        return invoiceStatus;
    }
    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
    public java.time.LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(java.time.LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }


}

