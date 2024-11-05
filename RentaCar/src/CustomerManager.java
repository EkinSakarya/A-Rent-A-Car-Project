
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {

    public void listing(ArrayList<Customer> customers) {

        for (Customer customer : customers) {
            System.out.println(customer.getPersonID() + "-" +
                    customer.getName() + "-" +
                    customer.getSurname() + "-" +
                    customer.getEmail() + "-" +
                    customer.getAddress() + "-" +
                    customer.getRentalStatus() + "-" +
                    customer.getAddress() + "-" +
                    customer.getHistory());
        }
    }


    public void Add(ArrayList<Customer> customers, ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        String name = getCustomerValue("Müşteri ismi giriniz: ", scanner);
        String surname = getCustomerValue("Müşteri soyadı giriniz: ", scanner);
        String password = getCustomerValue("Müşteri Şifresi giriniz: ", scanner);
        String email = getCustomerValue("Müşteri epostası giriniz: ", scanner).toLowerCase();
        String telNumber = getCustomerValue("Müşteri Telefon numarası giriniz: ", scanner);
        String address = getCustomerValue("Müşteri Adresi giriniz: ", scanner);
        boolean isvalid = validator.isemailvalid(email);

        if (isvalid) {
            System.out.println("--------------------------------\nGirdiğiniz email ile zaten kayıt yapılmış.\n--------------------------------");
        } else {
            customers.add(new Customer(customers.size() + users.size() + 1, name, surname, email, password, telNumber, false, address, LocalDate.now(), 0));
            System.out.println("Müşteri başarıyla eklendi.");
        }
    }

    public String getCustomerValue(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextLine();
    }


    public void CustomerDel(ArrayList<Customer> customers) {
        listing(customers);
        System.out.println("Silmek istediğiniz müşterinin numarasını giriniz.");
        Scanner scanner = new Scanner(System.in);
        int deleteId = Integer.parseInt(scanner.nextLine());
        int deleteCustomerIndex = getCustomerIndex(deleteId, customers);

        System.out.println(customers.get(deleteCustomerIndex).getName() + " İsimli kullanıcıyı Silmek istediğinize emin misiniz?(E/H)");
        String Confirm = scanner.nextLine().toUpperCase();
        while (true) {
            if (deleteCustomerIndex != -1) {
                if (Confirm.equals("E")) {
                    customers.remove(deleteCustomerIndex);
                    System.out.println("İşlem başarıyla gerçekleşti");
                    break;
                } else if (Confirm.equals("H")) {
                    System.out.println("İşlem iptal edildi");
                    break;
                } else {
                    System.out.println("Seçiminizi 'E' ya da 'H' olarak belirtmelisiniz");
                }
            } else {
                System.out.println("Girdiğiniz id ye ait bir müşteri bulunmamaktadır.");
                break;
            }
        }

    }


    public void CustomerUpdate(ArrayList<Customer> customers) {
        listing(customers);
        System.out.println("Güncellemek istediğiniz müşterinin numarasını giriniz.");
        Scanner scanner = new Scanner(System.in);

        int updateId = Integer.parseInt(scanner.nextLine());
        int updateCustomerIndex = getCustomerIndex(updateId, customers);

        Main.clearConsole();

        while (true) {
            if (updateCustomerIndex != -1) {
                System.out.println(customers.get(updateCustomerIndex).getName() + " İsimli müşteriyi güncellemek istediğinize emin misiniz?(E/H)");
                String Confirm = scanner.nextLine().toUpperCase();


                if (Confirm.equals("E")) {
                    updateCustomerDetails(customers.get(updateCustomerIndex), scanner);
                    System.out.println("İşlem başarıyla gerçekleşti.");
                    break;
                } else if (Confirm.equals("H")) {
                    System.out.println("İşlem iptal edili.");
                    break;
                } else {
                    System.out.println("Seçiminizi 'E' ya da 'H' olarak belirtmelisiniz");
                }
            } else {
                System.out.println("Girdiğiniz id ye ait bir müşteri bulunmamaktadır.");
                break;
            }
        }

    }

    public void CustomerUpdateSelf(ArrayList<Customer> customers, int id, Scanner scanner) {
        int updateCustomerIndex = getCustomerIndex(id, customers);
        System.out.println("Bilgileriniz güncellemek ister misiniz (E/H)");
        String wannaUpdate = scanner.nextLine().toUpperCase();

        if (wannaUpdate.equals("E")) {
            updateCustomerDetails(customers.get(updateCustomerIndex), scanner);
            System.out.println("İşlem başarıyla gerçekleşti.");
        } else if (wannaUpdate.equals("H")) {
            System.out.println("İşlem iptal edili.");
        } else {
            System.out.println("Seçiminizi 'E' ya da 'H' olarak belirtmelisiniz");
        }
    }

    public int getCustomerIndex(int customerId, ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPersonID() == customerId) {
                return i;
            }
        }
        return -1;
    }

    public void updateCustomerDetails(Customer customer, Scanner scanner) {

        customer.setName(getUpdatedValue("Yeni isim giriniz", customer.getName(), scanner));
        customer.setSurname(getUpdatedValue("Yeni soyisim giriniz", customer.getSurname(), scanner));
        customer.setEmail(getUpdatedValue("Yeni email giriniz", customer.getEmail(), scanner));
        customer.setAddress(getUpdatedValue("Yeni adres giriniz", customer.getAddress(), scanner));
        customer.setPhoneNumber(getUpdatedValue("Yeni telefon numarası giriniz", customer.getPhoneNumber(), scanner));
        customer.setPassword(getUpdatedValue("Yeni şifre giriniz", customer.getPassword(), scanner));
    }

    public String getUpdatedValue(String message, String currentValue, Scanner scanner) {
        System.out.println("Değişim yapmak istemiyorsanız boş bırakın.\n");
        System.out.println(message + ": " + currentValue + " ---> :");
        String value = scanner.nextLine();
        if (value.isEmpty()) {
            return currentValue;
        } else {
            return value;
        }
    }

    public void listWithId(ArrayList<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getPersonID() == id) {
                System.out.println(customer.getPersonID() + "-" +
                        customer.getName() + "-" +
                        customer.getSurname() + "-" +
                        customer.getEmail() + "-" +
                        customer.getAddress() + "-" +
                        customer.getRentalStatus() + "-" +
                        customer.getAddress() + "-" +
                        customer.getHistory());
            }
        }
        System.out.print("------------------------------");
    }
}
