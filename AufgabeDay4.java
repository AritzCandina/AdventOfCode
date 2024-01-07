import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AufgabeDay4 {




        public static void main(String[] args) {
            String puzzleFile = "out/Resources/inputDay4";

            try {
                List<String> lines = Files.readAllLines(Paths.get(puzzleFile));

                List<Integer> results = lines.stream()
                        .map(line -> {
                            String formattedLine = line.replaceFirst("^[^:]+: ", "");
                            String[] parts = formattedLine.split("\\|");

                            String left = parts[0].trim();
                            String right = parts[1].trim();

                            List<Integer> myNumbers = parseNumbers(left);
                            List<Integer> winningNumbers = parseNumbers(right);

                            return calculateTotalScore(myNumbers, winningNumbers);
                        })
                        .toList();

                int overallScore = results.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Gesamtscore: " + overallScore);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static List<Integer> parseNumbers(String input) {
            String[] numberStrings = input.split("\\s+");
            return List.of(numberStrings).stream()
                    .map(Integer::parseInt)
                    .toList();
        }

        private static int calculateTotalScore(List<Integer> myNumbers, List<Integer> winningNumbers) {
            int numberOfMatches = 0;

            for (int myNumber : myNumbers) {
                if (winningNumbers.contains(myNumber)) {
                    numberOfMatches++;
                }
            }

            numberOfMatches = (numberOfMatches > 1) ?
                    (int) Math.pow(2, numberOfMatches - 1) :
                    numberOfMatches;

            return numberOfMatches;
        }
    }

