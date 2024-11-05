import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    static ArrayList<Invoice> invoices = new ArrayList<>();

    static int currentUserID, permission = 0;

    public static void main(String[] args) {

        createCustomer();
        createUser();
        createCar();
        createRental();
        createinvoice();
        LogIn login = new LogIn();
        currentUserID = login.userLogIn(users, customers);
        program();
    }

    public static void program() {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        CustomerManager customerManager = new CustomerManager();
        RentalManager rentalManager = new RentalManager();
        InvoiceManager invoiceManager = new InvoiceManager();
        CarManager carManager = new CarManager();
        int option;


        while (true) {
            if (permission == 1) {
                System.out.println("Yapmak istediğiniz işlemi seçin:\n" +
                        "1: Müşteri işlemleri\n" +
                        "2: Kullanıcı işlemleri\n" +
                        "3: Araç işlemleri\n" +
                        "4: Ödeme yap\n"+
                        "5: Kesilen faturaları görmek istiyorum.\n" +
                        "6: Aktif kiralamaları görmek istiyorum.\n" +
                        "7: Çıkış yapmak istiyorum\n");

                System.out.println("Yapmak istediğiniz işlemi başındaki sayıyı girerek seçiniz.");

                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {

                    option = 0;
                }
                clearConsole();

                switch (option) {
                    case 1:
                        System.out.println("1: Müşteri ekle");
                        System.out.println("2: Müşteri sil");
                        System.out.println("3: Müşteri güncelle");
                        System.out.println("4: Müşterileri listele");
                        System.out.println("Geri dönmek için herhangi bir giriş yapınız.");
                        try {
                            option = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {

                            option = 0;
                        }
                        clearConsole();
                        switch (option) {
                            case 1:
                                customerManager.Add(customers, users);
                                break;
                            case 2:
                                customerManager.CustomerDel(customers);
                                break;
                            case 3:
                                customerManager.CustomerUpdate(customers);
                                break;
                            case 4:
                                customerManager.listing(customers);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1: Kullanıcı ekle");
                        System.out.println("2: Kullanıcı sil");
                        System.out.println("3: Kullanıcı güncelle");
                        System.out.println("4: Kullanıcı listele");
                        System.out.println("Geri dönmek için herhangi bir giriş yapınız.");

                        try {
                            option = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {

                            option = 0;
                        }

                        switch (option) {
                            case 1:
                                userManager.Add();
                                break;
                            case 2:
                                userManager.userDel(users);
                                break;
                            case 3:
                                userManager.userUpdate(users);
                                break;
                            case 4:
                                userManager.listing(users);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("1: Araç ekle");
                        System.out.println("2: Araç sil");
                        System.out.println("3: Araç güncelle");
                        System.out.println("4: Araç listele");
                        System.out.println("5: Araç kirala");
                        System.out.println("Geri dönmek için herhangi bir giriş yapınız.");

                        try {
                            option = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {

                            option = 0;
                        }

                        switch (option) {
                            case 1:
                                carManager.Add(cars);
                                break;
                            case 2:
                                carManager.carDel(cars);
                                break;
                            case 3:
                                carManager.carUpdate(cars);
                                break;
                            case 4:
                                carManager.listing(cars);
                                break;
                            case 5:
                                rentalManager.add(cars, rentals, currentUserID);
                                break;
                        }
                        break;
                    case 4:
                        rentalManager.Listing(rentals,invoices,customers,users);
                        System.out.println("Ödeme yapmak ister misiniz?(E/H)");
                        String payment =scanner.nextLine().toUpperCase();
                        if(payment.equals("E")){
                            System.out.println("Ödeme yapmak istediğiniz işlemin numarasını giriniz.");
                            int payid=Integer.parseInt(scanner.nextLine());
                            InvoiceManager.Pay(invoices,payid);
                        }

                        break;
                    case 5:
                        for (Invoice invoice : invoices) {
                            invoiceManager.Listing(invoice);
                        }
                        System.out.print("------------------------------");
                        break;
                    case 6:
                        rentalManager.ActiveRents(rentals, cars, customers, users);
                        break;
                    case 7:
                        LogIn login = new LogIn();
                        currentUserID = login.userLogIn(users, customers);
                        break;
                }
            } else {
                System.out.println("Yapmak istediğiniz işlemi seçin:\n" +
                        "1: Bilgilerimi görmek istiyorum.\n" +
                        "2: Araç kiralamak istiyorum.\n" +
                        "3: Daha önceki kiralamalarımı görmek istiyorum.\n" +
                        "4: Kesilen faturalarımı görmek istiyorum\n" +
                        "5: Çıkış yapmak istiyorum\n");

                System.out.println("Yapmak istediğiniz işlemi başındaki sayıyı girerek seçiniz.");

                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {

                    option = 0;
                }
                switch (option) {
                    case 1:
                        customerManager.listWithId(customers, currentUserID);
                        customerManager.CustomerUpdateSelf(customers, currentUserID, scanner);
                        break;
                    case 2: {
                        rentalManager.add(cars, rentals, currentUserID);
                    }
                    break;
                    case 3:
                        rentalManager.listWithId(currentUserID, rentals, cars, customers);
                        break;
                    case 4:
                        for (Invoice invoice : invoices) {
                            if (invoice.getCustomer() == currentUserID) {
                                invoiceManager.Listing(invoice);
                            }
                        }

                        break;
                    case 5:
                        LogIn login = new LogIn();
                        currentUserID = login.userLogIn(users, customers);
                        break;
                }
            }
            scanner.nextLine();
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void createCustomer() {


        customers.add(new Customer(1,
                "Ekin",
                "Sakarya",
                "ekinemirSakarya@gmail.com",
                "12345",
                "5301252484",
                false,
                "barış mahallesi nigar sokak türközü apartmanı kat 5 daire 21",
                LocalDate.now(),
                0));

        customers.add(new Customer(2,
                "Ahmet",
                "Yılmaz",
                "ahmetyilmaz@gmail.com",
                "67890",
                "5321456789",
                true,
                "Atatürk Mahallesi, Cumhuriyet Caddesi, No:10, Kat:3, Daire:15",
                LocalDate.now(),
                5));

        customers.add(new Customer(3,
                "Merve",
                "Kaya",
                "mervekaya@hotmail.com",
                "abcdef",
                "5339876543",
                false,
                "Yenimahalle, Güneş Sokak, Güneş Apartmanı, Kat:2, Daire:4",
                LocalDate.now(),
                2));
    }

    public static void createUser() {
        users.add(new User(1,
                "Furkan",
                "Oral",
                "furkanoral@gmail.com",
                "12345",
                "5392532341",
                true));
        users.add(new User(2,
                "ilke",
                "yüzgeç",
                "ilkesakarya@gmail.com",
                "12345",
                "5392532341",
                true));
        users.add(new User(3,
                "tuğçe",
                "kutlu",
                "tugcekutlu@gmail.com",
                "12345",
                "5392532341",
                true));
    }

    public static void createCar() {
        cars.add(new Car(1,
                "Toyota",
                "Corolla",
                "2021",
                500.0,
                true,
                15000,
                "Benzin",
                "Otomatik",
                "Beyaz",
                "Sedan",
                "34ABC123"));

        cars.add(new Car(2,
                "Honda",
                "Civic",
                "2020",
                550.0,
                true,
                12000,
                "Dizel",
                "Manuel",
                "Siyah",
                "Sedan",
                "06DEF456"));
        cars.add(new Car(3,
                "BMW",
                "X5",
                "2019",
                1000.0,
                false,
                40000,
                "Benzin",
                "Otomatik",
                "Gri",
                "SUV",
                "35GHI789"));
    }

    public static void createinvoice() {
        invoices.add(new Invoice(
                1,
                1,
                1,
                -1,
                500.0,
                100.0,
                LocalDate.now(),
                "Ödendi",
                LocalDate.now().plusDays(7)
        ));

        invoices.add(new Invoice(
                2,
                2,
                2,
                -1,
                800.0,
                160.0,
                LocalDate.of(2024, 10, 16),
                "Ödendi",
                LocalDate.of(2024, 10, 7)
        ));
        invoices.add(new Invoice(
                3,
                3,
                -1,
                2,
                800.0,
                160.0,
                LocalDate.of(2024, 10, 7),
                "Ödendi",
                LocalDate.of(2024, 10, 7)
        ));
    }

    public static void createRental() {
        rentals.add(new Rental(
                1,
                1,
                -1,
                2,
                LocalDate.of(2024, 10, 1),
                LocalDate.of(2024, 10, 7),
                500.0
        ));
    }
}
