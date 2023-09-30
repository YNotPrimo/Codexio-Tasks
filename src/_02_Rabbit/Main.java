package _02_Rabbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What should the size of the garden be?");
        int gridSize = Integer.parseInt(reader.readLine());
        boolean[][] grid = new boolean[gridSize][gridSize];

        fillGrid(grid);
        printGrid(grid);
        int groups = processGrid(grid);

        System.out.println(groups);
    }

    private static int processGrid(boolean[][] grid) {
        boolean[][] clone = cloneGrid(grid);
        int groups = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (clone[row][col]) {
                    clone[row][col] = false;
                    checkAdjacent(clone, row, col, RabbitEnum.NONE);
                    groups++;
                }
            }
        }
        return groups;
    }

    private static void fillGrid(boolean[][] grid) {
        Random random = new Random();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (random.nextInt(10) >= 6) { // 40%
                    grid[row][col] = true;
                }
            }
        }
    }

    private static void checkAdjacent(boolean[][] clone, int row, int col, RabbitEnum rabbitEnum) {
        if (col - 1 >= 0 && clone[row][col-1] && rabbitEnum != RabbitEnum.LEFT) { // left
            clone[row][col - 1] = false;
            checkAdjacent(clone, row, col - 1, RabbitEnum.RIGHT);
        }
        if (col + 1 <= clone.length - 1 && clone[row][col+1] && rabbitEnum != RabbitEnum.RIGHT) { // right
            clone[row][col + 1] = false;
            checkAdjacent(clone, row, col + 1, RabbitEnum.LEFT);
        }
        if (row - 1 >= 0 && clone[row-1][col] && rabbitEnum != RabbitEnum.UP) { // up
            clone[row - 1][col] = false;
            checkAdjacent(clone, row - 1, col, RabbitEnum.DOWN);
        }
        if (row + 1 <= clone.length - 1 && clone[row+1][col] && rabbitEnum != RabbitEnum.DOWN) { // down
            clone[row + 1][col] = false;
            checkAdjacent(clone, row + 1, col, RabbitEnum.UP);
        }
    }

    private static boolean[][] cloneGrid(boolean[][] grid) {
        boolean[][] clone = new boolean[grid.length][grid.length];
        for(int i = 0; i < grid.length; i++)
            clone[i] = grid[i].clone();
        return clone;
    }

    private static void printGrid(boolean[][] grid) {
        for (boolean[] row : grid) {
            for (boolean item : row) {
                System.out.print(item ? "C" : "_");
            }
            System.out.println();
        }
    }
}
