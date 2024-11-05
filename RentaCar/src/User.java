public class User extends Person {


    private boolean isActive ;                          //Aktiflik Durumu
                                                        //Kullanıcı Adı
                                                        //Kullanıcı Soyadı
                                                        //ePosta
                                                        //Şifre
                                                        //Telefon numarası
    static double discount=43.0;


    public User(int ID,String userName,String userSurname,String email,String password,String phoneNumber,boolean isActive) {

        super(ID, userName, userSurname, email,password,phoneNumber);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    }



