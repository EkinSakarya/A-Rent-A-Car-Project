import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {

    public void Add() {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        String name = getUserValue("Kullanıcı ismi giriniz: ", scanner);
        String surname = getUserValue("Kullanıcı soyadı giriniz: ", scanner);
        String password = getUserValue("Kullanıcı şifresi giriniz: ", scanner);
        String email = getUserValue("Kullanıcı epostası giriniz: ", scanner).toLowerCase();
        String telNumber = getUserValue("Kullanıcı telefon numarası giriniz: ", scanner);

        boolean isvalid = validator.isemailvalid(email);

        if (isvalid) {
            System.out.println("Girdiğiniz email ile zaten kayıt yapılmış.");
        } else {
            Main.users.add(new User(Main.users.size() + Main.customers.size() + 1, name, surname, email, password, telNumber, true));
            System.out.print("Kullanıcı başarıyla eklendi.");
        }
    }

    public void userDel(ArrayList<User> users) {
        listing(users);
        System.out.println("Silmek istediğiniz müşterinin numarasını giriniz.");
        Scanner scanner = new Scanner(System.in);

        int deleteId = Integer.parseInt(scanner.nextLine());
        int deleteUserIndex = getUserIndex(deleteId, users);

        System.out.println(users.get(deleteUserIndex).getName() + " İsimli kullanıcıyı Silmek istediğinize emin misiniz?(E/H)");
        String Confirm = scanner.nextLine().toUpperCase();
        while (true) {
            if (deleteUserIndex != -1) {
                if (Confirm.equals("E")) {
                    users.remove(deleteUserIndex);
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

    public int getUserIndex(int userId, ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPersonID() == userId) {
                return i;
            }
        }
        return -1;
    }

    public String getUserValue(String Message, Scanner scanner) {
        System.out.println(Message);
        return scanner.nextLine();
    }

    public void userUpdate(ArrayList<User> users) {
        listing(users);
        System.out.println("Güncellemek istediğiniz müşterinin numarasını giriniz.");
        Scanner scanner = new Scanner(System.in);

        int updateId = Integer.parseInt(scanner.nextLine());
        int updateUserIndex = getUserIndex(updateId, users);

        Main.clearConsole();

        while (true) {
            if (updateUserIndex != -1) {
                System.out.println(users.get(updateUserIndex).getName() + " İsimli kullanıcıyı güncellemek istediğinize emin misiniz?(E/H)");
                String Confirm = scanner.nextLine().toUpperCase();


                if (Confirm.equals("E")) {
                    UpdateUserDetails(users.get(updateUserIndex), scanner);
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

    public void UpdateUserDetails(User user, Scanner scanner) {
        user.setName(getUpdatedValue("Yeni isim giriniz", user.getName(), scanner));
        user.setSurname(getUpdatedValue("Yeni soyisim giriniz", user.getSurname(), scanner));
        user.setEmail(getUpdatedValue("Yeni email giriniz", user.getEmail(), scanner));
        user.setPhoneNumber(getUpdatedValue("Yeni telefon numarası giriniz", user.getPhoneNumber(), scanner));
        user.setPassword(getUpdatedValue("Yeni şifre giriniz", user.getPassword(), scanner));
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

    public void listing(ArrayList<User> users) {

        for (User user : users) {
            System.out.println(user.getPersonID() + "-" +
                    user.getName() + "-" +
                    user.getSurname() + "-" +
                    user.getEmail() + "-" +
                    user.getPhoneNumber() + " Aktiflik durumu: " +
                    user.isActive());
        }
    }
}
