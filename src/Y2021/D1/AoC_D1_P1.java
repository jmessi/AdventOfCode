package Y2021.D1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoC_D1_P1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Numbers.txt"));

        int increased = 0;
        int decreased = 0;
        int previous = 0;

        while(scanner.hasNextInt()){
            int current = scanner.nextInt();

            if (previous != 0){
                if (current > previous) {
                    increased++;
                } else if (current < previous){
                    decreased++;
                }
            }
            previous = current;
        }

        System.out.println("increased -> " + increased);
        System.out.println("decreased -> " + decreased);
    }
}
