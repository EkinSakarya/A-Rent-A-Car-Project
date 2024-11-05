import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManager {
    public void add(ArrayList<Car> cars, ArrayList<Rental> rentals, int currentUserID) {
        CarManager carManager = new CarManager();
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        RentalManager rentalManager = new RentalManager();
        InvoiceManager invoiceManager = new InvoiceManager();


        int howManyDays, carId;
        System.out.println("Kullanıma müsait olan hangi aracı kiralamak istiyorsunuz?");
        carManager.AvailabileCarList(cars);
        carId = Integer.parseInt(scanner.nextLine());

        System.out.println("Kaç günlüğüne kiralamak istiyorsunuz?");
        howManyDays = Integer.parseInt(scanner.nextLine());
        boolean carValid = validator.isCarvalid(carId);

        if (carValid) {
            rentalManager.addRental(rentals, cars, carId, howManyDays, currentUserID);
            int lastRentalId = rentals.getLast().getRentalID();
            Double lastRentalPrice = rentals.getLast().getTotalPrice();
            System.out.println(" vergiler dahil toplam ücretiniz :" + lastRentalPrice + "Ödeme yapmak ister misiniz?(E/H)");
            String isPayed = scanner.nextLine().toUpperCase();

            if (isPayed.equals("E")) {

                invoiceManager.Add(lastRentalId, currentUserID, -1, lastRentalPrice, "Ödendi");
            } else {
                invoiceManager.Add(lastRentalId, currentUserID, -1, lastRentalPrice, "Ödenmedi");
            }
        } else {
            System.out.println("Seçtiğiniz araç bulunamamaktadır.");
        }
    }

    public void addRental(ArrayList<Rental> rentals, ArrayList<Car> cars, int carId, int days, int rentedperson) {

        Car selectedcar;
        double totalprice = 0;
        for (Car carSelection : cars) {
            if (carSelection.getCarID() == carId) {
                carSelection.setAvailable(false);
                selectedcar = carSelection;
                totalprice = carSelection.getRentalPrice() * days;
            }
        }
        if (Main.permission == 1) {
            totalprice = totalprice * (User.discount / 100);
            rentals.add(new Rental(rentals.size() + 1,
                    -1,
                    carId,
                    rentedperson,
                    LocalDate.now(),
                    LocalDate.now().plusDays(days),
                    totalprice));

        } else if (Main.permission == 0) {
            rentals.add(new Rental(rentals.size() + 1,
                    rentedperson,
                    -1,
                    carId,
                    LocalDate.now(),
                    LocalDate.now().plusDays(days),
                    totalprice));
        }
    }

    public void ActiveRents(ArrayList<Rental> rentals, ArrayList<Car> cars, ArrayList<Customer> customers, ArrayList<User> users) {
        for (Rental rental : rentals) {
            if ((rental.getRentalStartDate().isBefore(LocalDate.now()) || rental.getRentalStartDate().isEqual(LocalDate.now())) &&
                    (rental.getRentalEndDate().isAfter(LocalDate.now()) || rental.getRentalEndDate().isEqual(LocalDate.now()))) {

                if (rental.getCustomer() != -1) {
                    System.out.print(GetCustomerName(customers, rental.getCustomer()) + "-");
                }
                if (rental.getUser() != -1) {

                    System.out.print(GetUserName(users, rental.getUser()) + "-");

                }
                System.out.print(GetCarLicansePlate(cars, rental.getCar()));
                System.out.println(rental.getRentalStartDate() + "-" + rental.getRentalEndDate() + "-" + rental.getTotalPrice());
            }
        }
    }

    private String GetCarLicansePlate(ArrayList<Car> cars, int id) {
        for (Car car : cars) {
            if (car.getCarID() == id)
                return car.getLicensePlate();
        }
        return "Bulunamadı";
    }

    private String GetCustomerName(ArrayList<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getPersonID() == id)
                return customer.getName();
        }
        return "Bulunamadı";
    }

    private String GetUserName(ArrayList<User> users, int id) {
        for (User user : users) {
            if (user.getPersonID() == id)
                return user.getName();
        }
        return "Bulunamadı";
    }

    public void listWithId(int id, ArrayList<Rental> rentals, ArrayList<Car> cars, ArrayList<Customer> customers) {
        for (Rental rental : rentals) {
            if (rental.getCustomer() == id) {
                System.out.print(GetCustomerName(customers, id) + "-");
                System.out.print(GetCarLicansePlate(cars, rental.getCar()) + "- Başlangıç:");
                System.out.println(rental.getRentalStartDate() + "- Bitiş:" + rental.getRentalEndDate() + "- Fiyat:" + rental.getTotalPrice());
            }
        }
    }

    public void Listing(ArrayList<Rental> rentals, ArrayList<Invoice> invoices, ArrayList<Customer> customers, ArrayList<User> users) {
        for (Rental rental : rentals) {
            if (invoices.get(rental.getRentalID()).getInvoiceStatus().equals("Ödenmedi")) {

                System.out.println("Kiralama numarası :" + rental.getRentalID() + "- Kiralayan adı :");
                if (rental.getCustomer() != -1) {
                    System.out.print(GetCustomerName(customers, rental.getCustomer()) + "- Kiralayan adı :");
                } else {
                    System.out.print(GetUserName(users, rental.getUser()) + "-");
                }
                System.out.println("- Kiralama başlangıç tarihi :" + rental.getRentalStartDate() +
                        "- Kiralama bitiş tarihi :" + rental.getRentalEndDate() +
                        "- Fiyat:" + rental.getTotalPrice() * InvoiceManager.taxvalue
                );
            }
        }

    }

}

