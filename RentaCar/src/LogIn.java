import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LogIn {
    public int userLogIn(ArrayList<User> users, ArrayList<Customer> customers) {

        Scanner scanner = new Scanner(System.in);

        String tempEmail, tempPassword;

        System.out.println("Hoşgeldiniz.\n Giriş yapmak için email giriniz: ");
        tempEmail = scanner.nextLine();
        System.out.println("Şifre giriniz: ");
        tempPassword = scanner.nextLine();

        for (User user : users) {
            if (Objects.equals(user.getEmail().toLowerCase(), tempEmail.toLowerCase()) && Objects.equals(user.getPassword().toLowerCase(), tempPassword.toLowerCase())) {
                System.out.println("Hoşgeldiniz " + user.getName() + ".");
                Main.permission =1;
                return user.getPersonID();
            }
        }
        for (Customer customer : customers) {
            if (Objects.equals(customer.getEmail().toLowerCase(), tempEmail.toLowerCase()) && Objects.equals(customer.getPassword().toLowerCase(), tempPassword.toLowerCase())) {
                System.out.println("Hoşgeldiniz " + customer.getName() + ".");
                Main.permission =0;
                return customer.getPersonID();
            }
        }
        scanner.close();
        return -1;
    }
}
