
package view;

import common.Library;
import java.util.ArrayList;

public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> options;
    Library l = new Library();

    public Menu(String tt, String[] op) {
        title = tt;
        options = new ArrayList<>();
        for (String s : op)
            options.add((T) s);
    }

    public void display() {
        System.out.println(title);
        System.out.println("=======================================");
        for (int i = 0; i < options.size(); i++)
            System.out.println((i + 1) + ". " + options.get(i));
        System.out.println("=======================================");
    }

    public int getSelected() {
        display();
        return l.getInt("Enter your choice", 1, options.size() + 1);
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n >= options.size())
                break;
        }
    }
}
