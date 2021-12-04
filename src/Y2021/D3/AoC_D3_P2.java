package Y2021.D3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC_D3_P2 {
    public static void main(String[] args) throws FileNotFoundException {

        //keywords
        final String OXYGEN = "oxygen";
        final String CO2 = "co2";

        //input
        //Scanner scanner = new Scanner(new File("src/Y2021/D3/dummy_input.txt"));
        Scanner scanner = new Scanner(new File("src/Y2021/D3/d3_input.txt"));

        List<String> binaries = new ArrayList<>();

        //populate ArrayList
        while (scanner.hasNext()) {
            binaries.add(scanner.next());
        }

        int binaryLength = binaries.get(0).length();

        //clone ArrayList for Oxygen and CO2 calculations
        List<String> binariesForOxygen = new ArrayList<>(binaries);
        List<String> binariesForCO2 = new ArrayList<>(binaries);

        //call method
        String oxygenGeneratorRating = findBinary(binaryLength, binariesForOxygen, OXYGEN);
        String co2ScrubberRating = findBinary(binaryLength, binariesForCO2, CO2);

        System.out.println("Oxygen Generator Rating -> " + oxygenGeneratorRating);
        System.out.println("CO2 Scrubber Rating -> " + co2ScrubberRating);

        //convert binary to decimal
        int result = Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2);

        System.out.println("life support rating -> " + result);

    }

    //method to find binary needed for each rating
    public static String findBinary(int binaryLength, List<String> binaries, String type) {

        for (int col = 0; col < binaryLength; col++) {

            if (binaries.size() == 1) {
                break;
            }

            int oneBits = 0;
            int zeroBits = 0;
            List<String> tempArrayForOnes = new ArrayList<>();
            List<String> tempArrayForZeros = new ArrayList<>();

            for (String binary : binaries) {

                if (binary.charAt(col) == '1') {
                    oneBits++;
                    tempArrayForOnes.add(binary);
                } else {
                    zeroBits++;
                    tempArrayForZeros.add(binary);
                }
            }

            switch (type) {
                case "oxygen":
                    if (oneBits >= zeroBits) {
                        for (String zeros : tempArrayForZeros) {
                            binaries.remove(zeros);
                        }
                    } else {
                        for (String ones : tempArrayForOnes) {
                            binaries.remove(ones);
                        }
                    }
                    break;

                case "co2":
                    if (zeroBits <= oneBits) {
                        for (String ones : tempArrayForOnes) {
                            binaries.remove(ones);
                        }
                    } else {
                        for (String zeros : tempArrayForZeros) {
                            binaries.remove(zeros);
                        }
                    }
                    break;
            }
        }

        return binaries.get(0);

    }

}
