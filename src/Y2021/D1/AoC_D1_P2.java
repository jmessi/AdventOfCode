package Y2021.D1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC_D1_P2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Numbers.txt"));

        ArrayList<Integer> numbers = new ArrayList<>();

        while(scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        int increased = 0;

        for (int i = 3; i < numbers.size(); i++) {
            increased += numbers.get(i) > numbers.get(i - 3) ? 1 : 0;
        }

        System.out.println("increased -> " + increased);

    }
}


