import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {

    public void Add(ArrayList<Car> cars) {
        Scanner scanner = new Scanner(System.in);

        String brand = getInput("Araç markasını giriniz: ", scanner);
        String model = getInput("Araç modelini giriniz: ", scanner);
        String productionYear = getInput("Üretim yılını giriniz(yyyy-mm-dd): ", scanner);
        double rentalPrice = Double.parseDouble(getInput("Günlük kiralama ücretini giriniz: ", scanner));
        int mileage = Integer.parseInt(getInput("Araç kilometresini giriniz: ", scanner)) ;
        String fuelType = getInput("Yakıt tipini giriniz: ", scanner);
        String transmissionType = getInput("Şanzıman türünü giriniz: ", scanner);
        String color = getInput("Araç rengini giriniz: ", scanner);
        String category = getInput("Araç kategorisini giriniz: ", scanner);
        String licensePlate = getInput("Plaka giriniz: ", scanner);

        try
        {
            cars.add(new Car(cars.size() + 1, brand, model, productionYear, rentalPrice, true, mileage, fuelType, transmissionType, color, category, licensePlate));
            System.out.println("İşlem başarıyla gerçekleşti");
        }
        catch(Exception e)
        {
            System.out.println("Bir hatayla karşılaşıldı, işlem başarısız.");
        }



    }

    public String getInput(String message, Scanner scanner) {
        System.out.println(message);
        String value= scanner.nextLine();
        return value;
    }

    public void carDel(ArrayList<Car> cars) {
        AvailabileCarList(cars);
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        int deleteId = -1;

        System.out.println("Silmek istediğiniz aracın numarasını giriniz.");
        while (deleteId == -1) {
            try {
                deleteId = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Hatalı bir giriş yaptınız. ");
            }
        }

        if (deleteId != -1) {

            boolean carValid = validator.iscarvalid(cars, deleteId);

            if (carValid) {

                int deletecarIndex = getCarIndex(deleteId, cars);

                System.out.println(cars.get(deletecarIndex).getLicensePlate() + " plakalı aracı  Silmek istediğinize emin misiniz?(E/H)");
                String Confirm = scanner.nextLine().toUpperCase();
                while (true) {
                    if (deletecarIndex != -1) {
                        if (Confirm.equals("E")) {
                            cars.get(deletecarIndex).setAvailable(false);
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
            else
            {
                System.out.println("Girdiğiniz arar müsait değil ya da mevcut değil.");
            }
        }
    }

    public int getCarIndex(int carId, ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarID() == carId) {
                return i;
            }
        }
        return -1;
    }

    public void listing(ArrayList<Car> cars) {

        for (Car car : cars) {
            System.out.print(car.getCarID() + "-" +
                    car.getBrand() + "-" +
                    car.getModel() + "-" +
                    car.getProductionYear() + "-" +
                    car.getRentalPrice() + "-" +
                    car.getMileage() + "-" +
                    car.getFuelType() + "-" +
                    car.getTransmissionType() + "-" +
                    car.getColor() + "-" +
                    car.getCategory() + "-" +
                    car.getLicensePlate());
            if (car.isAvailable()) {
                System.out.println(" (Bu araç kullanıma müsait değil)");
            } else {
                System.out.println();
            }
        }

        System.out.println("------------------------------");
    }

    public void AvailabileCarList(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car.getCarID() + "-" +
                        car.getBrand() + "-" +
                        car.getModel() + "-" +
                        car.getProductionYear() + "-" +
                        car.getRentalPrice() + "-" +
                        car.getMileage() + "-" +
                        car.getFuelType() + "-" +
                        car.getTransmissionType() + "-" +
                        car.getColor() + "-" +
                        car.getCategory() + "-" +
                        car.getLicensePlate());
            }
        }
        System.out.println("------------------------------");

    }

    public void carUpdate(ArrayList<Car> cars) {
        listing(cars);
        System.out.println("Güncellemek istediğiniz aracın numarasını giriniz.");
        Scanner scanner = new Scanner(System.in);

        int updateId = Integer.parseInt(scanner.nextLine());
        int updatecarIndex = getCarIndex(updateId, cars);

        Main.clearConsole();

        while (true) {
            if (updatecarIndex != -1) {
                System.out.println(cars.get(updatecarIndex).getBrand() + " plakalı aracı güncellemek istediğinize emin misiniz?(E/H)");
                String Confirm = scanner.nextLine().toUpperCase();


                if (Confirm.equals("E")) {
                    UpdateCarDetails(cars.get(updatecarIndex), scanner);
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

    public void UpdateCarDetails(Car car, Scanner scanner) {
        car.setBrand(getUpdatedValue("Yeni marka giriniz", car.getBrand(), scanner));
        car.setModel(getUpdatedValue("Yeni model giriniz", car.getModel(), scanner));
        car.setProductionYear(getUpdatedValue("Yeni üretim yılı giriniz(yyyy-mm-dd)", car.getProductionYear(), scanner));
        car.setRentalPrice(Double.parseDouble(getUpdatedValue("Yeni kiralama ücreti giriniz", String.valueOf(car.getRentalPrice()), scanner)));
        car.setMileage(Integer.parseInt(getUpdatedValue("Yeni kilometre giriniz", String.valueOf(car.getMileage()), scanner)));
        car.setFuelType(getUpdatedValue("Yeni yakıt tipi giriniz", car.getFuelType(), scanner));
        car.setTransmissionType(getUpdatedValue("Yeni şanzıman türü giriniz", car.getTransmissionType(), scanner));
        car.setColor(getUpdatedValue("Yeni renk giriniz", car.getColor(), scanner));
        car.setCategory(getUpdatedValue("Yeni kategori giriniz", car.getCategory(), scanner));
        car.setLicensePlate(getUpdatedValue("Yeni plaka giriniz", car.getLicensePlate(), scanner));
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
}



