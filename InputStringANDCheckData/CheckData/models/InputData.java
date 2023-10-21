package CheckData.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InputData {
    private ArrayList<Integer> numbers;
    private ArrayList<Character> characters;

    public InputData(String inputString) {
        this.numbers = new ArrayList<>();
        this.characters = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isDigit(c)) {
                this.numbers.add(Integer.parseInt(Character.toString(c)));
            } else if (Character.isLetter(c)) {
                this.characters.add(c);
            }
        }
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<Integer> getPerfectSquareNumbers() {
        ArrayList<Integer> perfectSquareNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (Math.sqrt(number) * Math.sqrt(number) == number) {
                perfectSquareNumbers.add(number);
            }
        }

        return perfectSquareNumbers;
    }

    public ArrayList<Integer> getOddNumbers() {
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 1) {
                oddNumbers.add(number);
            }
        }

        return oddNumbers;
    }

    public ArrayList<Integer> getEvenNumbers() {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        return evenNumbers;
    }

    public ArrayList<Integer> getAllNumbers() {
        return numbers;
    }

    public String getUppercase() {
        String uppercase = "";

        for (char character : characters) {
            if (Character.isUpperCase(character)) {
                uppercase += character;
            }
        }

        return uppercase;
    }

    public String getLowercase() {
        String lowercase = "";

        for (char character : characters) {
            if (Character.isLowerCase(character)) {
                lowercase += character;
            }
        }

        return lowercase;
    }

    public String getSpecial() {
        String special = "";

        for (char character : characters) {
            if (!Character.isDigit(character) && !Character.isLetter(character)) {
                special += character;
            }
        }

        return special;
    }

    public String getAllCharacter() {
        String allCharacter = "";

        for (char character : characters) {
            allCharacter += character;
        }

        return allCharacter;
    }
}
