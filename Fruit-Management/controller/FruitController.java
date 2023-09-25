
package controller;

import common.Library;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Order;
import view.Menu;

public class FruitController extends Menu {

    static String[] mc = { "Create Fruit", "View Orders", "Shopping (for buyer)", "Exit" };
    Library l;
    ArrayList<Fruit> list_F;
    Hashtable<String, ArrayList<Order>> ht;

    public FruitController() {
        super("FRUIT SHOP SYSTEM", mc);
        l = new Library();
        list_F = new ArrayList<>();
        ht = new Hashtable<>();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                createFruit();
                break;
            case 2:
                viewListOrder();
                break;
            case 3:
                shopping();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void viewListOrder() {
        if (ht.isEmpty()) {
            System.out.println("No Order");
            return;
        }
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> array_o = ht.get(name);
            displayListOrder(array_o);
        }
    }

    public void createFruit() {
        int id = generateID();
        String name = l.getString("Enter fruit name: ");
        double price = l.getDouble("Enter fruit price");
        int quantity = l.getInt("Enter fruit quantity", 1, 100);
        String origin = l.getString("Enter fruit origin: ");
        list_F.add(new Fruit(id, name, price, quantity, origin));
    }

    public void displayFruit() {
        for (Fruit f : list_F) {
            System.out.println("Id: " + f.getId() + " - Name: " + f.getName() + " - Price: " + f.getPrice()
                    + " - quantity:" + f.getQuantity() + " - origin: " + f.getOrigin());
        }
    }

    public void shopping() {
        /*
         * if (ht.isEmpty()) {
         * System.out.println("No Product");
         * return;
         * }
         */
        displayFruit();
        String name = l.getString("Enter fruit name: ");
        int quantityOrder = l.getInt("Please input quantity", 1, 10);
        ArrayList<Order> list_o = new ArrayList<>();
        for (Fruit f : list_F) {
            if (name.equals(f.getName())) {
                int id = f.getId();
                double price = f.getPrice();
                int quantity = f.getQuantity();
                if (quantityOrder > quantity) {
                    System.out.println("Quantity Order more than quantity");
                    shopping();
                }
                list_o.add(new Order(id, name, quantityOrder, price));
                displayListOrder(list_o);
                String customer = l.getString("Enter Customer of name: ");
                ht.put(customer, list_o);
                System.out.println("Add Successfull");
            }
        }
    }

    private void displayListOrder(ArrayList<Order> list_o) {
        double total = 0;
        for (Order o : list_o) {
            System.out.println("Id: " + o.getId() + " - Customer of name: " + o.getName() + " - quanlity: "
                    + o.getQuanlity() + " - price: " + o.getPrice());
            total += o.getPrice() * o.getQuanlity();
        }
        System.out.println("Total: " + total);
    }

    public int generateID() {
        int id = 0;
        if (list_F.size() == 0) {
            return 1;
        } else {

            for (Fruit s : list_F) {
                if (s.getId() == list_F.size()) {
                    id = s.getId() + 1;
                }
            }
        }
        return id;
    }
}
