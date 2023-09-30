package _03_The_Good_Elf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("First word: ");
        StringBuilder firstWord = new StringBuilder(reader.readLine());

        System.out.print("Second word: ");
        StringBuilder secondWord = new StringBuilder(reader.readLine());

        int unique = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            boolean found = false;
            for (int j = 0; j < secondWord.length(); j++) {
                if (secondWord.charAt(j) == firstWord.charAt(i)) {
                    secondWord.deleteCharAt(j);
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique++;
            }
        }
        unique += secondWord.length();
        System.out.println(unique);
    }
}
