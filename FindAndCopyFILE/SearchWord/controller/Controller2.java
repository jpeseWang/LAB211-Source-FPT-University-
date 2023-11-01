package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import view.Menu;
import common.Library;

public class Controller2 extends Menu<String> {
    private final Scanner in = new Scanner(System.in);
    static String[] mc = { "Count Word In File", "Find File By Word", "Exit" };
    protected Library library;

    public Controller2() {
        super(" == FIND AND SEARCH FILE ==", mc);
        library = new Library();
    }

    @Override
    public void execute(int n) {
        System.out.println(" ");
        switch (n) {
            case 1:
                countWord();
                break;
            case 2:
                findFile();
                break;
            case 3:
                return;

        }
    }

    private int countWordInFile(String fileSource, String word) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    private void getFileNameContainsWordInDirectory(String source, String word) {
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }

    public void countWord() {
        String path;
        String word;
        System.out.print("Enter Path: ");
        path = in.nextLine();
        System.out.print("Enter Word: ");
        word = in.nextLine();
        int count = countWordInFile(path, word);
        System.out.println("Count: " + count);
    }

    public void findFile() {
        String path;
        String word;
        System.out.print("Enter Path: ");
        path = in.nextLine();
        System.out.print("Enter Word: ");
        word = in.nextLine();
        getFileNameContainsWordInDirectory(path, word);
    }

}
