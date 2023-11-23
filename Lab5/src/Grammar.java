import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grammar {
    private List<String> nonTerminals;
    private List<String> terminals;
    private String startingSymbol;
    private final HashMap<String, List<String>> productions;
    private final String fileName;

    public Grammar(String fileName) {
        this.nonTerminals = new ArrayList<>();
        this.terminals = new ArrayList<>();
        this.startingSymbol = "";
        this.productions = new HashMap<>();
        this.fileName = fileName;
    }

    private List<String> parseLine(String line) {
        String[] parts = line.split("\\s+");
        List<String> symbols = new ArrayList<>();
        for (String part : parts)
            symbols.add(part.trim());
        return symbols;
    }

    public void readGrammarFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            nonTerminals = parseLine(br.readLine());
            terminals = parseLine(br.readLine());
            startingSymbol = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                int arrowIndex = line.indexOf("->");

                if (arrowIndex != -1) {
                    String nonTerminal = line.substring(0, arrowIndex).trim();
                    String production = line.substring(arrowIndex + 2).trim();

                    if (productions.containsKey(nonTerminal))
                        productions.get(nonTerminal).add(production);
                    else {
                        List<String> productionList = new ArrayList<>();
                        productionList.add(production);
                        productions.put(nonTerminal, productionList);
                    }
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

    public HashMap<String, List<String>> getProductions() {
        return productions;
    }

    public List<String> getProductionsForNonTerminal(String nonTerminal) {
        return productions.get(nonTerminal);
    }

    public boolean checkCFG() {
        for (String nonTerminal: nonTerminals)
            if (productions.get(nonTerminal) == null)
                return false;
        return true;
    }
}