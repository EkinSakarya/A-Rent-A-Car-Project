import java.util.ArrayList;

public class Validator {

    public boolean isemailvalid(String email) {
        for (Customer customer : Main.customers) {
            if (customer.getEmail().equals(email)) {
                return true;
            }
        }
        for (User user : Main.users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public boolean iscarvalid(ArrayList<Car> cars,int carId)
    {
        for (Car car : cars) {
            if(carId==car.getCarID() && car.isAvailable()==true)
            {
                return true;
            }
        }
        return false;
    }
    public boolean isCarvalid(int carid) {

        for (Car cars : Main.cars) {
            if(carid== cars.getCarID());
            return true;
        }

        return false;

    }
}
