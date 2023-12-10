import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Grammar grammar = new Grammar("g1.txt");

        System.out.println("\nNon-terminals: " + grammar.getNonTerminals());
        System.out.println("Terminals: " + grammar.getTerminals());
        System.out.println("Productions: " + grammar.getProductions());

        if (grammar.checkCFG())
            System.out.println("\nThe grammar is a CFG!");
        else
            System.out.println("\nThe grammar is not a CFG!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPlease enter a non-terminal (or 0 for exit): ");
            String nonTerminal = scanner.nextLine().trim();
            if(Objects.equals(nonTerminal, "0"))
                break;
            System.out.println("The productions for " + nonTerminal + " are: " + grammar.getProductionsForNonTerminal(nonTerminal));
        }*/

        Parser parser = new Parser("g1.txt");

        parser.printFirstSets();
        System.out.println();
        parser.printFollowSets();
    }
}