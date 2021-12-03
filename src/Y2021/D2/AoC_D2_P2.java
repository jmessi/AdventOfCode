package Y2021.D2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC_D2_P2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Y2021.D2/d2_input.txt"));

        List<String> moves = new ArrayList<>();

        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        final String FORWARD = "forward";
        final String UP = "up";
        final String DOWN = "down";

        while (scanner.hasNext()) {
            moves.add(scanner.nextLine());
        }

        for(String line: moves) {

            String[] test = line.split(" ");
            String direction = test[0];
            int value = Integer.parseInt(test[1]);

            switch (direction) {
                case FORWARD:
                    horizontalPosition += value;
                    depth += aim * value;
                    break;
                case UP:
                    aim -= value;
                    break;
                case DOWN:
                    aim += value;
                    break;
            }


        }
        System.out.println(horizontalPosition * depth);


    }
}
