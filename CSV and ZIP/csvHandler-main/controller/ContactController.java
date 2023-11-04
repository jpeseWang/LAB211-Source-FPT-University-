package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class ContactController {
    private List<Contact> csvData;

    public ContactController() {
        csvData = new ArrayList<>();
    }

    public void importCSV(String path) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4]);
                    csvData.add(contact);
                }
            }
            br.close();
            System.out.println("Import: Done");
        } catch (IOException e) {
            System.out.println("Error importing CSV: " + e.getMessage());
        }
    }

    public void formatAddress() {
        for (Contact contact : csvData) {
            String address = contact.getAddress();
            address = address.replaceAll("\\s+", " ");
            address = address.replaceAll(" - ", " - ");
            contact.setAddress(address);
        }
        System.out.println("Format Address: Done");
    }

    public void formatName() {
        for (Contact contact : csvData) {
            String name = contact.getName();
            String[] nameData = name.split(" ");
            StringBuilder formattedName = new StringBuilder();
            for (String part : nameData) {
                if (!part.isEmpty()) {
                    formattedName.append(part.substring(0, 1).toUpperCase()).append(part.substring(1)).append(" ");
                }
            }
            contact.setName(formattedName.toString().trim());
        }
        System.out.println("Format Name: Done");
    }

    public void exportCSV(String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Contact contact : csvData) {
                bw.write(String.format("%s, %s,%s,%s,%s%n", contact.getId(), contact.getName(), contact.getEmail(), contact.getPhone(), contact.getAddress()));
            }
            bw.close();
            System.out.println("Export: Done");
        } catch (IOException e) {
            System.out.println("Error exporting CSV: " + e.getMessage());
        }
    }
}
