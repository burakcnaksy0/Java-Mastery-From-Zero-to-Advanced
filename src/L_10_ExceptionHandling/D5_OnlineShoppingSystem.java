package L_10_ExceptionHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class D5_OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();

        try {
            while (true) {
                System.out.println("\n1. Ürün Ekle");
                System.out.println("2. Sepeti Görüntüle");
                System.out.println("3. Ürün Satın Al");
                System.out.println("4. Çıkış");
                System.out.print("Seçiminizi yapınız: ");
                int choice;

                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(e.toString());
                    continue;
                }
                switch (choice) {
                    case 1: // Ürün Ekleme

                        try {
                            System.out.print("Ürün ID: ");
                            int id = Integer.parseInt(sc.nextLine());

                            System.out.print("Ürün Adı: ");
                            String name = sc.nextLine();

                            System.out.print("Ürün Fiyatı: ");
                            double price = Double.parseDouble(sc.nextLine());

                            System.out.print("Stok Durumu (true/false): ");
                            boolean isStock = Boolean.parseBoolean(sc.nextLine());

                            Product product = new Product(id, name, price, isStock);
                            shoppingCart.addProduct(product);
                            System.out.println("Ürün başarıyla eklendi.");
                        } catch (InvalidPriceException | OutOfStockException | NumberFormatException |
                                 InvalidIdException e) {
                            System.out.println("Hata: " + e.getMessage());
                        }
                        break;

                    case 2: // Sepeti Görüntüleme
                        try {
                            shoppingCart.viewCart();
                        } catch (ProductNotFoundException e) {
                            System.out.println("Hata: " + e.getMessage());
                        }
                        break;

                    case 3: // Ürün Satın Alma
                        try {
                            System.out.print("Satın almak istediğiniz ürün ID'sini giriniz: ");
                            int productId = Integer.parseInt(sc.nextLine());
                            shoppingCart.buyProduct(productId);
                            System.out.println("Ürün başarıyla satın alındı.");
                        } catch (ProductNotFoundException | NumberFormatException e) {
                            System.out.println("Hata: " + e.getMessage());
                        }
                        break;

                    case 4: // Çıkış
                        System.out.println("Çıkış yapılıyor...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Hata: Geçersiz seçim!");
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Transactions completed successfully.");
            sc.close();
        }

    }
}

class OutOfStockException extends Exception {   // Stokta olmayan ürün eklenmeye çalışıldığında fırlatılacak.
    OutOfStockException(String message) {
        super(message);
    }
}

class InvalidPriceException extends Exception {  // Negatif fiyatlı ürün eklenmeye çalışıldığında fırlatılacak.
    InvalidPriceException(String message) {
        super(message);
    }
}

class InvalidIdException extends Exception {  // Negatif İD li ürün eklenmeye çalışıldığında fırlatılacak.
    InvalidIdException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends Exception {  // Kullanıcı sepetinde olmayan bir ürünü satın almak istediğinde fırlatılacak.
    ProductNotFoundException(String message) {
        super(message);
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private boolean isStock;

    public Product(int id, String name, double price, boolean isStock) throws InvalidPriceException, InvalidIdException {
        setId(id);
        setName(name);
        setPrice(price);
        setStock(isStock);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidIdException {
        if (id <= 0) {
            throw new InvalidIdException("id value cannot be zero and less than zero.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if (price <= 0) {
            throw new InvalidPriceException("price value cannot be negative number");
        }
        this.price = price;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) throws IllegalArgumentException {
        if (stock != true && stock != false) {
            throw new IllegalArgumentException("Geçersiz stok durumu.");
        }
        isStock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isStock=" + isStock +
                '}';
    }
}

class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) throws InvalidPriceException, OutOfStockException {
        if (product.getPrice() < 0) {
            throw new InvalidPriceException("price value cannot be negative number");
        }
        if (!product.isStock()) {
            throw new OutOfStockException("The product is out of stock or you have entered the wrong expression. ");
        }
        products.add(product);
    }

    public void viewCart() throws ProductNotFoundException {
        if (products.isEmpty()) {
            throw new ProductNotFoundException("the cart is empty");
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void buyProduct(int productId) throws ProductNotFoundException {
        Product productToBuy = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                productToBuy = product;
                break;
            }
        }
        if (productToBuy == null) {
            throw new ProductNotFoundException("the product cannot found");
        }
        products.remove(productToBuy);

    }

}






















