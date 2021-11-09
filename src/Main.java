/* Charles Lett Jr.
 * Grayson
 * August 20, 2021,
 * Test program to implement the compound interest formula
 */
import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // user options
        String PATH = "C:\\Users\\cclet\\Documents\\Projects\\Java\\compound_interest\\src\\testing.txt";
        String inputType = "file";
        // *** Keywords for 'inputType' ***
        //  > keyboard = user input
        //  > file = file input

        // run tasks if input type available
        if (inputType.equals("file") || inputType.equals("keyboard")) {
            // user input/var init
            double balance = 0, rate = 0, calc = 0;
            int comp = 0, time = 0;

            // keyboard input
            if (inputType.equals("keyboard")) {
                System.out.println("*** Using Keyboard Input (Type Stuph Dammit!) ***");

                Scanner inp = new Scanner(System.in); // init input

                System.out.println("Enter your balance.");
                balance = inp.nextDouble(); // init balance

                System.out.println("Next, enter the annual interest rate (percentage).");
                rate = inp.nextDouble() / 100; // interest rate

                System.out.println("Now, enter the number of compounds per year");
                comp = inp.nextInt(); // num of compounds

                System.out.println("Finally, enter the number of years to calculate new balance for");
                time = inp.nextInt(); // num of years

                calc = balance * Math.pow((1 + (rate / comp)), time * comp); // compound interest calc

            }

            // file input
            else if (inputType.equals("file")) {
                System.out.println("*** Using File Input ***");

                // file handler (***CHANGE PATH WHEN SUBMITTING***)
                File inputFile = new File(PATH);
                Scanner reader = new Scanner(inputFile);

                // file data to array list
                ArrayList<String> data = new ArrayList<>(); // creates arrayList to store data
                while (reader.hasNextLine()) {
                    String temp = reader.nextLine(); // stores selected data
                    data.add(temp); // writes data to arrayList
                }

                // crude conversion - this can definitely be handled in a cleaner manner
                // double
                balance = Double.parseDouble(data.get(0));
                rate = Double.parseDouble(data.get(1)) / 100;

                // int
                comp = Integer.parseInt(data.get(2));
                time = Integer.parseInt(data.get(3));

                System.out.println(">> Data From File:");
                System.out.println("\t- Balance: " + balance +
                        "\n\t- Rate: " + rate * 100 + "%" +
                        "\n\t- Compounds Per Year: " + comp +
                        "\n\t- Number of Years: " + time);

                calc = balance * Math.pow((1 + (rate / comp)), time * comp);
            }

            // output
            System.out.printf(">> Balance after " + time + " years is: %.2f", calc);
        }

        else{
            // if inputType not recognized, abort
            System.out.println(">> Input Type Not Recognized! Rerun the program with one of the provided keywords." +
                               "\n>> Exiting...");
            System.exit(0);
        }
    }
}

