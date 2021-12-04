package Y2021.D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC_D3_P1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Y2021.D3/d3_input.txt"));

        List<String> binaries = new ArrayList<>();

        while (scanner.hasNext()) {
            binaries.add(scanner.next());
        }

        int binaryLength = binaries.get(0).length();

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (int col = 0; col < binaryLength; col++) {

            int zeroBits = 0;
            int oneBits = 0;

            for (String binary : binaries) {

                if (binary.charAt(col) == '0') {
                    zeroBits++;
                } else {
                    oneBits++;
                }
            }

            gammaRate.append(oneBits > zeroBits ? "1" : "0");
            epsilonRate.append(oneBits < zeroBits ? "1" : "0");
        }

        System.out.println(Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(epsilonRate.toString(), 2));

    }
}
