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

        String gammaRate = "";
        String epsilonRate = "";

        for (int col = 0; col < binaryLength; col++) {

            int zeroBits = 0;
            int oneBits = 0;

            for (int row = 0; row < binaries.size(); row++) {

                if (binaries.get(row).charAt(col) == '0') {
                    zeroBits++;
                } else {
                    oneBits++;
                }
            }

            gammaRate += oneBits > zeroBits ? "1" : "0";
            epsilonRate += oneBits < zeroBits ? "1" : "0";
        }

        System.out.println(Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2));

    }
}
