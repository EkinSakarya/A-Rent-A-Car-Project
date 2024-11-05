import java.time.LocalDate;
import java.util.ArrayList;

public class InvoiceManager {
    static Double taxvalue= 0.20;

    public void Add(int rentalid,int userid,int customerid,Double price,String isPayed) {


        if(isPayed=="Ödendi")
        {
            Main.invoices.add(new Invoice(Main.invoices.size()+1,rentalid,customerid,userid,price,price*taxvalue, LocalDate.now(),isPayed,LocalDate.now()));
        }
        else

        {Main.invoices.add(new Invoice(Main.invoices.size()+1,rentalid,customerid,userid,price,price*taxvalue, LocalDate.now(),isPayed,null));
        }

        System.out.println("İşleminiz tamamlandı");
    }

    public void Listing(Invoice invoice) {
        String customername="",username="";
        if(invoice.getCustomer()>=0)
        {
        for (Customer customer : Main.customers)
        {
                if (customer.getPersonID() == invoice.getCustomer()) {
                    customername=customer.getName();
                }
            }
        }
        if(invoice.getUser()>=0)
        {
            for(User user : Main.users)
            {
                if(user.getPersonID()==invoice.getUser())
                {
                    username=user.getName();
                }
            }
        }

        System.out.println(
                invoice.getInvoiceID() + " Kiralama numarası :" +
                invoice.getRental() + "-" +
                customername + "-" +
                username + "-" +
                invoice.getPrice() + "-" +
                invoice.getTaxAmount() + "-" +
                invoice.getIssueDate() + "-" +
                invoice.getInvoiceStatus() + "-" +
                invoice.getPaymentDate());
    }
    public static void Pay(ArrayList<Invoice> invoices, int payid)
    {
        for (Invoice invoice : invoices)
        {
            if(invoice.getInvoiceID()==payid)
            {
                invoice.setPaymentDate(LocalDate.now());
                invoice.setInvoiceStatus("Ödendi");
            }
        }
    }

}

