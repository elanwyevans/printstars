import java.util.*;

public class Main {
    private static final Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        boolean checkForPositiveNumber = false;

        while (checkForPositiveNumber == false) {
            int bottomNumberOfRange = inputValidNumber("bottom");
            int topNumberOfRange = inputValidNumber("top");

            try {
                int[][] arrayOfIntegerArrays = iterateOverRange(bottomNumberOfRange, topNumberOfRange);
                printSymbol(arrayOfIntegerArrays);
                checkForPositiveNumber = true;
            } catch (NegativeArraySizeException e) {
                System.out.print("Bottom of range must be lower than top of range. Please re-enter numbers.\n");
                checkForPositiveNumber = false;
            }
        }
    }

    public static int inputValidNumber (String topOrBottom) {
        boolean validNumber = false;
        System.out.printf("Please enter %s of range:\n", topOrBottom);
        int enteredNumber = (stdin.nextInt());

        while (validNumber == false) {

            if (enteredNumber < 0 || enteredNumber >999){
                validNumber = false;
                System.out.printf("Number must be between 0 and 999. Please enter %s of range:\n", topOrBottom);
                enteredNumber = (stdin.nextInt());
            }
            else if (enteredNumber >= 0 && enteredNumber <= 999) {
                validNumber = true;
            }
        } return enteredNumber;
    }


    public static int[][] iterateOverRange(int bottomNumberOfRange, int topNumberOfRange) {

        int[][] arrayOfIntegerArrays = new int[(topNumberOfRange - bottomNumberOfRange) + 1][2];   //top - bottom = length (+1 so it includes all values in range)
        int count = 0;

        for (int i = bottomNumberOfRange; i <= topNumberOfRange; i++) {

            int[] integerArray = returnIntArray(i);
            arrayOfIntegerArrays[count] = integerArray;
            count = count + 1;
        }
        return arrayOfIntegerArrays;
    }

    public static void printSymbol (int[][] arrayOfIntegerArrays) {

        for(int lineNumber = 9; lineNumber >= 1; lineNumber--) {
            for (int[] integerArray : arrayOfIntegerArrays) {
                for (int number : integerArray) {
                    if (number >= lineNumber) {
                        System.out.print("*");
                    } else {
                        if (lineNumber == 1) {
                            System.out.print("_");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static int[] returnIntArray(int number) {
        String numberToString = String.valueOf(number);
        char[] arrayOfChars = numberToString.toCharArray();
        int[] arrayOfIntegers = new int[3];

        if (arrayOfChars.length == 1){
            arrayOfIntegers[0] = 0;
            arrayOfIntegers[1] = 0;
            arrayOfIntegers[2] = Character.digit(arrayOfChars[0], 10);
        }
        else if (arrayOfChars.length == 2){
            arrayOfIntegers[0] = 0;
            arrayOfIntegers[1] = Character.digit(arrayOfChars[0], 10);
            arrayOfIntegers[2] = Character.digit(arrayOfChars[1], 10);
        }
        else if (arrayOfChars.length == 3){
            arrayOfIntegers[0] = Character.digit(arrayOfChars[0], 10);
            arrayOfIntegers[1] = Character.digit(arrayOfChars[1], 10);
            arrayOfIntegers[2] = Character.digit(arrayOfChars[2], 10);
        }
        return arrayOfIntegers;
    }
}