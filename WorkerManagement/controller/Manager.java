package WorkerManagement.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import javax.swing.text.html.parser.Element;

import WorkerManagement.models.*;
import WorkerManagement.view.Menu;
import WorkerManagement.common.Library;
import WorkerManagement.common.Validate;

public class Manager extends Menu<String> {
    ArrayList<Worker> lw = new ArrayList<>();
    ArrayList<History> lh = new ArrayList<>();
    static String[] mc = { "Add worker", "Increase salary for worker", "Decrease for worker",
            "Show adjusted salary worker information", "Exit" };
    protected Library library;

    // show menu
    // public static int menu() {
    // System.out.println(" ");
    // System.out.println("======== Worker Management ========");
    // System.out.println("1. Add worker.");
    // System.out.println("2. Increase salary for worker.");
    // System.out.println("3. Decrease for worker");
    // System.out.println("4. Show adjusted salary worker information");
    // System.out.println("5. Exit");
    // System.out.print("Enter your choice: ");
    // int choice = Validate.checkInputIntLimit(1, 5);
    // return choice;
    // }

    public Manager() {
        super("======== Worker Management ========", mc);
        library = new Library();

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addWorker(lw);
                break;
            case 2:
                changeSalary(lw, lh, 1);
                break;
            case 3:
                changeSalary(lw, lh, 2);
                break;
            case 4:
                display();
            case 5:
                return;

        }
    }

    // allow user add worker
    public void addWorker(ArrayList<Worker> lw) {
        System.out.println(" ");
        System.out.println("-------------- Add Worker --------------");
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        if (!Validate.checkIdExist(lw, id)) {
            System.err.println("Code(id) must be existed in DB.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter age: ");
        int age = Validate.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = Validate.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = Validate.checkInputString();
        if (!Validate.checkWorkerExist(lw, id, name, age, salary, workLocation)) {
            System.err.println("Worker information already existed.");
        } else {
            lw.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success.");
        }
    }

    // allow user increase salary for user
    public void changeSalary(ArrayList<Worker> lw, ArrayList<History> lh, int status) {
        System.out.println(" ");
        if (lw.isEmpty()) {
            System.err.println("No worker in the list.");
            return;
        }
        System.out.println("--------- Up/Down Salary --------");

        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            // check user want to update salary
            if (status == 1) {
                System.out.print("Enter salary: ");
                // loop until user input salary update > salary current
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    // check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
                System.out.print("Enter salary: ");
                // loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    // check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }

    // allow user print history
    public void printListHistory(ArrayList<History> lh) {
        System.out.println(" ");
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        // print history from first to last list
        for (History history : lh) {
            printHistory(history);
        }
    }

    // get worker by code
    public Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    // get current date
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    // print history
    public void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }

}