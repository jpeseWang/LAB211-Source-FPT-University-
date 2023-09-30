
package model;

public class Order {

    private int id;
    private String Name;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(int id, String Name, int quanlity, double price) {
        this.id = id;
        this.Name = Name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
