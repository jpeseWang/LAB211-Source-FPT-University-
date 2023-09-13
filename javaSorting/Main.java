package javaSorting;
import Common.Library;
import Controller.SortProgramming;
import Model.Element;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Element element = new Element();

        element.setSize_array(library.getInt("Enter number of array", 1, 100));

        element.setArray(library.createArray(element.getSize_array()));
        new SortProgramming(element).run();
    }
}