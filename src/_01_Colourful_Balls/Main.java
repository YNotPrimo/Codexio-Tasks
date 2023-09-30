package _01_Colourful_Balls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IdentityHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> balls = new IdentityHashMap<>();
        String input = reader.readLine();

        while (!"End".equals(input)) {
            String[] currentColouredBallsCount = input.split(": ");
            String colour = currentColouredBallsCount[0];
            if (!balls.containsKey(colour)) {
                balls.put(colour, 0);
            }
            balls.put(colour, balls.get(colour) + Integer.parseInt(currentColouredBallsCount[1]));
            input = reader.readLine();
        }
        int amount = balls
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum() - 1;

        System.out.println("The smallest count of balls to remove: " + amount);
    }
}
