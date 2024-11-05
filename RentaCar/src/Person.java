public class Person {

    private int personID;
    private String name;
    private String surname;
    private String password;
    private String Email;
    private String phoneNumber;

    public Person(int ID, String name, String surname, String email, String password, String phoneNumber) {
        this.personID = ID;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.Email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
