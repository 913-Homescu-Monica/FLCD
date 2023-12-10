import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grammar {
    private List<String> nonTerminals;
    private List<String> terminals;
    private String startingSymbol;
    private final HashMap<String, List<List<String>>> productions;

    public Grammar(String fileName) {
        nonTerminals = new ArrayList<>();
        terminals = new ArrayList<>();
        startingSymbol = "";
        productions = new HashMap<>();

        readGrammarFile(fileName);
    }

    private List<String> parseLine(String line) {
        // split the line by spaces and trim extra spaces
        String[] parts = line.split("\\s+");
        List<String> symbols = new ArrayList<>();

        for (String part : parts)
            symbols.add(part.trim());

        return symbols;
    }

    private void readGrammarFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // split the first line in the file to get the non-terminals
            nonTerminals = parseLine(br.readLine());
            // split the second line in the file to get the terminals
            terminals = parseLine(br.readLine());
            // read the third line in the file to get the starting symbol
            startingSymbol = br.readLine();

            // parse the remaining lines in the file to get the productions
            String line;
            while ((line = br.readLine()) != null) {
                // split the current line into non-terminal and production list using the arrow index
                int arrowIndex = line.indexOf("->");
                String nonTerminal = line.substring(0, arrowIndex).trim();
                String production = line.substring(arrowIndex + 2).trim();
                List<String> productionList = parseLine(production);

                if (productions.containsKey(nonTerminal)) {
                    // the non-terminal already has associated production lists
                    // add the new production list to the existing ones
                    productions.get(nonTerminal).add(productionList);
                }
                else {
                    // the non-terminal doesn't already have associated production lists
                    // create a new production lists entry and add the new production list to it
                    List<List<String>> productionLists = new ArrayList<>();
                    productionLists.add(productionList);
                    productions.put(nonTerminal, productionLists);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getNonTerminals() {
        return nonTerminals;
    }

    public List<String> getTerminals() {
        return terminals;
    }

    public String getStartingSymbol() {
        return startingSymbol;
    }

    public HashMap<String, List<List<String>>> getProductions() {
        return productions;
    }

    public List<List<String>> getProductionsForNonTerminal(String nonTerminal) {
        return productions.get(nonTerminal);
    }

    public boolean checkCFG() {
        // check if all non-terminals from the productions are present in the non-terminals list
        for (String nonTerminal: productions.keySet())
            if (!nonTerminals.contains(nonTerminal))
                return false;
        return true;
    }
}