package L8_GenericClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class D3_Insurance_Management_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan e-posta ve şifre bilgilerini alıyoruz.
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // AccountManager üzerinden giriş yapılmaya çalışılıyor.
        AccountManager accountManager = new AccountManager();
        try {
            Account account = accountManager.login(email, password);
            System.out.println("Login successful: " + account.getUser().getEmail());
        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Account sınıfı: Soyut sınıf ve Comparable interface'ini implement eder.
abstract class Account implements Comparable<Account> {
    private User user;
    private AuthenticationStatus authenticationStatus;
    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.user = user;
        this.authenticationStatus = AuthenticationStatus.FAIL;
        this.insurances = new ArrayList<>();
    }

    public abstract void addInsurance(Insurance insurance);

    public abstract void showUserInfo();

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Invalid credentials");
        }
    }

    public User getUser() {
        return user;
    }

    public void addAddress(Address address) {
        AddressManager.addAddress(user, address);
    }

    public void removeAddress(Address address) {
        AddressManager.removeAddress(user, address);
    }

    @Override
    public int compareTo(Account other) {
        return this.user.getEmail().compareTo(other.user.getEmail());
    }
}

// User sınıfı: Müşteri bilgilerini tutar ve adresler ekler.
class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String occupation;
    private int age;
    private ArrayList<Address> addresses;
    private Date lastLoginDate;

    public User(String firstName, String lastName, String email, String password, String occupation, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.occupation = occupation;
        this.age = age;
        this.addresses = new ArrayList<>();
        this.lastLoginDate = new Date();
    }

    // Getter ve setter metodları
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }
}

// Address interface'i
interface Address {
    String getFullAddress();
}

// HomeAddress sınıfı: Ev adresini tutar.
class HomeAddress implements Address {
    private String street;
    private String city;
    private String postalCode;

    public HomeAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFullAddress() {
        return street + ", " + city + ", " + postalCode;
    }
}

// BusinessAddress sınıfı: İş adresini tutar.
class BusinessAddress implements Address {
    private String street;
    private String city;
    private String postalCode;

    public BusinessAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFullAddress() {
        return street + ", " + city + ", " + postalCode;
    }
}

// AddressManager sınıfı: Adresleri ekler ve siler.
class AddressManager {
    public static void addAddress(User user, Address address) {
        user.getAddresses().add(address);
    }

    public static void removeAddress(User user, Address address) {
        user.getAddresses().remove(address);
    }
}

// Insurance soyut sınıfı: Sigorta türlerini temsil eder.
abstract class Insurance {
    protected String name;
    protected double price;
    protected Date startDate;
    protected Date endDate;

    public Insurance(String name, double price, Date startDate, Date endDate) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double calculate();
}

// HealthInsurance sınıfı: Sağlık sigortası türü.
class HealthInsurance extends Insurance {
    public HealthInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public double calculate() {
        return price * 1.2;  // Örneğin bir hesaplama
    }
}

// ResidenceInsurance sınıfı: Konut sigortası türü.
class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public double calculate() {
        return price * 1.5;  // Farklı bir hesaplama
    }
}

// AuthenticationStatus enum: Giriş durumlarını tutar.
enum AuthenticationStatus {
    SUCCESS, FAIL
}

// InvalidAuthenticationException sınıfı: Hatalı girişlerde fırlatılır.
class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}

// Individual sınıfı: Bireysel kullanıcı hesaplarını temsil eder.
class Individual extends Account {
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        // Bireysel müşterilerin sigorta ekleme mantığı
    }

    @Override
    public void showUserInfo() {
        System.out.println("Individual User Info: " + getUser().getEmail());
    }
}

// Enterprise sınıfı: Kurumsal kullanıcı hesaplarını temsil eder.
class Enterprise extends Account {
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        // Kurumsal müşterilerin sigorta ekleme mantığı
    }

    @Override
    public void showUserInfo() {
        System.out.println("Enterprise User Info: " + getUser().getEmail());
    }
}

// AccountManager sınıfı: Hesap yönetimi ve giriş işlemleri.
class AccountManager {
    private TreeSet<Account> accounts = new TreeSet<>();

    public Account login(String email, String password) throws InvalidAuthenticationException {
        for (Account account : accounts) {
            try {
                account.login(email, password);
                return account;
            } catch (InvalidAuthenticationException e) {
                continue;  // Giriş başarısızsa devam et
            }
        }
        throw new InvalidAuthenticationException("Account not found.");
    }
}
