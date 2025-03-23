package L_10_ExceptionHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class D6_OnlineTicketReservationSystem {
    public static void main(String[] args) {
        // Örnek Kullanım
        Scanner sc = new Scanner(System.in);
        ReservationSystem rs = new ReservationSystem();
        PaymentProcessor pp = new PaymentProcessor();

        while (true) {
            System.out.println("\n1. Event Add");
            System.out.println("2. Show Events");
            System.out.println("3. Exit");
            System.out.print("Seçiminizi yapınız: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("event id : ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.println("event name : ");
                        String name = sc.nextLine();

                        System.out.println("event capacity : ");
                        int capacity = Integer.parseInt(sc.nextLine());

                        System.out.println("event date : ");
                        String date = sc.nextLine();

                        // Event nesnesini oluştur
                        Event newEvent = new Event(id, name, capacity, date);

                        // Event'i ReservationSystem'e ekle
                        rs.addEvent(newEvent);
                    } catch (Exception e) {
                        System.out.println("error : " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        rs.showEvent();
                    } catch (Exception e) {
                        System.out.println("error  :" + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    sc.close();
                    return;
                default:
                    System.out.println("Hata: Geçersiz seçim!");
            }
        }
    }
}

class Event {
    private int id;
    private String name;
    private int capacity;
    private String date;

    public Event(int id, String name, int capacity, String date) throws InvalidCapacityException, InvalidEventIdException {
        setId(id);
        this.name = name;
        setCapacity(capacity);
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidEventIdException {
        if (id <= 0) {
            throw new InvalidEventIdException("id cannot be negative");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("the capacity cannot be negative");
        }
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", date='" + date + '\'' +
                '}';
    }
}

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class InvalidEventIdException extends Exception {
    public InvalidEventIdException(String message) {
        super(message);
    }
}

class TicketLimitExceededException extends Exception {
    public TicketLimitExceededException(String message) {
        super(message);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

class PaymentProcessingException extends Exception {
    public PaymentProcessingException(String message) {
        super(message);
    }
}

class EventFullException extends Exception {
    public EventFullException(String message) {
        super(message);
    }
}

class EmptyCartException extends Exception {
    public EmptyCartException(String message) {
        super(message);
    }
}

class InvalidPriceexception extends Exception {
    public InvalidPriceexception(String message) {
        super(message);
    }
}

class Ticket {
    private double price;
    private int eventId;
    private User user;

    public Ticket(double price, Event event, User user) throws InvalidPriceexception, InvalidEventIdException {
        setPrice(price);
        setEventId(event.getId());
        setUser(user);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceexception {
        if (price <= 0) {
            throw new InvalidPriceexception("Price cannot be negative or zero.");
        }
        this.price = price;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) throws InvalidEventIdException {
        if (eventId <= 0) {
            throw new InvalidEventIdException("Event ID cannot be negative or zero");
        }
        this.eventId = eventId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class User {
    private String name;
    private String email;
    private ArrayList<Ticket> tickets;

    public User(String name, String email) throws InvalidEmailException {
        setName(name);
        setEmail(email);
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("Email must contain @ symbol");
        }
        this.email = email;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}

class ReservationSystem {
    private ArrayList<Event> events;

    ReservationSystem() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void showEvent() {
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public Event findEventById(int id) throws InvalidEventIdException {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        throw new InvalidEventIdException("Event ID bulunamadı: " + id);
    }

    public void bookTicket(User user, Event event, double price, PaymentProcessor paymentProcessor) throws EventFullException, PaymentProcessingException, InvalidPriceException, InvalidEventIdException, InvalidPriceexception, InvalidCapacityException {
        if (event.getCapacity() <= 0) {
            throw new EventFullException("Etkinlik dolu: " + event.getName());
        }

        Ticket ticket = new Ticket(price, event, user);
        paymentProcessor.processPayment(user, price);
        user.getTickets().add(ticket);
        event.setCapacity(event.getCapacity() - 1);
    }
}

class PaymentProcessor {
    public void processPayment(User user, double amount) throws PaymentProcessingException {
        if (Math.random() < 0.2) { // %20 ihtimalle ödeme hatası
            throw new PaymentProcessingException("Ödeme başarısız. Lütfen tekrar deneyin.");
        }
        System.out.println("Ödeme başarıyla tamamlandı: " + amount + " TL");
    }
}