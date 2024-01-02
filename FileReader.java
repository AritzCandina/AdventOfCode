import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class FileReader {

    private String file;

    public FileReader(String file){
        this.file = file;
    }

    public void getCalibration(String rout) {
        String line;
        int calibration = 0;
        try {

            File myObj = new File(rout);
            Scanner myReader = new Scanner(myObj);
            int i=0;

            while (myReader.hasNextLine()) {
                //System.out.println(i);
                i++;
                line = myReader.nextLine();
                System.out.println(this.getNumbers(line));
                calibration += this.getNumbers(line);
                //System.out.println(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(calibration);
    }

    public int getNumbers(String line){
        char numFirst ='a';

        String completeNumber ="";
        int finalSum;
        String line2 = "";
        int posChar = 0;

        // get the first Digit in the string */
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c >= '0' && c <= '9'){
                numFirst= c;
                //System.out.println("first for: " +numFirst);
                posChar = i;
                break;
            }
        }
/*
        // Create a new string without the first Digit
        for (int i = 0; i < line.length(); i++) {
            // Omit the Digit that has been already added
            if (i == posChar) {
                i++;
                continue;
            }

            char c = line.charAt(i);
            line2 += c;
        }

        //System.out.println(line2);

        // get the last Digit of the new string
        for (int i = line2.length() -1; i >= 0; i--){

            if (line2.charAt(i) >= '0' && line2.charAt(i) <= '9') {
                numLast= line2.charAt(i);

                break;
            }
        }
        */




        if (numFirst != 'a') {
            completeNumber += numFirst;
        }
        int numLast = Integer.parseInt(findLastNumber(line));

        completeNumber += numLast;

        finalSum = parseInt(completeNumber);
        return finalSum;
    }

    public static boolean isNumeric(String line) {
        return line.matches("-?\\d+(\\.\\d+)?");
    }
    public static String findLastNumber(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            String currentChar = String.valueOf(line.charAt(i));
            System.out.println(currentChar);
            if (isNumeric(String.valueOf(currentChar))) {
                return currentChar;


            }
        }
        return "";
    }

    public static void main(String[] args) {

        FileReader reader = new FileReader("C:\\Users\\Lukas\\IdeaProjects\\AdventOfCode_123\\input.txt");
        reader.getCalibration(reader.file);

    }

}
