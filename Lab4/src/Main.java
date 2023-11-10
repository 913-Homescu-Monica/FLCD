import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void scanPrograms() throws IOException {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        System.out.println("p1:");
        lexicalAnalyzer.scanProgram("files/p1.in", "files/p1_ST.out", "files/p1_PIF.out");

        System.out.println("\np1err:");
        lexicalAnalyzer.scanProgram("files/p1err.in", "files/p1err_ST.out", "files/p1err_PIF.out");

        System.out.println("p2:");
        lexicalAnalyzer.scanProgram("files/p2.in", "files/p2_ST.out", "files/p2_PIF.out");

        System.out.println("\np3:");
        lexicalAnalyzer.scanProgram("files/p3.in", "files/p3_ST.out", "files/p3_PIF.out");
    }

    public static void testFA() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFA:\n1 - Identifier\n2 - Integer Constant");
        System.out.println("\nEnter FA option:");
        int faOption = scanner.nextInt();
        String faInputFile = "";
        if (faOption == 1)
            faInputFile = "files/FA_identifier.in";
        else
            faInputFile = "files/FA_integer_constant.in";
        FiniteAutomata fa = new FiniteAutomata(faInputFile);

        System.out.println("\nMenu:\n0 - Exit\n1 - Initial State\n2 - States\n3 - Final States\n4 - Alphabet\n5 - Transitions");
        int menuOption = 0;
        do {
            System.out.println("\nEnter menu option:");
            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1 -> System.out.println("Initial State = " + fa.getInitialState());
                case 2 -> System.out.println("States = " + fa.getStates());
                case 3 -> System.out.println("Final States = " + fa.getFinalStates());
                case 4 -> System.out.println("Alphabet = " + fa.getAlphabet());
                case 5 -> System.out.println("Transitions = " + fa.getTransitions());
            }
        }
        while (menuOption != 0);

        scanner.nextLine();

        String sequence = "";
        do {
            System.out.println("\nEnter sequence to verify: ");
            sequence = scanner.nextLine();
            if (sequence.equals(""))
                break;
            if (fa.isAcceptedByFA(sequence))
                System.out.println("The sequence is accepted by the FA!");
            else
                System.out.println("The sequence is not accepted by the FA!");
        }
        while (true);
    }

    public static void main(String[] args) throws IOException {
        //scanPrograms();
        testFA();
    }
}
