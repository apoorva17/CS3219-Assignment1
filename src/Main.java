import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int designChoice;
        List<String> inputLines = new ArrayList<String>();
        List<String> ignoreWords = new ArrayList<String>();

        designChoice = readInput(inputLines, ignoreWords);

        if (designChoice == 1) { 
            ADT.Characters characters = new ADT.LineCharacters(inputLines, ignoreWords);
            ADT.CircularShift shifter = new ADT.CircularShifter(characters.getTitles(), characters.getIgnoreWords());
            ADT.AlphabeticShift alphabetizer = new ADT.AlphabeticShifter(shifter.getShiftedTitles());
            alphabetizer.printSortedTitles();
        } else if(designChoice == 2){
            //todo
        } else {
            System.out.println("Please enter only 1 or 2.");
        }

    }

    private static int readInput(List<String> inputLines, List<String> ignoreWords) {
        int designChoice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to KWIC!");
        System.out.println("Enter lines: ");
        while (sc.hasNextLine()) {
            String newLine = sc.nextLine();
            if (newLine.isEmpty()) {
                break;
            }
            inputLines.add(newLine);

        }
        System.out.println("Enter words to ignore: ");
        while (sc.hasNextLine()) {
            String newLine = sc.nextLine();
            if (newLine.isEmpty()) {
                break;
            }
            ignoreWords.add(newLine.toLowerCase());
        }
        System.out.println("Choose architecutre design. Type 1 for Abstract Data Type and 2 for XXX: ");
        designChoice = sc.nextInt();
        return designChoice;
    }
}
