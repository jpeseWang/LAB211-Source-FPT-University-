package counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Counter {

    private Map<Character, Integer> charCounter = new HashMap<Character, Integer>();

    private Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();

        Counter counter = new Counter();
        counter.analyze(content);
        counter.display();
    }

    public void display() {
        System.out.println("Word Counts: " + wordCounter);
        System.out.println("Character Counts: " + charCounter);
    }

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch))
                continue;
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }
}